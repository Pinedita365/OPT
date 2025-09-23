package ejercicio2;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digame un valor para la matriz");
        int n = 0;
        do { 
            n = s.nextInt();
        } while (n < 1);
        int[][] matriz = new int[5][n];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = funciones.aleatorio();
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            System.out.println();
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
        }
    }
}
