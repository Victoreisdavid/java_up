package Model.estabelecimento;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Estabelecimento implements Serializable {
    protected String cnpj;
    protected int id;
    protected String nome;
    protected String endereco;
    protected ArrayList<Agendamento> agendamentos;
    protected ArrayList<Reembolso> reembolsos;

    public Estabelecimento(String nome, String endereco,String cnpj, int id) {
        this.cnpj = cnpj;
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.agendamentos = new ArrayList<>();
        this.reembolsos = new ArrayList<>();
    }

    public String getCnpj(){
        return cnpj;
    }
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
    public int getId(){
        return  id;
    }
    public void setId(int id){
        this.id = id;
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