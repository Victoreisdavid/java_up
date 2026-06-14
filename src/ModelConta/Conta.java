package ModelConta;


import java.io.Serializable;

public class Conta implements Serializable {
    private String nome;
    private String email;
    private String Senha;
    private String cpf;
    private String telefone;
    private String endereco;

    public Conta(String nome, String email, String senha, String cpf, String telefone, String endereco) {
        this.nome = nome;
        this.email = email;
        Senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void listar(){
        System.out.println("Nome:" +this.getNome());
        System.out.println("Email:" +this.getEmail());
        System.out.println("Senha:" +this.getSenha() );
        System.out.println("CPF:" +this.getCpf());
        System.out.println("Telefone:" +this.getTelefone());
        System.out.println("Endereco: "+this.getEndereco());
    }
}
