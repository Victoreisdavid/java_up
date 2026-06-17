package Model.estabelecimento;

import java.io.Serializable;

public class Clinica extends Estabelecimento implements Serializable {

    private String especialidade;

    public Clinica(String nome, String endereco, String especialidade,String cnpj,String id) {
        super(nome, endereco,cnpj,id);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
