
package ejercicio3;

public class Boligrafo implements Comparable<Boligrafo>{
    
    protected String marca;
    protected String material;
    protected double precio; 

    public Boligrafo(String marca, String material, double precio) {
        this.marca = marca;
        this.material = material;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Boligrafo{" + "marca=" + marca + ", material=" + material + ", precio=" + precio + '}';
    }
    
    
    @Override
    public int compareTo(Boligrafo o) {
        return this.marca.compareTo(o.marca);
    }
    
    
    
    
}
