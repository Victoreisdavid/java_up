package modelMedico;

import modelConta.Conta;

public class Medico extends Conta {
    private String crm;
    private StatusMedico status;
    private TipoMedico tipo;

    public Medico(String nome, String email, String senha, String cpf, String telefone, String crm, TipoMedico tipo, StatusMedico status) {
        super(nome, email, senha, cpf, telefone);
        this.crm = crm;
        this.tipo = tipo;
        this.status = status;

    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public void listar() {
        super.listar();
        System.out.println("CRM: " + getCrm());
    }
}
