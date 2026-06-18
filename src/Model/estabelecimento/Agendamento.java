package Model.estabelecimento;
import Model.cliente.Cliente;

import java.io.Serializable;

public class Agendamento implements Serializable{

    private String id;
    private String pacienteID;
    private String estabelecimentoID;
    private String data;
    private String horario;

    private Estabelecimento estabelecimento;
    private Cliente paciente;

    public Agendamento(String id, String pacienteID, String estabelecimentoID, String data, String horario) {
        this.id = id;
        this.pacienteID = pacienteID;
        this.estabelecimentoID = estabelecimentoID;
        this.data = data;
        this.horario = horario;
    }

    public String getId() { return id; }

    public String getPacienteID() {
        return pacienteID;
    }

    public String getEstabelecimentoID() { return estabelecimentoID; }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Estabelecimento getEstabelecimento() {
        return this.estabelecimento;
    }

    public void setPaciente(Cliente paciente) {
        this.paciente = paciente;
    }

    public Cliente getPaciente() {
        return this.paciente;
    }
}
