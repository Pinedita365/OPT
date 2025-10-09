package ejercicio5;

import java.time.LocalDate;
import java.util.ArrayList;

public class tienda {
    public static void main(String[] args) {
        ArrayList<producto> productos = new ArrayList<>();
        productos.add(new cereales(1.0, 2.5, tipo.avena, LocalDate.of(2026, 11, 23)));
        productos.add(new cereales(1.1, 3.0, tipo.maiz, LocalDate.of(2025, 11, 24)));
        productos.add(new cereales(1.2, 3.5, tipo.trigo, LocalDate.of(2027, 12, 13)));
        productos.add(new cereales(1.3, 4.0, tipo.chocolate, LocalDate.of(2028, 12, 13)));

        productos.add(new detergente(500, 2.0, 5.0,"Plastico",2)); // volumen, marca, precio
        productos.add(new detergente(1000, 2.5, 6.0,"Plastico",10));
        productos.add(new detergente(750, 1.8, 4.5,"Carton",15));

        productos.add(new vino(5.0, 10.0, "Tinto", 12));
        productos.add(new vino(6.0, 12.0, "Blanco", 11));
        productos.add(new vino(4.5, 8.5, "Rosado", 10));

        
        for (producto producto : productos) {
            System.out.println(producto);
        }
        double total = 0;
        for (producto producto : productos) {
            total += producto.getPrecio();
        }
        System.out.println("Total: " + total);

        System.out.println("\nDetergentes: ");
        ArrayList<detergente> dt = new ArrayList<>();

        dt.add(new detergente(500, 2.0, 5.0,"Plastico",2)); 
        dt.add(new detergente(1000, 2.5, 6.0,"Plastico",10));
        dt.add(new detergente(750, 1.8, 4.5,"Carton",15));

        for (detergente detergente : dt) {
            System.out.println(detergente);
        }

       
        double totalDesc = 0;
        for (detergente detergente : dt) {
            totalDesc = detergente.getDescuento();
        }
        System.out.println("Descuento total detergentes: " + totalDesc + "%");
    }
}
