package ejercicio1;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digame dos cadenas de carácteres");
        String c1 , c2;
        c1 = s.nextLine();
        c2 = s.nextLine();

        System.out.println("str1 = " + c1 + " str2 = " + c2 + ", out1 = "  + funciones.a(c2, c1) + " out2 = " + funciones.a(c1, c2));
    
    }
}
