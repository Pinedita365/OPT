
package ejercicio3;

public class Telefono implements Comparable<Telefono>{
    
    protected String nombre;
    protected int precio;

    public Telefono(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    

    @Override
    public String toString() {
        return nombre + " " + precio + "€";
    }

    @Override
    public int compareTo(Telefono o) {
        if (this.getNombre().equals(o.getNombre())) {
            return this.getPrecio() - o.getPrecio();
        }else{
            return this.nombre.compareTo(o.nombre);
        }        
    }
    
    
}
