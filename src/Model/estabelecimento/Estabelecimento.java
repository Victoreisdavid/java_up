package Model.estabelecimento;

import java.io.Serializable;
import java.util.ArrayList;

public class Estabelecimento implements Serializable {
    protected String cnpj;
    protected String id;
    protected String nome;
    protected String endereco;
    protected ArrayList<Agendamento> agendamentos;
    protected ArrayList<Reembolso> reembolsos;

    public Estabelecimento(String nome, String endereco,String cnpj, String id) {
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
    public String getId(){
        return id;
    }
    public void setId(String id){
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
}