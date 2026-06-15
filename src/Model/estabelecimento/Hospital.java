package Model.estabelecimento;

import java.io.Serializable;

public class Hospital extends Estabelecimento implements Serializable {

    private int quantidadeLeitos;

    public Hospital(String nome, String endereco, int quantidadeLeitos,String cnpj,int id) {
        super(nome, endereco,cnpj,id);
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
        System.out.println("CNPJ: " + cnpj);
        System.out.println("ID: " + id);
        System.out.println("Leitos: " + quantidadeLeitos);
    }
}