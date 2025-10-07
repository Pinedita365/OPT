package ejercicio5;

public class producto {
    protected double precio;
    protected double marca;

    public producto(double marca, double precio) {
        this.marca = marca;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getMarca() {
        return marca;
    }

    public void setMarca(double marca) {
        this.marca = marca;
    }

    


}
