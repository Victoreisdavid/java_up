package ModelEstabelecimento;

public class Clinica extends Estabelecimento {

    private String especialidade;

    public Clinica(String nome, String endereco, String especialidade) {
        super(nome, endereco);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Clínica: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Especialidade: " + especialidade);
    }
}
