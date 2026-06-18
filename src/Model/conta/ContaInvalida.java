package Model.conta;

public class ContaInvalida extends RuntimeException {
    public ContaInvalida(String message) {
        super(message);
    }
}
