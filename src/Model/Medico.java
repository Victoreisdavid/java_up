package Model;

import interfaces.Exibivel;

public class Medico extends Pessoa implements Exibivel {

    private Especialidade especialidade;

    public Medico(String nome, int idade, Especialidade especialidade) {
        super(nome, idade);
        this.especialidade = especialidade;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    @Override
    public void exibirDados() {
        System.out.println("Médico: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Especialidade: " + especialidade);
    }
}