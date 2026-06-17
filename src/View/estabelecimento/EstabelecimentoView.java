package View.estabelecimento;

import Controller.estabelecimento.EstabelecimentoController;
import Controller.users.RegistryController;
import Model.cliente.Cliente;
import Model.conta.Conta;
import Model.estabelecimento.Clinica;
import Model.estabelecimento.Estabelecimento;
import Model.estabelecimento.Hospital;
import Model.medico.Medico;
import Utils.EscolhaOpcao;
import services.IDService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EstabelecimentoView {
    private final EstabelecimentoController estabelecimentoController = new EstabelecimentoController();

    public EstabelecimentoView() {

    }

    public void criarEstabelecimento(Scanner sc) throws Exception {
        System.out.println("Qual o nome do estabelecimento?");
        String nome = sc.nextLine();

        System.out.println("Qual o CNPJ do estabelecimento");
        String cnpj = sc.nextLine();

        System.out.println("Qual o email?");
        String email = sc.nextLine();

        System.out.println("Qual o endereço do estabelecimento?");
        String endereco = sc.nextLine();

        System.out.println("Escolha o tipo de estabelecimento:");
        System.out.println("1. Clinica");
        System.out.println("2. Hospital");

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

        Estabelecimento finalEstabelecimento = null;

        if (finalOption == 1) {
            System.out.println("Qual a especialidade da clinica?");
            String especialidade = sc.nextLine();

            finalEstabelecimento = new Clinica(
                    nome,
                    endereco,
                    especialidade,
                    cnpj,
                    id
            );
        } else {
            System.out.println("Qual a quantidade de leitos do hospital?");
            int quantidadeLeitos = 0;

            while (true) {
                try {
                    int quantidade = sc.nextInt();
                    quantidadeLeitos = quantidade;
                } catch (InputMismatchException _) {
                    System.out.println("digite um numero valido");
                }

                sc.nextLine();
                break;
            }

            finalEstabelecimento = new Hospital(
                    nome,
                    endereco,
                    quantidadeLeitos,
                    cnpj,
                    id
            );
        }

        this.estabelecimentoController.salvarEstabelecimento(finalEstabelecimento);
    }

    public void listarEstabelecimentos() {
        System.out.println("-".repeat(25));

        ArrayList<Estabelecimento> estabelecimentos = this.estabelecimentoController.obterEstabelecimentos();

        for (Estabelecimento estabelecimento: estabelecimentos) {
            String label = "";

            if (estabelecimento instanceof Clinica _) {
                label = "Clinica";
            } else if (estabelecimento instanceof Hospital _) {
                label = "Hospistal";
            }

            System.out.printf("%s #%s\n", label, estabelecimento.getId());
            System.out.printf("Nome: %s\n", estabelecimento.getNome());
            System.out.printf("Endereço: %s\n", estabelecimento.getEndereco());

            if (estabelecimento instanceof Clinica clinica) {
                System.out.printf("Especialidade: %s\n", clinica.getEspecialidade());
            } else if (estabelecimento instanceof Hospital hospital) {
                System.out.printf("Quantidade de leitos %d\n", hospital.getQuantidadeLeitos());
            }

            System.out.printf("%s - %s\n", "=".repeat(25), "=".repeat(25));
        }
    }

    public void deletarEstabelecimento(Scanner sc) {
        System.out.println("Digite o ID do estabelecimento");
        String id = sc.nextLine();

        this.estabelecimentoController.deletarEstabelecimento(id);
        System.out.println("Operação concluída.");
    }
}
