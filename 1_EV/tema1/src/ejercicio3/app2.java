package ejercicio3;

import java.util.Scanner;

public class app2 {
    public static String pedirCode(String mensaje){
        Scanner s = new Scanner(System.in);
        System.out.println(mensaje);
        return s.next();
    }
    public static String pedirCode2(String mensaje){
        Scanner s = new Scanner(System.in);
        System.out.println(mensaje);
        int menu = 0;
        do { 
            menu = s.nextInt();
        } while (menu < 0 || menu > 3);
        switch (menu) {
            case 1:
                return "0.60";
            case 2:
                return "3.00";
            case 3:
                return "1.25";
        }
        return s.next();
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Bienvenido al gestor de facturas.\n\nIntroduzca 5 facturas: ");
        System.out.println("Factura 1: ");
        Factura f1 = new Factura(Integer.parseInt(pedirCode("Codigo del producto: ")), Double.parseDouble(pedirCode("Cantidad vendida (en litros): ")), Double.parseDouble(pedirCode2("Elija un precio (1. 0,6€, 2. 3€, 3. 1,25€): ")));
        Factura f2 = new Factura(Integer.parseInt(pedirCode("Codigo del producto: ")), Double.parseDouble(pedirCode("Cantidad vendida (en litros): ")), Double.parseDouble(pedirCode2("Elija un precio (1. 0,6€, 2. 3€, 3. 1,25€): ")));
        Factura f3 = new Factura(Integer.parseInt(pedirCode("Codigo del producto: ")), Double.parseDouble(pedirCode("Cantidad vendida (en litros): ")), Double.parseDouble(pedirCode2("Elija un precio (1. 0,6€, 2. 3€, 3. 1,25€): ")));
        Factura f4 = new Factura(Integer.parseInt(pedirCode("Codigo del producto: ")), Double.parseDouble(pedirCode("Cantidad vendida (en litros): ")), Double.parseDouble(pedirCode2("Elija un precio (1. 0,6€, 2. 3€, 3. 1,25€): ")));
        Factura f5 = new Factura(Integer.parseInt(pedirCode("Codigo del producto: ")), Double.parseDouble(pedirCode("Cantidad vendida (en litros): ")), Double.parseDouble(pedirCode2("Elija un precio (1. 0,6€, 2. 3€, 3. 1,25€): ")));
        System.out.println("\n\nFacturación total: " + Factura.getCont() + "€\nCantidad de litros vendidos del art 1: " + f1.litros() + "l\nNúmero de facturas mayores a 600€: " + Factura.getMx());
    }
}
