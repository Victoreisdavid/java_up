package View;

import ModelPlano.Plano;
import ModelPlano.TipoPlano;

    public class PlanoView {

        public Plano obterPlano(String idPlano) {

            Plano plano = new Plano(
                    "1",
                    "10",
                    TipoPlano.BASICO,
                    99.90f
            );

            return plano;
        }
    }

