package View;

import Controller.HospitalController;
import Model.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HospitalView {

    private Scanner sc = new Scanner(System.in);
    private HospitalController controller = new HospitalController();

    public void iniciar() {

        int opcao = -1;

        while(opcao != 0){

            try{

                System.out.println("\n===== HOSPITAL =====");
                System.out.println("1 - Cadastrar Paciente");
                System.out.println("2 - Cadastrar Médico");
                System.out.println("3 - Agendar Consulta");
                System.out.println("4 - Listar Pacientes");
                System.out.println("5 - Listar Médicos");
                System.out.println("6 - Listar Consultas");
                System.out.println("0 - Sair");

                opcao = sc.nextInt();
                sc.nextLine();

                switch(opcao){

                    case 1 -> cadastrarPaciente();
                    case 2 -> cadastrarMedico();
                    case 3 -> agendarConsulta();
                    case 4 -> listarPacientes();
                    case 5 -> listarMedicos();
                    case 6 -> listarConsultas();
                    case 0 -> System.out.println("Encerrando...");
                    default -> System.out.println("Opção inválida");
                }

            } catch(InputMismatchException e){
                System.out.println("Digite apenas números.");
                sc.nextLine();
            } catch(Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private void cadastrarPaciente(){

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();

        System.out.println("Tipo sanguíneo:");

        TipoSanguineo[] tipos = TipoSanguineo.values();

        for(int i = 0; i < tipos.length; i++){
            System.out.println(i + " - " + tipos[i]);
        }

        int escolha = sc.nextInt();

        controller.cadastrarPaciente(
                new Paciente(nome, idade, tipos[escolha])
        );
    }

    private void cadastrarMedico(){

        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();

        System.out.println("Especialidade:");

        Especialidade[] especialidades = Especialidade.values();

        for(int i = 0; i < especialidades.length; i++){
            System.out.println(i + " - " + especialidades[i]);
        }

        int escolha = sc.nextInt();

        controller.cadastrarMedico(
                new Medico(nome,
                        idade,
                        especialidades[escolha])
        );
    }

    private void agendarConsulta(){

        listarPacientes();

        System.out.print("Paciente: ");
        int paciente = sc.nextInt();

        listarMedicos();

        System.out.print("Médico: ");
        int medico = sc.nextInt();

        sc.nextLine();

        System.out.print("Data: ");
        String data = sc.nextLine();

        controller.agendarConsulta(
                paciente,
                medico,
                data
        );
    }

    private void listarPacientes(){

        for(int i = 0; i < controller.getPacientes().size(); i++){

            System.out.println("\nID: " + i);

            controller.getPacientes()
                    .get(i)
                    .exibirDados();
        }
    }

    private void listarMedicos(){

        for(int i = 0; i < controller.getMedicos().size(); i++){

            System.out.println("\nID: " + i);

            controller.getMedicos()
                    .get(i)
                    .exibirDados();
        }
    }

    private void listarConsultas(){

        for(Consulta consulta :
                controller.getConsultas()){

            System.out.println(consulta);
        }
    }
}