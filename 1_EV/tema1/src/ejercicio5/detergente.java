package ejercicio5;

import ejercicio5.interfaces.ConDescuento;
import ejercicio5.interfaces.EsLiquido;

public class detergente extends producto implements EsLiquido, ConDescuento{

private int cant;
private String envase;
private double descuento;

    public detergente(int cant, double marca, double precio) {
        super(marca, precio);
        this.cant = cant;
        this.envase = envase;
        this.descuento = descuento;
    }

    @Override
    public void setVolumen(int v) {
        this.cant = cant;
    }

    @Override
    public int getVolumen() {
        return this.cant;
    }

    @Override
    public void setTipoEnvase(String env) {
        this.envase = envase;
    }

    @Override
    public String getTipoEnvase() {
        return this.envase;
    }

    @Override
    public void setDescuento(double des) {
        this.descuento = descuento;
    }

    @Override
    public double getDescuento() {
        return this.descuento;
    }

    @Override
    public double getPrecioDescuento() {
        return (getPrecio()-(getPrecio()*(getDescuento()*getPrecio())));
    }

    
}
