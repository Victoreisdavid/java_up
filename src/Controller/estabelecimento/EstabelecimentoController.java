package Controller.estabelecimento;

import Model.conta.Conta;
import Model.estabelecimento.Estabelecimento;
import services.DatabaseService;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EstabelecimentoController {
    public EstabelecimentoController() {
    }

    private String buildFilePath(String id) {
        String baseFilepath = "data/estabelecimentos/";
        baseFilepath += id + ".data";

        return baseFilepath;
    }

    public void salvarEstabelecimento(Estabelecimento estabelecimento) {
        DatabaseService db = new DatabaseService(buildFilePath(estabelecimento.getId()));

        try {
            db.serializeObjectToFile(estabelecimento);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarEstabelecimento(String id) {
        DatabaseService db = new DatabaseService(buildFilePath(id));

        db.deleteFile();
    }

    public Estabelecimento obterEstabelecimento(String id) throws java.io.IOException, ClassNotFoundException {
        DatabaseService db = new DatabaseService(buildFilePath(id));
        Estabelecimento estabelecimento = (Estabelecimento) db.readObjectFromFile();

        return estabelecimento;
    }

    public ArrayList<Estabelecimento> obterEstabelecimentos() {
        File file = new File("data/estabelecimentos");
        File[] files = file.listFiles();
        ArrayList<Estabelecimento> estabelecimentos = new ArrayList<>();


        for (File f: files) {
            if (f.exists()) {
                DatabaseService db = new DatabaseService(f.getPath());

                try {
                    Estabelecimento estabelecimento = (Estabelecimento) db.readObjectFromFile();

                    estabelecimentos.add(estabelecimento);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return estabelecimentos;
    }
}
