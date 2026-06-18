package Model.plano;

import Model.cliente.Cliente;
import Model.plano.TipoPlano;

import java.io.Serializable;

public class Plano implements Serializable {
    private String id;
    private String idContaCliente;
    private TipoPlano tipoPlano;
    private Float valorMes;

    private Cliente cliente;

    public Plano(String id, String idContaCliente, TipoPlano tipoPlano, float valorMes) {
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

    public Float getValorMes() {
        return valorMes;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
       return this.cliente;
    }
}
