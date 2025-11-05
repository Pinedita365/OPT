package com.example.ej_inventado.clases;

public class Turistica extends Actividad{

    public boolean vehiculo;

    public Turistica(int id, int duracion, int precio, String nombre, String descripcion, String img,
            boolean vehiculo) {
        super(id, duracion, precio, nombre, descripcion, img);
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
