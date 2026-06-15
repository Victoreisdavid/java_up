import View.users.RegistryView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RegistryView view = new RegistryView();

        view.Saudar();

        while (true) {
            view.MenuInicial(sc);
        }
    }

}