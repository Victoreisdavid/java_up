package ModelEstabelecimento;

public class Reembolso {

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
