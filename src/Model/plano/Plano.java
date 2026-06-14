package Model.plano;

public class Plano {
    private String id;
    private String idContaCliente;
    private TipoPlano tipoPlano;
    private Float valorMes;

    public Plano(String id, String idContaCliente, Model.plano.TipoPlano tipoPlano, float valorMes) {
        this.id = id;
        this.idContaCliente = idContaCliente;
        this.tipoPlano = tipoPlano;
        this.valorMes = valorMes;
    } 

    public String getId() {
        return id;
    }

    public String getIdContaCliente() {
        return idContaCliente;
    }

    public Model.plano.TipoPlano getTipoPlano() {
        return tipoPlano;
    }

    public float getValorMes() {
        return valorMes;
    }
}
