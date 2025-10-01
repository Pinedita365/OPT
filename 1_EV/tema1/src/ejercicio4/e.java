package ejercicio4;

import java.util.ArrayList;
import java.util.Scanner;

public class e {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<String> arra = new ArrayList<>();
        arra.add("HALA");
        arra.add("ADIO");
        arra.add("FIUMBA");

        for (String string : arra) {
            System.out.println(string);
        }

        System.out.println("Digame que quiere poner en el segundo puesto de la lista");
        arra.set(1, s.next());

        for (String string : arra) {
            System.out.println(string);
        }

    }
}
