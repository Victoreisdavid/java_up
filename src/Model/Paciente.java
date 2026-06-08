package Model;

import interfaces.Exibivel;

public class Paciente extends Pessoa implements Exibivel {

    private TipoSanguineo tipoSanguineo;

    public Paciente(String nome, int idade, TipoSanguineo tipoSanguineo) {
        super(nome, idade);
        this.tipoSanguineo = tipoSanguineo;
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    @Override
    public void exibirDados() {
        System.out.println("Paciente: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Tipo Sanguíneo: " + tipoSanguineo);
    }
}
