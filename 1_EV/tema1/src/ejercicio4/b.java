package ejercicio4;

import java.util.ArrayList;

public class b {
    public static void main(String[] args) {
        ArrayList<String> arra = new ArrayList<>();
        arra.add("HOLA");
        arra.add("ADIO");
        arra.add("FIUMBA");

        for (String string : arra) {
            System.out.println(string);
        }

        for (int i = 0; i < arra.size(); i++) {
            arra.remove(i);
        }

        for (String string : arra) {
            System.out.println(string);;
        }
        System.out.println("To borrao");

    }
}
