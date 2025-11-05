package com.example.ej_inventado.clases;

public class Deportiva extends Actividad{

    public Nivel nivel;

    public Deportiva(int duracion, int precio, String ciudad, String nombre, String descripcion, String img,
            Nivel nivel) {
        super(duracion, precio, ciudad, nombre, descripcion, img);
        this.nivel = nivel;
    }

    public Deportiva(Nivel nivel) {
        this.nivel = nivel;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    @Override
    public String getCategoria() {
        return "Actividad deportiva";
    }

    @Override
    public int getTiempo() {
        return (getDuracion()/60);
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
