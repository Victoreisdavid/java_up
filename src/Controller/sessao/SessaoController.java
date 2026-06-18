package Controller.sessao;

import Model.Sessao;
import Model.receita.Receita;
import services.DatabaseService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SessaoController {
    private static String databasePath = "data/sessoes/";

    public SessaoController() {

    }

    private String buildFilePath(String id) {
        String baseFilepath = databasePath;
        baseFilepath += id + ".data";

        return baseFilepath;
    }

    public void salvarSessao(Sessao sessao) throws IOException {
        DatabaseService db = new DatabaseService(buildFilePath(sessao.getId()));

        db.serializeObjectToFile(sessao);
    }

    public void deletarSessao(String id) {
        DatabaseService db = new DatabaseService(buildFilePath(id));

        db.deleteFile();
    }

    public Sessao obterSessao(String id) throws java.io.IOException, ClassNotFoundException {
        DatabaseService db = new DatabaseService(buildFilePath(id));
        Sessao sessao = (Sessao) db.readObjectFromFile();

        return sessao;
    }

    public ArrayList<Sessao> obterSessoes() throws IOException, ClassNotFoundException {
        File file = new File(databasePath);
        File[] files = file.listFiles();
        ArrayList<Sessao> sessoes = new ArrayList<>();

        if(files == null) {
            return sessoes;
        }

        for (File f: files) {
            if (f.exists()) {
                String sessoesID = f.getName().split("\\.")[0];

                try {
                    Sessao sessao = this.obterSessao(sessoesID);

                    sessoes.add(sessao);
                } catch (IOException | ClassNotFoundException e) {
                    throw e;
                }
            }
        }

        return sessoes;
    }
}
