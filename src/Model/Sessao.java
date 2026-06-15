package Model;

import java.io.Serializable;

public class Sessao implements Serializable {

    private String id;
    private String idConta;

    public Sessao(String id, String idConta) {
        this.id = id;
        this.idConta = idConta;
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


}