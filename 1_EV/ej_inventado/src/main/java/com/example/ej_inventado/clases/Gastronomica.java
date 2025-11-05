package com.example.ej_inventado.clases;

public class Gastronomica extends Actividad{

    public String vestimenta;

    public Gastronomica(int id, int duracion, int precio, String nombre, String descripcion, String img,
            String vestimenta) {
        super(id, duracion, precio, nombre, descripcion, img);
        this.vestimenta = vestimenta;
    }

    public Gastronomica(String vestimenta) {
        this.vestimenta = vestimenta;
    }

    public String getVestimenta() {
        return vestimenta;
    }

    public void setVestimenta(String vestimenta) {
        this.vestimenta = vestimenta;
    }

    @Override
    public String getCategoria() {
        return "Actividad gastronomica";
    }

    @Override
    public int getTiempo() {
        return getDuracion()*60;
    }

    @Override
    public String getBreveDesc() {
        if (getDescripcion().length() > 20) {
            return getDescripcion().substring(0,20)+"...";   
        }else{
            return getDescripcion();
        }
    }

    

}
