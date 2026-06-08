package Controllersessao;

import model.modelSessao.Sessao;

public class SessaoController {

    public Sessao criarSessao(String idConta) {

        String idSessao = "S" + System.currentTimeMillis();

        return new Sessao(idSessao, idConta);
    }

    public Sessao editarSessao(Sessao sessao, String novoIdConta) {

        sessao.setIdConta(novoIdConta);

        return sessao;
    }

    public void deletarSessao(String idSessao) {

        System.out.println("Sessão " + idSessao + " deletada com sucesso!");
    }
}