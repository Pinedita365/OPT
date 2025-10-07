package ejercicio5;

import java.time.LocalDate;

import ejercicio5.interfaces.EsAlimento;

public class cereales extends producto implements EsAlimento{

    private tipo tipo;
    private LocalDate caducidad;

    public cereales(double marca, double precio, tipo tipo) {
        super(marca, precio);
        this.tipo = tipo;
    }

    
    @Override
    public int getCalorias() {
        return tipo.getValor();
    }


     @Override
    public void setCaducidad(LocalDate fc) {
        this.caducidad = fc;
    }

    @Override
    public LocalDate getCaducidad() {
        return this.caducidad;
    }

    @Override
    public String toString() {
        return "Cereales{marca = " + marca + ", tipoCereal = " + tipo + ", precio = " + precio + ", caducidad = " + caducidad + ", calorias = " + getCalorias() + "}";
    }

    

}
