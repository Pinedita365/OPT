package com.example.ej_inventado.clases;

public class Turistica extends Actividad{

    public boolean vehiculo;



    public Turistica(Tipo tipo,int duracion, int precio, String ciudad, String nombre, String descripcion, String img,
            boolean vehiculo) {
        super(tipo,duracion, precio, ciudad, nombre, descripcion, img);
        this.vehiculo = vehiculo;
    }

    public Turistica(boolean vehiculo) {
        this.vehiculo = vehiculo;
    }

    public boolean isVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(boolean vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String getCategoria() {
        return "Actividad gastronomica";
    }

    @Override
    public int getTiempo() {
        return getDuracion()/60;
    }

    @Override
    public String getBreveDesc() {
        if (getDescripcion().length() > 50) {
            return getDescripcion().substring(0,50)+"...";   
        }else{
            return getDescripcion();
        }
    }

}
