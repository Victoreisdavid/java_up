package ModelEstabelecimento;

public class Agendamento {

    private String paciente;
    private String data;
    private String horario;

    public Agendamento(String paciente, String data, String horario) {
        this.paciente = paciente;
        this.data = data;
        this.horario = horario;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }
}
