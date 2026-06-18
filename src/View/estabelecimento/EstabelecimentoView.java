package View.estabelecimento;

import Controller.estabelecimento.EstabelecimentoController;
import Controller.plano.PlanoController;
import Controller.users.RegistryController;
import Model.cliente.Cliente;
import Model.conta.Conta;
import Model.conta.ContaInvalida;
import Model.estabelecimento.*;
import Model.medico.Medico;
import Model.plano.Plano;
import Model.plano.TipoPlano;
import Utils.EscolhaOpcao;
import services.IDService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EstabelecimentoView {
    private final EstabelecimentoController estabelecimentoController;
    private final PlanoController planoController;
    private final RegistryController registryController;

    public EstabelecimentoView(EstabelecimentoController estabelecimentoController, PlanoController planoController, RegistryController registryController) {
        this.estabelecimentoController = estabelecimentoController;
        this.planoController = planoController;
        this.registryController = registryController;
    }

    public void criarEstabelecimento(Scanner sc) throws Exception {
        System.out.println("Qual o nome do estabelecimento?");
        String nome = sc.nextLine();

        System.out.println("Qual o CNPJ do estabelecimento");
        String cnpj = sc.nextLine();

        System.out.println("Qual o endereço do estabelecimento?");
        String endereco = sc.nextLine();

        System.out.println("Qual o plano mínimo coberto pelo estabelecimento?");
        System.out.println("1. Básico");
        System.out.println("2. Normal");
        System.out.println("3. Avançado");

        TipoPlano plano;

        while (true) {
            int planoEscolhido = Utils.EscolhaOpcao.escolhaOpcoes(sc);

            if(planoEscolhido == 1) {
                plano = TipoPlano.BASICO;
            } else if(planoEscolhido == 2) {
                plano = TipoPlano.NORMAL;
            } else if(planoEscolhido == 3) {
                plano = TipoPlano.AVANCADO;
            } else {
                System.out.println("Opção inválida. Escolha novamente.");
                continue;
            }

            break;
        }

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
                    id,
                    plano
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
                    id,
                    plano
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

    public void criarAgendamento(Scanner sc) throws Exception {
        System.out.println("Qual o ID do cliente?");
        String clienteID = sc.nextLine();

        Conta cliente = registryController.obterUsuario(clienteID);

        if (cliente == null) {
            System.out.println("O cliente não existe.");
            return;
        }

        if (cliente instanceof Medico) {
            System.out.println("Médicos não podem ter plano.");
            return;
        }

        Plano plano = planoController.obterPlanoDoCliente(clienteID);

        if (plano == null) {
            System.out.println("Nenhum plano encontrado para o cliente");
            return;
        }

        System.out.println("Qual o ID do estabelecimento");
        String estabelecimentoID = sc.nextLine();

        Estabelecimento estabelecimento = estabelecimentoController.obterEstabelecimento(estabelecimentoID);

        if (estabelecimento == null) {
            System.out.println("Estabelecimento não encontrado.");
            return;
        }

        if(plano.getTipoPlano().getValor() < estabelecimento.getPlanoCoberto().getValor()) {
            System.out.println("O plano do cliente não é coberto pelo estabelecimento.");
            return;
        }

        System.out.println("Qual a data do agendamento?");
        String data = sc.nextLine();

        System.out.println("Qual o horário do agentamento?");
        String horario = sc.nextLine();

        String id = IDService.generateID();

        try {
            Agendamento finalAgendamento = new Agendamento(
                    id,
                    clienteID,
                    estabelecimentoID,
                    data,
                    horario
            );

            this.estabelecimentoController.salvarAgendamento(finalAgendamento);
        } catch (EstabelecimentoInvalido _) {
            System.out.println("O estabelecimento informado não existe.");
        } catch (ContaInvalida _) {
            System.out.println("A conta do cliente não existe.");
        } catch (Exception e) {
            System.out.println("Aconteceu um erro. Tente novamente.");
        }
    }

    public void listarAgendamentos() {
        System.out.println("-".repeat(25));

        ArrayList<Agendamento> agendamentos = this.estabelecimentoController.obterAgendamentos();

        for (Agendamento agendamento: agendamentos) {
            Estabelecimento estabelecimento = agendamento.getEstabelecimento();
            Cliente paciente = agendamento.getPaciente();

            System.out.printf("Agendamento #%s\n", agendamento.getId());
            System.out.printf("Data: %s\n", agendamento.getData());
            System.out.printf("Horário: %s\n", agendamento.getHorario());

            if(estabelecimento == null) {
                System.out.println("Estabelecimento não encontrado");
            } else {
                System.out.printf("Estabelecimento: %s (#%s)\n", estabelecimento.getNome(), estabelecimento.getId());
            }

            if(paciente == null) {
                System.out.println("Paciente: não encontrado");
            } else {
                System.out.printf("Paciente: %s (#%s)\n", paciente.getNome(), paciente.getId());
            }

            System.out.printf("%s - %s\n", "=".repeat(25), "=".repeat(25));
        }
    }

    public void deletarAgendamento(Scanner sc) {
        System.out.println("Digite o ID do agendamento");
        String id = sc.nextLine();

        this.estabelecimentoController.deletarAgentamento(id);
        System.out.println("Operação concluída.");
    }
}
