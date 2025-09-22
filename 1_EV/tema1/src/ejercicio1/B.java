package ejercicio1;

import java.util.Scanner;


public class B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Bienvenido al restador de fechas. El formato de una fecha es: dd/MM/yyyy");

        try {
            System.out.println("Escriba la primera fecha");
            String fecha1 = s.nextLine();

            System.out.println("Escriba la segunda fecha");
            String fecha2 = s.nextLine();

            System.out.println("¿Cuál de las 2 fechas será la primera? (Elija 1 o 2)");
            int opcion = 0;
            do { 
                opcion = s.nextInt();
                if (opcion < 1 || opcion > 2) {
                    System.out.println("Elige entre 1 o 2. ");
                }
            } while (opcion < 1 || opcion > 2);
            
            String primera = "";
            String segunda = "";

            switch (opcion) {
                case 1:
                    primera = fecha1;
                    segunda = fecha2;
                    break;
                case 2:
                    primera = fecha2;
                    segunda = fecha1;
                    break;
                default:
                    throw new AssertionError();
            }

            System.out.println("La primera fecha es entonces: " + primera);
            System.out.println("La segunda fecha es entonces: " + segunda);

            int dif = funciones.DifDate(primera, segunda);
            System.out.println("La diferencia de días es: " + dif);

        } catch (ExtraException e) {
            System.out.println("Excepción propia lanzada: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Formato de fechas incorrectas. Error: " + e);
            System.out.println("Cerrando la aplicación.");
        }
    }

    
}

