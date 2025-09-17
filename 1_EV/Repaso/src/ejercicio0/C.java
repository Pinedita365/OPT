package ejercicio0;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digame un número entre 0 y 255");
        int n;
        
        do { 
            n = s.nextInt();
            if (n < 0 || n > 255) {
                System.out.println("El número debe estar comprendido entre 0 y 255");
            }
        } while (n < 0 || n > 255);

        funciones.c(n);

    }
}
