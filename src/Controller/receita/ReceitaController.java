package Controller.receita;

import Controller.users.RegistryController;
import Model.cliente.Cliente;
import Model.conta.Conta;
import Model.conta.ContaInvalida;
import Model.plano.Plano;
import Model.receita.Receita;
import services.DatabaseService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ReceitaController {
    private static String databasePath = "data/receitas/";

    public ReceitaController() {

    }

    private String buildFilePath(String id) {
        String baseFilepath = databasePath;
        baseFilepath += id + ".data";

        return baseFilepath;
    }

    public void salvarReceita(Receita receita) throws IOException {
        DatabaseService db = new DatabaseService(buildFilePath(receita.getId()));

        db.serializeObjectToFile(receita);
    }

    public void deletarReceita(String id) {
        DatabaseService db = new DatabaseService(buildFilePath(id));

        db.deleteFile();
    }

    public Receita obterReceita(String id) throws java.io.IOException, ClassNotFoundException {
        DatabaseService db = new DatabaseService(buildFilePath(id));
        Receita receita = (Receita) db.readObjectFromFile();

        if (!db.fileExists()) {
            return null;
        }

        return receita;
    }

    public ArrayList<Receita> obterReceitas() throws IOException, ClassNotFoundException {
        File file = new File(databasePath);
        File[] files = file.listFiles();
        ArrayList<Receita> receitas = new ArrayList<>();

        if(files == null) {
            return receitas;
        }

        for (File f: files) {
            if (f.exists()) {
                String receitaID = f.getName().split("\\.")[0];

                try {
                    Receita receita = this.obterReceita(receitaID);

                    receitas.add(receita);
                } catch (IOException | ClassNotFoundException e) {
                    throw e;
                }
            }
        }

        return receitas;
    }

}
