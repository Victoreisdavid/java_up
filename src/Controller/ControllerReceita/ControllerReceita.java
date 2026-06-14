package Controller.ControllerReceita;

import Model.receita.Receita;

import java.util.ArrayList;
import java.util.HashMap;

public class ControllerReceita {

    private HashMap<String, Receita> bancoReceitas = new HashMap<>();

    public void salverReceita(Receita novaReceita) {
        bancoReceitas.put(novaReceita.getId(), novaReceita);


    }

    public ArrayList<Receita> LocalizarReceitaPorMedico(String idContaMedico) {

        ArrayList<Receita> receitas = new ArrayList<>();

        for (Receita r : bancoReceitas.values()) {
            if (r.getIdContaMedico().equals(idContaMedico)) {
                receitas.add(r);
            }
        }
        return receitas;
    }

    public ArrayList<Receita> LocalizarReceitaPorCliente(String idCliente) {
        ArrayList<Receita> receitas = new ArrayList<>();

        for (Receita r : bancoReceitas.values()) {
            if (r.getIdCliente().equals(idCliente)) {
                receitas.add(r);
            }
        }
        return receitas;
    }

    public Receita LocalizarReceitaUnitaria(String idReceita) {
        return bancoReceitas.get(idReceita);
    }

    public Receita MudarDadosReceitaidContaMedico(String idReceita, String novoidContaMedico) {
       Receita receitaAchada = LocalizarReceitaUnitaria(idReceita);

        if (receitaAchada != null) {
            receitaAchada.setIdContaMedico(novoidContaMedico);
            return receitaAchada;
        }
        return null;
    }
    public Receita MudarDadosReceitaidCliente(String idReceita, String novoidCliente) {
        Receita receitaAchada = LocalizarReceitaUnitaria(idReceita);

        if (receitaAchada != null) {
            receitaAchada.setIdCliente(novoidCliente);
            return receitaAchada;
        }
        return null;
    }

    public Receita MudarDadosReceitadescriTexto(String idReceita, String novodescriTexto) {
        Receita receitaAchada = LocalizarReceitaUnitaria(idReceita);

        if (receitaAchada != null) {
            receitaAchada.setDescriTexto(novodescriTexto);
            return receitaAchada;
        }
        return null;
    }
}


