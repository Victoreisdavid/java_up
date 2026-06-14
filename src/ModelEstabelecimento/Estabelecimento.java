package ModelEstabelecimento;

import java.util.ArrayList;

public abstract class Estabelecimento {

    protected String nome;
    protected String endereco;
    protected ArrayList<Agendamento> agendamentos;
    protected ArrayList<Reembolso> reembolsos;

    public Estabelecimento(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.agendamentos = new ArrayList<>();
        this.reembolsos = new ArrayList<>();
    }

    public void adicionarAgendamento(Agendamento agendamento) {
        agendamentos.add(agendamento);
    }

    public void adicionarReembolso(Reembolso reembolso) {
        reembolsos.add(reembolso);
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public ArrayList<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public ArrayList<Reembolso> getReembolsos() {
        return reembolsos;
    }

    public abstract void exibirInformacoes();
}