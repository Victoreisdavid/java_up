package Controller;

import Model.*;

import java.util.ArrayList;

public class HospitalController {

    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Medico> medicos = new ArrayList<>();
    private ArrayList<Consulta> consultas = new ArrayList<>();

    public void cadastrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void cadastrarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void agendarConsulta(int indicePaciente,
                                int indiceMedico,
                                String data) {

        Consulta consulta = new Consulta(
                pacientes.get(indicePaciente),
                medicos.get(indiceMedico),
                data
        );

        consultas.add(consulta);
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }
}