import Controller.estabelecimento.EstabelecimentoController;
import Controller.plano.PlanoController;
import Controller.receita.ReceitaController;
import Controller.sessao.SessaoController;
import Controller.users.RegistryController;
import Utils.EscolhaOpcao;
import View.estabelecimento.EstabelecimentoView;
import View.plano.PlanoView;
import View.receita.ReceitaView;
import View.sessao.SessaoView;
import View.users.RegistryView;

import java.util.Scanner;

public class Main {

    public static void Saudar() {
        System.out.println("=== BEM-VINDO ===");
    }

    public static void menuOpcoes() {
        System.out.println("Selecione uma opção:");
        System.out.println("1. Registrar conta");
        System.out.println("2. Listar médicos");
        System.out.println("3. Listar clientes");
        System.out.println("4. Deletar conta");
        System.out.println("5. Adicionar estabelecimento");
        System.out.println("6. Listar estabelecimentos");
        System.out.println("7. Deletar estabelecimentos");
        System.out.println("8. Criar agendamento");
        System.out.println("9. Listar agendamento");
        System.out.println("10. Deletar agendamento");
        System.out.println("11. Criar plano");
        System.out.println("12. Deletar plano");
        System.out.println("13. Criar receita");
        System.out.println("14. Listar receitas");
        System.out.println("15. Deletar receita");
        System.out.println("16. Criar sessão");
        System.out.println("17. Listar sessões");
        System.out.println("18. Deletar sessão");
        System.out.println("19. Sair");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RegistryController registryController = new RegistryController();
        PlanoController planoController = new PlanoController(registryController);
        EstabelecimentoController estabelecimentoController = new EstabelecimentoController();
        ReceitaController receitaController = new ReceitaController();
        SessaoController sessaoController = new SessaoController();

        RegistryView view = new RegistryView(registryController);
        EstabelecimentoView estabelecimentos = new EstabelecimentoView(
                estabelecimentoController,
                planoController,
                registryController
        );
        PlanoView planoView = new PlanoView(planoController, registryController);
        ReceitaView receitaView = new ReceitaView(receitaController, registryController);
        SessaoView sessaoView = new SessaoView(sessaoController, registryController, estabelecimentoController);

        Saudar();

        while (true) {
            menuOpcoes();
            int opt = EscolhaOpcao.escolhaOpcoes(sc);

            if (opt == 1) {
                try {
                    view.criarUsuario(sc);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (opt == 2) {
                view.listarMedicos();
            } else if (opt == 3) {
                view.listarClientes();
            } else if (opt == 4) {
                view.deletarConta(sc);
            } else if (opt == 5) {
                try {
                    estabelecimentos.criarEstabelecimento(sc);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (opt == 6) {
                estabelecimentos.listarEstabelecimentos();
            } else if (opt == 7) {
                estabelecimentos.deletarEstabelecimento(sc);
            } else if (opt == 8) {
                try {
                    estabelecimentos.criarAgendamento(sc);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if(opt == 9) {
                estabelecimentos.listarAgendamentos();
            } else if(opt == 10) {
                estabelecimentos.deletarAgendamento(sc);
            } else if (opt == 11) {
                try {
                    planoView.criarPlano(sc);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if (opt == 12) {
                planoView.deletarPlano(sc);
            } else if(opt == 13) {
                try {
                    receitaView.criarReceita(sc);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if(opt == 14) {
                receitaView.listarReceitas();
            } else if(opt == 15) {
                receitaView.deletarReceita(sc);
            } else if(opt == 16) {
                try {
                    sessaoView.criarSessao(sc);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if(opt == 17) {
                sessaoView.listarSessoes();
            } else if(opt == 18) {
                sessaoView.deletarSessao(sc);
            } else if(opt == 19) {
                break;
            }
        }
    }
}