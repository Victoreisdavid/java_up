package Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EscolhaOpcao {
    public static int escolhaOpcoes(Scanner sc) {
        while (true) {
            try {
                int opt = sc.nextInt();
                sc.nextLine();
                return opt;
            } catch (InputMismatchException _) {
                System.out.println("Escolha uma opção válida");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
