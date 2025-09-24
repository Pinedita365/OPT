package ejercicio2;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] array = new int[10];
        System.out.println("Digame 5 números de manera ordenada (crecientemente)");
        for (int i = 0; i < 5; i++) {
            array[i] = s.nextInt();
        }
        System.out.println("Lista: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println((i + 1) + ". " + array[i]);
        }
        int cont = 5;
        do { 
            System.out.println("Digame un número más y lo pondre dentro de la lista: ");
            array[cont] = s.nextInt();
            System.out.println("Lista actual: ");
            for (int i = 0; i < array.length; i++) {
                System.out.println((i + 1) + ". " + array[i]);
            }
            cont++;
        } while (cont < 10);
        funciones.MetodoBurbuja(array);
        System.out.println("Lista compleatada.");
        for (int i = 0; i < array.length; i++) {
                System.out.println((i + 1) + ". " + array[i]);
            }

    }
}
