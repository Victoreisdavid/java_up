package Model;

public class Consulta {

    private Paciente paciente;
    private Medico medico;
    private String data;

    public Consulta(Paciente paciente, Medico medico, String data) {
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
    }

    @Override
    public String toString() {
        return paciente.getNome()
                + " | "
                + medico.getNome()
                + " | "
                + data;
    }
}