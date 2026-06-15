package Model.estabelecimento;
import java.io.Serializable;

public class Reembolso implements Serializable{

    private double valor;
    private String motivo;

    public Reembolso(double valor, String motivo) {
        this.valor = valor;
        this.motivo = motivo;
    }

    public double getValor() {
        return valor;
    }

    public String getMotivo() {
        return motivo;
    }
}
