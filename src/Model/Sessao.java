package Model;

import java.io.Serializable;

public class Sessao implements Serializable {

    private String id;
    private String idConta;
    private String idEstabelecimento;
    private String idAgendamento;

    public Sessao(String id, String idConta, String idEstabelecimento, String idAgendamento) {
        this.id = id;
        this.idConta = idConta;
        this.idEstabelecimento = idEstabelecimento;
        this.idAgendamento = idAgendamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdConta() {
        return idConta;
    }

    public void setIdConta(String idConta) {
        this.idConta = idConta;
    }

    public String getIdEstabelecimento() { return this.idEstabelecimento; }

    public void setIdEstabelecimento(String idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    public String getIdAgendamento() { return this.idAgendamento; }

    public void setIdAgendamento(String idAgendamento) {
        this.idAgendamento = idAgendamento;
    }
}