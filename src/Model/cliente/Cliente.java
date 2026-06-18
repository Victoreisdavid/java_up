package Model.cliente;


import Model.Contrato;
import Model.cliente.StatusCliente;
import Model.conta.Conta;

import java.io.Serializable;

public class Cliente extends Conta implements Serializable, Contrato {
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

    public String DadosFormatados() {
        return """
           Cliente #%s
           Nome: %s
           Email: %s
           CPF: %s
           Telefone: %s
           Endereço: %s
           Status: %s
           """.formatted(this.getId(), this.getNome(), this.getEmail(), this.getCpf(), this.getTelefone(), this.getEndereco(), this.statusConta.name());
    }
}
