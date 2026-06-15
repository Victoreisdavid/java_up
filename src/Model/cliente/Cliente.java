package Model.cliente;


import Model.cliente.StatusCliente;
import Model.conta.Conta;

public class Cliente extends Conta {
    private StatusCliente statusConta;

    public Cliente(String id, String nome, String email, String senha, String cpf, String telefone, String endereco) {
        super(id, nome, email, senha, cpf, telefone, endereco);
    }
    public StatusCliente getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(Model.cliente.StatusCliente statusConta) {
        this.statusConta = statusConta;
    }
}
