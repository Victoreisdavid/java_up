package Main;       // main do sessao

import Controllersessao.SessaoController;
import viewsessao.SessaoView;
import ModelSessao.Sessao;

public class teste {

    public static void main(String[] args) {

        SessaoController controller = new SessaoController();
        SessaoView view = new SessaoView();

        Sessao sessao = controller.criarSessao("C001");

        view.mostrarSessao(sessao);

        controller.editarSessao(sessao, "C002");

        System.out.println("\nApós edição:");
        view.mostrarSessao(sessao);

        controller.deletarSessao(sessao.getId());
    }
}