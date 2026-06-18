package Model.plano;

public enum TipoPlano {
     BASICO(1),   // Consulta com médico e dentista.
     NORMAL(2),    //  Consulta com médico, dentista e clínico geral.
     AVANCADO(3); //   Consulta com médico, dentista, clínico geral e pediatra.

     private final int valor;

     TipoPlano(int valor) {
          this.valor = valor;
     }

     public int getValor() {
          return this.valor;
     }
}
