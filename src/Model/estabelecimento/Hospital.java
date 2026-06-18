package Model.estabelecimento;

import Model.plano.TipoPlano;

import java.io.Serializable;

public class Hospital extends Estabelecimento implements Serializable {

    private int quantidadeLeitos;

    public Hospital(String nome, String endereco, int quantidadeLeitos, String cnpj, String id, TipoPlano planoCoberto) {
        super(nome, endereco,cnpj,id, planoCoberto);
        this.quantidadeLeitos = quantidadeLeitos;
    }

    public int getQuantidadeLeitos() {
        return quantidadeLeitos;
    }

    public void setQuantidadeLeitos(int quantidadeLeitos) {
        this.quantidadeLeitos = quantidadeLeitos;
    }
}