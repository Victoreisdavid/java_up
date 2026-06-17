import Utils.EscolhaOpcao;
import View.estabelecimento.EstabelecimentoView;
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
        System.out.println("8. Sair");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RegistryView view = new RegistryView();
        EstabelecimentoView estabelecimentos = new EstabelecimentoView();

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
                break;
            }
        }
    }
}