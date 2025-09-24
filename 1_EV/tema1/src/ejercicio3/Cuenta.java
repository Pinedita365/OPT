package ejercicio3;

import java.util.Scanner;

public class Cuenta {
    Scanner s = new Scanner(System.in);
    private String titular;
    private double cantidad;
    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }
    public Cuenta(String titular) {
        this.titular = titular;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public double getCantidad() {
        return cantidad;
    }
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    public double ingresar(){
        System.out.println("Digame cuanto quiere ingresar: ");
        // getCantidad();
        double cant = s.nextDouble();
        if (cant > 0) {
            setCantidad(this.cantidad + cant);
        }
        return this.cantidad;
    }
    public double retirar(){
        System.out.println("Digame cuanto desea retirar: ");
        // getCantidad();
        double cant = s.nextDouble();
        if (this.cantidad < cant) {
            setCantidad(0);
        } else {
            setCantidad(this.cantidad - cant);
        }
        return this.cantidad;
    }
    @Override
    public String toString() {
        return "Gracias por usar el banco " + this.titular + ", su saldo es de " + this.cantidad + "€.";
    }
    
}