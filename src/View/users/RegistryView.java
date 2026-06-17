package View.users;

import Controller.users.RegistryController;
import Model.cliente.Cliente;
import Model.conta.Conta;
import Model.medico.Medico;
import Model.medico.StatusMedico;
import Model.medico.TipoMedico;
import Utils.EscolhaOpcao;
import services.IDService;

import java.util.ArrayList;
import java.util.Scanner;

public class RegistryView {
    private final RegistryController registryController = new RegistryController();

    public RegistryView() {

    }

    public void criarUsuario(Scanner sc) throws Exception {
        System.out.println("Qual o nome do usuário?");
        String nome = sc.nextLine();

        System.out.println("Qual o email?");
        String email = sc.nextLine();

        System.out.println("Qual o cpf?");
        String cpf = sc.nextLine();

        System.out.println("Qual o telefone?");
        String telefone = sc.nextLine();

        System.out.println("Qual o endereço?");
        String endereco = sc.nextLine();

        System.out.println("Escolha o tipo de conta:");
        System.out.println("1. Cliente");
        System.out.println("2. Médico");

        int finalOption = -1;

        while(true) {
            int option = EscolhaOpcao.escolhaOpcoes(sc);

            if (option == 1 || option == 2) {
                finalOption = option;
                break;
            } else {
                continue;
            }
        }

        String id = IDService.generateID();

        Conta finalConta = null;

        if (finalOption == 1) {
            finalConta = new Cliente(
                    id,
                    nome,
                    email,
                    cpf,
                    telefone,
                    endereco
            );
        } else {
            System.out.println("Qual o CRM do médico?");
            String crm = sc.nextLine();

            System.out.println("Qual o tipo de médico?");
            System.out.println("1. Cardiologista");
            System.out.println("2. Dentista");
            System.out.println("3. Clinico Geral");
            System.out.println("4. Pediatra");

            finalOption = -1;

            while(true) {
                int option = EscolhaOpcao.escolhaOpcoes(sc);

                if (option >= 1 && option <= 4) {
                    finalOption = option;
                    break;
                } else {
                    continue;
                }
            }

            TipoMedico tipo = null;

            if(finalOption == 1) {
                tipo = TipoMedico.CARDIOLOGISTA;
            } else if (finalOption == 2) {
                tipo = TipoMedico.DENTISTA;
            } else if (finalOption == 3) {
                tipo = TipoMedico.CLINICO_GERAL;
            } else if (finalOption == 4) {
                tipo = TipoMedico.PEDIATRA;
            }

            finalConta = new Medico(
                    id,
                    nome,
                    email,
                    cpf,
                    telefone,
                    endereco,
                    crm,
                    StatusMedico.ATIVO,
                    tipo
            );
        }

        this.registryController.salvarUsuario(finalConta);
    }

    public void listarMedicos() {
        System.out.println("-".repeat(25));

        ArrayList<Conta> contas = this.registryController.obterUsuarios();

        for (Conta conta: contas) {
            if (conta instanceof Medico medico) {
                System.out.printf("Médico #%s\n", medico.getId());
                System.out.printf("Nome: %s\n", medico.getNome());
                System.out.printf("Email: %s\n", medico.getEmail());
                System.out.printf("CPF: %s\n", medico.getCpf());
                System.out.printf("Telefone: %s\n", medico.getTelefone());
                System.out.printf("Endereço: %s\n", medico.getEndereco());
                System.out.printf("CRM: %s\n", medico.getCrm());
                System.out.printf("Tipo de medico: %s\n", medico.getTipo().toString());

                System.out.printf("%s - %s\n", "=".repeat(25), "=".repeat(25));
            }
        }
    }

    public void listarClientes() {
        System.out.println("-".repeat(25));
        ArrayList<Conta> contas = this.registryController.obterUsuarios();

        for (Conta conta: contas) {
            if (conta instanceof Cliente cliente) {
                System.out.printf("Cliente #%s\n", cliente.getId());
                System.out.printf("Nome: %s\n", cliente.getNome());
                System.out.printf("Email: %s\n", cliente.getEmail());
                System.out.printf("CPF: %s\n", cliente.getCpf());
                System.out.printf("Telefone: %s\n", cliente.getTelefone());
                System.out.printf("Endereço: %s\n", cliente.getEndereco());

                System.out.printf("%s - %s\n", "=".repeat(25), "=".repeat(25));
            }
        }
    }

    public void deletarConta(Scanner sc) {
        System.out.println("Digite o ID da conta.");
        String id = sc.nextLine();

        this.registryController.deletarUsuario(id);
        System.out.println("Operação concluída.");
    }
}
