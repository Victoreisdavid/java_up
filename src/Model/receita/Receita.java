package Model.receita;
import java.io.Serializable;
import java.util.ArrayList;

public class Receita implements Serializable {
        private String id;
        private String idContaMedico;
        private String idCliente;
        private String descriTexto;

    public Receita(String id, String idContaMedico, String idCliente, String descriTexto) {
        this.id = id;
        this.idContaMedico = idContaMedico;
        this.idCliente = idCliente;
        this.descriTexto = descriTexto;
    }

    public String getDescriTexto() {
        return descriTexto;
    }

    public void setDescriTexto(String descriTexto) {
        this.descriTexto = descriTexto;
    }

    public String getId() {
            return id;
        }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdContaMedico() {
        return idContaMedico;
    }

    public void setIdContaMedico(String idContaMedico) {
        this.idContaMedico = idContaMedico;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
}

