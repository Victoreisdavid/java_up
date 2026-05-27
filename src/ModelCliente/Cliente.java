package ModelCliente;

import ModelConta.Conta;

public class Cliente extends Conta {
    private StatusCliente statusConta;


    public Cliente(String nome, String email, String senha, String cpf, String telefone, String endereco) {

        super(nome, email, senha, cpf, telefone, endereco);
    }

    public StatusCliente getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(StatusCliente statusConta) {
        this.statusConta = statusConta;
    }
}
