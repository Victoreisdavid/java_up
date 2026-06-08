package viewsessao;

import ModelSessao.Sessao;

public class SessaoView {

    public void mostrarSessao(Sessao sessao) {
        System.out.println("ID Sessão: " + sessao.getId());
        System.out.println("ID Conta: " + sessao.getIdConta());
    }
}