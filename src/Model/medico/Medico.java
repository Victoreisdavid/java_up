package Model.medico;
import Model.Contrato;
import Model.conta.Conta;

import java.io.Serializable;

public class Medico extends Conta implements Serializable, Contrato {

    private String crm;
    private Model.medico.StatusMedico status;
    private Model.medico.TipoMedico tipo;

    public Medico(String id, String nome, String email, String cpf, String telefone, String endereco, String crm, StatusMedico status, TipoMedico tipo) {
        super(id, nome, email, cpf, telefone, endereco);
        this.crm = crm;
        this.status = status;
        this.tipo = tipo;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public StatusMedico getStatus() {
        return status;
    }

    public void setStatus(StatusMedico status) {
        this.status = status;
    }

    public TipoMedico getTipo() {
        return tipo;
    }

    public void setTipo(TipoMedico tipo) {
        this.tipo = tipo;
    }

    @Override
    public String DadosFormatados() {
        return """
           Cliente #%s
           Nome: %s
           Email: %s
           CPF: %s
           Telefone: %s
           Endereço: %s
           CRM: %s
           """.formatted(this.getId(), this.getNome(), this.getEmail(), this.getCpf(), this.getTelefone(), this.getEndereco(), this.crm);
    }
}
