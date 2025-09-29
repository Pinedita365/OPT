package ejercicio3;

import java.util.Scanner;

public class app3 {
    public static String pedirCode(String mensaje){
        Scanner s = new Scanner(System.in);
        System.out.println(mensaje);
        return s.next();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Bienvenido al gestor de facturas.\n\nIntroduzca 5 facturas: ");
        System.out.println("Factura 1: ");
        Factura f1 = new Factura(Integer.parseInt(pedirCode("Codigo del producto: ")), Double.parseDouble(pedirCode("Cantidad vendida (en litros): ")), Double.parseDouble(pedirCode("Precio: ")));
        Factura f2 = new Factura(Integer.parseInt(pedirCode("Codigo del producto: ")), Double.parseDouble(pedirCode("Cantidad vendida (en litros): ")), Double.parseDouble(pedirCode("Precio: ")));
        Factura f3 = new Factura(Integer.parseInt(pedirCode("Codigo del producto: ")), Double.parseDouble(pedirCode("Cantidad vendida (en litros): ")), Double.parseDouble(pedirCode("Precio: ")));
        Factura f4 = new Factura(Integer.parseInt(pedirCode("Codigo del producto: ")), Double.parseDouble(pedirCode("Cantidad vendida (en litros): ")), Double.parseDouble(pedirCode("Precio: ")));
        Factura f5 = new Factura(Integer.parseInt(pedirCode("Codigo del producto: ")), Double.parseDouble(pedirCode("Cantidad vendida (en litros): ")), Double.parseDouble(pedirCode("Precio: ")));
        System.out.println("\n\nFacturación total: " + Factura.getCont() + "€\nCantidad de litros vendidos del art 1: " + f1.litros() + "l\nNúmero de facturas mayores a 600€: " + Factura.getMx());
    }
}
