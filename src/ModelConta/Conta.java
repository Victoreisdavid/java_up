package ModelConta;



public class Conta {
    private String nome;
    private String email;
    private String Senha;
    private String cpf;
    private String telefone;

    public Conta(String nome, String email, String senha, String cpf, String telefone) {
        this.nome = nome;
        this.email = email;
        Senha = senha;
        this.cpf = cpf;
        this.telefone = telefone;
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

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void listar(){
        System.out.println("Nome:" +this.getNome());
        System.out.println("Email:" +this.getEmail());
        System.out.println("Senha:" +this.getSenha() );
        System.out.println("CPF:" +this.getCpf());
        System.out.println("Telefone:" +this.getTelefone());
    }
}
