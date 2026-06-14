package Model.cliente;


import ModelCliente.StatusCliente;

public class Cliente extends modelConta.Conta {
    private ModelCliente.StatusCliente statusConta;


    public Cliente(String id, String nome, String email, String senha, String cpf, String telefone, String endereco, StatusCliente statusConta) {
        super(id, nome, email, senha, cpf, telefone, endereco);
        this.statusConta = statusConta;
    }

    public ModelCliente.StatusCliente getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(ModelCliente.StatusCliente statusConta) {
        this.statusConta = statusConta;
    }
}
