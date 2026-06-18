package Controller.users;

import Model.cliente.Cliente;
import Model.conta.Conta;
import services.DatabaseService;
import services.LoggerService;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RegistryController {
    public RegistryController() {
    }

    private String buildFilePath(String id) {
        String baseFilepath = Conta.databasePath;
        baseFilepath += id + ".data";

        return baseFilepath;
    }

    public void salvarUsuario(Conta conta) {
        DatabaseService db = new DatabaseService(buildFilePath(conta.getId()));

        try {
            db.serializeObjectToFile(conta);

            LoggerService.log(
                    String.format("Conta criada com o ID #%s", conta.getId())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarUsuario(String id) {
        DatabaseService db = new DatabaseService(buildFilePath(id));

        LoggerService.log(
                String.format("Conta deletada com o ID #%s", id)
        );

        db.deleteFile();
    }

    public Conta obterUsuario(String id) throws java.io.IOException, ClassNotFoundException {
        DatabaseService db = new DatabaseService(buildFilePath(id));

        LoggerService.log(
                String.format("Conta obtida com o ID #%s", id)
        );

        if (!db.fileExists()) {
            return null;
        }

        Conta user = (Conta) db.readObjectFromFile();

        return user;
    }

    public ArrayList<Conta> obterUsuarios() {
        File file = new File("data/users");
        File[] files = file.listFiles();
        ArrayList<Conta> contas = new ArrayList<Conta>();

        LoggerService.log("Lista de usuários obtida");

        if (files == null) {
            return contas;
        }

        for (File f: files) {
            if (f.exists()) {
                DatabaseService db = new DatabaseService(f.getPath());

                try {
                    Conta conta = (Conta) db.readObjectFromFile();

                    contas.add(conta);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return contas;
    }
}
