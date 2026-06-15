package Model.cliente;


import Model.cliente.StatusCliente;
import Model.conta.Conta;

import java.io.Serializable;

public class Cliente extends Conta implements Serializable {
    private StatusCliente statusConta;

    public Cliente(String id, String nome, String email, String cpf, String telefone, String endereco) {
        super(id, nome, email, cpf, telefone, endereco);

        this.statusConta = StatusCliente.ATIVO;
    }
    public StatusCliente getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(Model.cliente.StatusCliente statusConta) {
        this.statusConta = statusConta;
    }
}
