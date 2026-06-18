package View.receita;

import Controller.plano.PlanoController;
import Controller.receita.ReceitaController;
import Controller.users.RegistryController;
import Model.cliente.Cliente;
import Model.conta.Conta;
import Model.medico.Medico;
import Model.plano.Plano;
import Model.plano.TipoPlano;
import Model.receita.Receita;
import services.IDService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReceitaView {
    private final ReceitaController receitaController;
    private final RegistryController registryController;

    public ReceitaView(ReceitaController receitaController, RegistryController registryController) {
        this.receitaController = receitaController;
        this.registryController = registryController;
    }

    public void criarReceita(Scanner sc) throws Exception {
        System.out.println("Qual o ID do médico autor da receita?");
        String medicoID = sc.nextLine();

        Conta medico = this.registryController.obterUsuario(medicoID);

        if (medico == null) {
            System.out.println("Médico não encontrado");
            return;
        }

        if (medico instanceof Cliente) {
            System.out.println("o ID informado pertence a um cliente.");
            return;
        }

        System.out.println("Qual o ID do cliente?");
        String clienteID = sc.nextLine();

        Conta cliente = this.registryController.obterUsuario(clienteID);

        if (cliente == null) {
            System.out.println("Cliente não encontrado");
            return;
        }

        if (cliente instanceof Medico) {
            System.out.println("o ID informado pertence a um médico.");
            return;
        }

        System.out.println("Descreva a receita passada pelo médico.");
        System.out.println("Você pode enviar várias linhas. Aperte enter sem digitar nada para concluir.");
        StringBuilder buffer = new StringBuilder();
        String linha;

        while (sc.hasNextLine()) {
            linha = sc.nextLine();

            if (linha.isEmpty()) {
                break;
            }

            buffer.append(linha).append("\n");
        }

        String descri = buffer.toString();
        String id = IDService.generateID();

        Receita finalReceita = new Receita(
                id,
                medicoID,
                clienteID,
                descri
        );

        this.receitaController.salvarReceita(finalReceita);
    }

    public void listarReceitas() {
        System.out.println("-".repeat(25));

        try {
            ArrayList<Receita> receitas = this.receitaController.obterReceitas();

            for (Receita receita: receitas) {
                Conta cliente = this.registryController.obterUsuario(receita.getIdCliente());
                Medico medico = (Medico) this.registryController.obterUsuario(receita.getIdContaMedico());

                System.out.printf("Receita #%s\n", receita.getId());

                if(medico != null) {
                    System.out.printf("Médico: %s (#%s)\n", medico.getNome(), medico.getId());
                    System.out.printf("CRM: %s\n", medico.getCrm());
                } else {
                    System.out.println("Médico não encontrado.");
                }

                if(cliente != null) {
                    System.out.printf("Cliente: %s (#%s)\n", cliente.getNome(), cliente.getId());
                } else {
                    System.out.println("Cliente não encontrado.");
                }

                System.out.println("-".repeat(25));
                System.out.println("Conteúdo da receita:");
                System.out.println(receita.getDescriTexto());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarReceita(Scanner sc) {
        System.out.println("Digite o ID da receita?");
        String id = sc.nextLine();

        this.receitaController.deletarReceita(id);
        System.out.println("Operação concluída.");
    }
}
