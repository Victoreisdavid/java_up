package Model.receita;
import java.io.Serializable;
import java.util.ArrayList;

public class Receita implements Serializable {

        private String id;
        private String idContaMedico;
        private String idCliente;
        private String descriTexto;
        private ArrayList<String> conteudos ;

    public Receita(String id, String idContaMedico, String idCliente, String descriTexto, ArrayList<String> conteudos) {
        this.id = id;
        this.idContaMedico = idContaMedico;
        this.idCliente = idCliente;
        this.descriTexto = descriTexto;
        this.conteudos = conteudos;
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

        public ArrayList<String> getConteudos() {
            return conteudos;
        }

        public void setConteudos(ArrayList<String> conteudos) {
            this.conteudos = conteudos;
        }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
}

