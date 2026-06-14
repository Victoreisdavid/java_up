package ModelEstabelecimento;

public class Hospital extends Estabelecimento {

    private int quantidadeLeitos;

    public Hospital(String nome, String endereco, int quantidadeLeitos) {
        super(nome, endereco);
        this.quantidadeLeitos = quantidadeLeitos;
    }

    public int getQuantidadeLeitos() {
        return quantidadeLeitos;
    }

    public void setQuantidadeLeitos(int quantidadeLeitos) {
        this.quantidadeLeitos = quantidadeLeitos;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Hospital: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Leitos: " + quantidadeLeitos);
    }
}