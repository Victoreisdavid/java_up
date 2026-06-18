package Controller.estabelecimento;

import Model.cliente.Cliente;
import Model.conta.Conta;
import Model.conta.ContaInvalida;
import Model.estabelecimento.Agendamento;
import Model.estabelecimento.Estabelecimento;
import Model.estabelecimento.EstabelecimentoInvalido;
import services.DatabaseService;
import services.LoggerService;

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

    private String buildAgendamentoFilePath(String id) {
        String baseFilepath = "data/estabelecimentos/agendamentos/";
        baseFilepath += id + ".data";

        return baseFilepath;
    }

    private String buildCliente(String id) {
        String baseFilepath = Conta.databasePath;
        baseFilepath += id + ".data";

        return baseFilepath;
    }

    public void salvarEstabelecimento(Estabelecimento estabelecimento) {
        DatabaseService db = new DatabaseService(buildFilePath(estabelecimento.getId()));

        try {
            db.serializeObjectToFile(estabelecimento);
            LoggerService.log(
                    String.format("Estabelecimento criado com o ID #%s", estabelecimento.getId())
            );
        } catch (IOException e) {
            LoggerService.log(
                    String.format("Erro ao criar estabelecimento com o ID #%s", estabelecimento.getId())
            );
            throw new RuntimeException(e);
        }
    }

    public void deletarEstabelecimento(String id) {
        DatabaseService db = new DatabaseService(buildFilePath(id));

        db.deleteFile();

        LoggerService.log(
                String.format("Estabelecimento deletado com o ID #%s", id)
        );
    }

    public Estabelecimento obterEstabelecimento(String id) throws java.io.IOException, ClassNotFoundException {
        DatabaseService db = new DatabaseService(buildFilePath(id));
        Estabelecimento estabelecimento = (Estabelecimento) db.readObjectFromFile();

        LoggerService.log(
                String.format("Estabelecimento obtido o ID #%s", estabelecimento.getId())
        );

        if (!db.fileExists()) {
            return null;
        }

        return estabelecimento;
    }

    public ArrayList<Estabelecimento> obterEstabelecimentos() {
        File file = new File("data/estabelecimentos");
        File[] files = file.listFiles();
        ArrayList<Estabelecimento> estabelecimentos = new ArrayList<>();

        LoggerService.log("Lista de estabelecimentos obtida");

        if (files == null) {
            return estabelecimentos;
        }

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

    public void salvarAgendamento(Agendamento agendamento) throws EstabelecimentoInvalido, IOException {
        DatabaseService db = new DatabaseService(buildAgendamentoFilePath(agendamento.getId()));
        DatabaseService eDb = new DatabaseService(buildFilePath(agendamento.getEstabelecimentoID()));
        DatabaseService pcDb = new DatabaseService(buildCliente(agendamento.getPacienteID()));

        LoggerService.log(
                String.format("Agendamento criado com o id #%s", agendamento.getId())
        );

        if (!eDb.fileExists()) {
            throw new EstabelecimentoInvalido("Estabelecimento não existe");
        }

        if (!pcDb.fileExists()) {
            throw new ContaInvalida("A conta do paciente não existe");
        }

        db.serializeObjectToFile(agendamento);
    }

    public Agendamento obterAgendamento(String id) throws IOException, ClassNotFoundException {
        DatabaseService db = new DatabaseService(buildAgendamentoFilePath(id));
        Agendamento agendamento = (Agendamento) db.readObjectFromFile();

        LoggerService.log(
                String.format("Agendamento obtido com o ID #%s", agendamento.getId())
        );

        if (!db.fileExists()) {
            return null;
        }

        return agendamento;
    }

    public ArrayList<Agendamento> obterAgendamentos() {
        File agendamentosDir = new File("data/estabelecimentos/agendamentos");
        File[] agendamentoFiles = agendamentosDir.listFiles();
        ArrayList<Agendamento> agendamentos = new ArrayList<>();

        LoggerService.log("Lista de agendamentos obtida");

        for (File af: agendamentoFiles) {
            if (af.exists()) {
                DatabaseService db = new DatabaseService(af.getPath());
                try {
                    Agendamento agendamento = (Agendamento) db.readObjectFromFile();

                    DatabaseService agDb = new DatabaseService(buildFilePath(agendamento.getEstabelecimentoID()));
                    DatabaseService pcDb = new DatabaseService(buildCliente(agendamento.getPacienteID()));

                    try {
                        Estabelecimento estabelecimento = (Estabelecimento) agDb.readObjectFromFile();

                        agendamento.setEstabelecimento(estabelecimento);
                    } catch (Exception _) {
                        // do nothing
                    }

                    try {
                        Cliente cliente = (Cliente) pcDb.readObjectFromFile();

                        agendamento.setPaciente(cliente);
                    } catch (Exception _) {
                        // do nothing2
                    }

                    agendamentos.add(agendamento);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return agendamentos;
    }

    public void deletarAgentamento(String id) {
        DatabaseService db = new DatabaseService(buildAgendamentoFilePath(id));

        db.deleteFile();

        LoggerService.log(
                String.format("Agendamento deletado com o ID #%s", id)
        );
    }

}
