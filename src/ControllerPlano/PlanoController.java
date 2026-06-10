package ControllerPlano;

import ModelPlano.Plano;
import ModelPlano.TipoPlano;

public class PlanoController {

    public Plano obterPlano(String idPlano) {

        return new Plano(
                idPlano,
                "C001",
                TipoPlano.NORMAL,
                49.90f
        );
    }
}