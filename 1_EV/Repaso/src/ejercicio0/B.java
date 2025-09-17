package ejercicio0;
import java.util.Scanner;
public class B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digame un número y te dire la suma de los impares que contiene");
        int n = s.nextInt();
        System.out.println(funciones.b(n));
    }
}
