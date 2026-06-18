package View.plano;

import Controller.plano.PlanoController;
import Controller.users.RegistryController;
import Model.cliente.Cliente;
import Model.conta.Conta;
import Model.medico.Medico;
import Model.medico.StatusMedico;
import Model.medico.TipoMedico;
import Model.plano.Plano;
import Model.plano.TipoPlano;
import Utils.EscolhaOpcao;
import services.IDService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlanoView {
    private final PlanoController planoController;
    private final RegistryController registryController;

    public PlanoView(PlanoController planoController, RegistryController registryController) {
        this.planoController = planoController;
        this.registryController = registryController;
    }

    public void criarPlano(Scanner sc) throws Exception {
        System.out.println("Qual o ID do cliente?");
        String clienteID = sc.nextLine();

        Conta cliente = this.registryController.obterUsuario(clienteID);
        Plano planoAtual = this.planoController.obterPlanoDoCliente(clienteID);

        if(planoAtual != null) {
            System.out.printf("O cliente já possui um plano. Para mudar, delete o atual: #%s\n", planoAtual.getId());
            return;
        }

        if (cliente == null) {
            System.out.println("Conta do cliente não encontrada.");
            return;
        }

        if (cliente instanceof Medico) {
            System.out.println("Médicos não podem ter plano.");
            return;
        }

        System.out.println("Qual o tipo do plano?");
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

        System.out.println("Quanto o cliente paga por mês?");

        float valorMensal = sc.nextFloat();
        sc.nextLine();

        String id = IDService.generateID();

        Plano finalPlano = new Plano(
            id,
            clienteID,
            plano,
            valorMensal
        );

        this.planoController.salvarPlano(finalPlano);
    }

    public void listarPlanos() {
        System.out.println("-".repeat(25));

        try {
            ArrayList<Plano> planos = this.planoController.obterPlanos();

            for (Plano plano: planos) {
                Cliente cliente = plano.getCliente();

                System.out.printf("Plano #%s\n", plano.getId());

                if(cliente != null) {
                    System.out.printf("Cliente: %s (#%s)\n", cliente.getNome(), cliente.getId());
                } else {
                    System.out.println("Cliente não encontrado.");
                }

                System.out.printf("Tipo de plano: %s\n", plano.getTipoPlano().name());
                System.out.printf("Valor mensal: %.2f\n", plano.getValorMes());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarPlano(Scanner sc) {
        System.out.println("Digite o ID do plano?");
        String id = sc.nextLine();

        this.planoController.deletarPlano(id);
        System.out.println("Operação concluída.");
    }
}
