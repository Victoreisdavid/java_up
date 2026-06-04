package viewConta;

import modelConta.Conta;
import java.util.Scanner;

public class ContaView {


    public Conta criarConta(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.println("Email:");
        String email = sc.nextLine();

        System.out.println("Senha:");
        String senha = sc.nextLine();

        System.out.println("CPF:");
        String cpf = sc.nextLine();

        System.out.println("Telefone:");
        String telefone = sc.nextLine();

        Conta dados = new Conta(nome, email, senha, cpf, telefone);


        sc.close();
        return dados;
    }

}