package View.sessao;

import Controller.estabelecimento.EstabelecimentoController;
import Controller.receita.ReceitaController;
import Controller.sessao.SessaoController;
import Controller.users.RegistryController;
import Model.Sessao;
import Model.cliente.Cliente;
import Model.conta.Conta;
import Model.estabelecimento.Agendamento;
import Model.estabelecimento.Estabelecimento;
import Model.medico.Medico;
import Model.receita.Receita;
import services.IDService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SessaoView {
    private final RegistryController registryController;
    private final SessaoController sessaoController;
    private final EstabelecimentoController estabelecimentoController;

    public SessaoView(SessaoController sessaoController, RegistryController registryController, EstabelecimentoController estabelecimentoController) {
        this.sessaoController = sessaoController;
        this.registryController = registryController;
        this.estabelecimentoController = estabelecimentoController;
    }

    public void criarSessao(Scanner sc) throws Exception {
        System.out.println("Qual o ID do médico autor do cliente?");
        String clienteID = sc.nextLine();

        Conta conta = this.registryController.obterUsuario(clienteID);

        if (conta == null) {
            System.out.println("Cliente não encontrado");
            return;
        }

        if (conta instanceof Medico) {
            System.out.println("o ID informado pertence a um medico.");
            return;
        }

        System.out.println("Informe o ID do estabelecimento");
        String estabelecimentoID = sc.nextLine();

        Estabelecimento estabelecimento = this.estabelecimentoController.obterEstabelecimento(estabelecimentoID);

        if (estabelecimento == null) {
            System.out.println("Estabelecimento não encontrado.");
            return;
        }

        System.out.println("Informe o ID do agendamento utilizado.");
        String agendamentoID = sc.nextLine();

        Agendamento agendamento = this.estabelecimentoController.obterAgendamento(agendamentoID);

        if (agendamento == null) {
            System.out.println("Agendamento não encontrado.");
            return;
        }

        String id = IDService.generateID();

        Sessao finalSessao = new Sessao(
            id,
            clienteID,
            estabelecimentoID,
            agendamentoID
        );

        this.sessaoController.salvarSessao(finalSessao);
    }

    public void listarSessoes() {
        System.out.println("-".repeat(25));

        try {
            ArrayList<Sessao> sessoes = this.sessaoController.obterSessoes();

            for (Sessao sessao: sessoes) {
                Conta cliente = this.registryController.obterUsuario(sessao.getIdConta());
                Agendamento agendamento = this.estabelecimentoController.obterAgendamento(sessao.getIdAgendamento());
                Estabelecimento estabelecimento = this.estabelecimentoController.obterEstabelecimento(sessao.getIdEstabelecimento());

                System.out.printf("Sessao #%s\n", sessao.getId());

                if(agendamento != null) {
                    System.out.printf("Derivado do agendamento #%s\n", sessao.getIdAgendamento());
                } else {
                    System.out.println("Agendamento não encontrado.");
                }

                if(estabelecimento != null) {
                    System.out.printf("Estabelecimento: %s (#%s)\n", estabelecimento.getNome(), sessao.getIdEstabelecimento());
                } else {
                    System.out.println("Estabelecimento não encontrado.");
                }

                if(cliente != null) {
                    System.out.printf("Cliente: %s (#%s)\n", cliente.getNome(), cliente.getId());
                } else {
                    System.out.println("Cliente não encontrado.");
                }
            }

            System.out.println("-".repeat(25));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarSessao(Scanner sc) {
        System.out.println("Digite o ID da sessao");
        String id = sc.nextLine();

        this.sessaoController.deletarSessao(id);
        System.out.println("Operação concluída.");
    }
}
