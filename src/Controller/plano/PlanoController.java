package Controller.plano;

import Controller.users.RegistryController;
import Model.cliente.Cliente;
import Model.conta.Conta;
import Model.conta.ContaInvalida;
import Model.plano.Plano;
import services.DatabaseService;
import services.LoggerService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PlanoController {
    private final RegistryController registryController;

    private static String databasePath = "data/planos/";

    public PlanoController(RegistryController registryController) {
        this.registryController = registryController;
    }

    private String buildFilePath(String id) {
        String baseFilepath = databasePath;
        baseFilepath += id + ".data";

        return baseFilepath;
    }

    private String buildClienteFilePath(String id) {
        String baseFilepath = Conta.databasePath;
        baseFilepath += id + ".data";

        return baseFilepath;
    }

    public void salvarPlano(Plano plano) throws ContaInvalida, IOException {
        DatabaseService db = new DatabaseService(buildFilePath(plano.getId()));
        DatabaseService cDb = new DatabaseService(buildClienteFilePath(plano.getIdContaCliente()));

        LoggerService.log(
                String.format("Plano criado com o ID #%s", plano.getId())
        );

        if (!cDb.fileExists()) {
            throw new ContaInvalida("A conta não existe");
        }

        db.serializeObjectToFile(plano);
    }

    public void deletarPlano(String id) {
        DatabaseService db = new DatabaseService(buildFilePath(id));

        db.deleteFile();

        LoggerService.log(
                String.format("Plano deletado com o ID #%s", id)
        );
    }

    public Plano obterPlano(String id) throws java.io.IOException, ClassNotFoundException {
        DatabaseService db = new DatabaseService(buildFilePath(id));
        Plano plano = (Plano) db.readObjectFromFile();

        LoggerService.log(
                String.format("Plano obtido com o ID #%s", plano.getId())
        );

        if (!db.fileExists()) {
            return null;
        }

        if(plano != null) {
            DatabaseService eDb = new DatabaseService(buildClienteFilePath(plano.getIdContaCliente()));

            Cliente cliente = (Cliente) eDb.readObjectFromFile();

            if (cliente != null) {
                plano.setCliente(cliente);
            }
        }

        return plano;
    }

    public ArrayList<Plano> obterPlanos() throws IOException, ClassNotFoundException {
        File file = new File(databasePath);
        File[] files = file.listFiles();
        ArrayList<Plano> planos = new ArrayList<Plano>();

        LoggerService.log("Lista de planos obtida");

        if(files == null) {
            return planos;
        }

        for (File f: files) {
            if (f.exists()) {
                String planoID = f.getName().split("\\.")[0];

                try {
                    Plano plano = this.obterPlano(planoID);

                    planos.add(plano);
                } catch (IOException | ClassNotFoundException e) {
                    throw e;
                }
            }
        }

        return planos;
    }

    public Plano obterPlanoDoCliente(String clienteID) throws IOException, ClassNotFoundException {
        ArrayList<Plano> planos = this.obterPlanos();

        LoggerService.log(
                String.format("Plano do cliente #%s pesquisado no banco de dados", clienteID)
        );

        for(Plano plano: planos) {
            Cliente cliente = plano.getCliente();

            if (cliente.getId().equals(clienteID)) {
                return plano;
            }
        }

        return null;
    }
}
