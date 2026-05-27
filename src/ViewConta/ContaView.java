package ViewConta;

import ControllerConta.ContaController;
import ModelConta.Conta;
import java.util.Scanner;

public class ContaView {

   public String formatarConta(Conta conta){
       StringBuilder dados = new StringBuilder();
       dados.append("Nome: ").append(conta.getNome());
       dados.append("\nEmail: ").append(conta.getEmail());
       dados.append("\nCPF: ").append(conta.getCpf());
       dados.append("\nTelefone: ").append(conta.getTelefone());
       dados.append("\nEndereço: ").append(conta.getEndereco());

       return dados.toString();
   }


}