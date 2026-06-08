package ControllerConta;

import ModelConta.Conta;

import java.util.Scanner;

public class ContaController {
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

        System.out.println("Endereco:");
        String endereco = sc.nextLine();

        Conta dados = new Conta(nome, email, senha, cpf, telefone,endereco);


        sc.close();
        return dados;
    }
}
