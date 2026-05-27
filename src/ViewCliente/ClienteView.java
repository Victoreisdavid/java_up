package ViewCliente;

import ModelCliente.Cliente;
import ModelCliente.StatusCliente;
import ModelConta.Conta;

public class ClienteView {
    public String formatarCliente(Cliente cliente){
        StringBuilder dados = new StringBuilder();
        dados.append("Tipo de conta do cliente: ");

        StatusCliente status = cliente.getStatusConta();

        if (status == StatusCliente.Ativo){
            dados.append("Ativo");
        } else if (status == StatusCliente.Cancelado) {
            dados.append("Cancelado");
        }else if (status == StatusCliente.Suspenso){
            dados.append("Suspenso");
        }else{
            dados.append("Desconhecido");
        }

        return dados.toString();
    }
}
