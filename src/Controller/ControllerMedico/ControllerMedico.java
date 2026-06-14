package Controller.ControllerMedico;

import Model.medico.Medico;

import java.util.ArrayList;
import java.util.HashMap;

public class ControllerMedico {
    private HashMap<String, Medico> bancoMedico = new HashMap<>();

    public void salvarMedico(Medico novoMedico) {
        bancoMedico.put(novoMedico.getId(), novoMedico);
    }

    public Medico localizarMedicoPorCrm(String crmMedico) {
        for (Medico m : bancoMedico.values()) {
            if (m.getCrm().equals(crmMedico))
                return m;

        }
        return null;
    }
    public ArrayList<Medico> LocalizarMedicoPorNome(String nomeMedico) {
        ArrayList<Medico> medicos = new ArrayList<>();
        for (Medico m : bancoMedico.values()) {
            if (m.getNome().equals(nomeMedico))
                medicos.add(m);
        }
        return medicos;
    }

    public Medico localizarMedicoPorId(String idMedico) {
        return bancoMedico.get(idMedico);
    }

}
