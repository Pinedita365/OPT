package ejercicio3;

import java.util.Scanner;

public class app1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Bienvenido al banco. Introduzca su nombre y apellidos: ");
        Cuenta c1 = new Cuenta(s.nextLine());
        int menu = 0;
        do { 
            System.out.println(c1.getTitular() + ", su saldo es de " + c1.getCantidad() + "€. \n¿Qué desea hacer?\n1. Ingresar dinero\n2. Retirar dinero\n3. Salir");
            menu = s.nextInt();
        if (menu == 1) {
            c1.ingresar();
        } else if(menu == 2){
            c1.retirar();
        }
        
        } while (menu == 1 || menu == 2);
        System.out.println(c1.toString());
    }
}
