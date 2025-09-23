package ejercicio2;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digame un valor para crear una matriz cuadrada: ");
        int v = s.nextInt();
        int[][] m1 = new int[v][v];
        int[][] m2 = new int[v][v];
        System.out.println("Para la matriz 1: ");
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                System.out.println("Digame que valor quiere para la fila " + i + " y para la columna " + j + ": ");
                m1[i][j] = s.nextInt();
            }
        }
        System.out.println("Para la matriz 2: ");
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[0].length ; j++) {
                System.out.println("Digame que valor quiere para la fila " + i + " y para la columna " + j + ": ");
                m2[i][j] = s.nextInt();
            }
        }
        System.out.print("Matriz 1: ");
        for (int i = 0; i < m1.length; i++) {
            System.out.println();
            for (int j = 0; j < m1.length; j++) {
                System.out.print(m1[i][j] + " ");
            }
        }
        System.out.println();
        System.out.print("Matriz 2: ");
        for (int i = 0; i < m2.length; i++) {
            System.out.println();
            for (int j = 0; j < m2.length; j++) {
                System.out.print(m2[i][j] + " ");
            }
        }
        int[][] m3 = new int[v][v];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
            }
            
        }
        System.out.print("\nMatriz 3: ");
        for (int i = 0; i < m3.length; i++) {
            System.out.println();
            for (int j = 0; j < m3[0].length; j++) {
                System.out.print(m3[i][j] + " ");
            }
            
        }
    }
}
