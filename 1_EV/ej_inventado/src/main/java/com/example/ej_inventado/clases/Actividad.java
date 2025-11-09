package com.example.ej_inventado.clases;

import java.util.Objects;

public abstract  class Actividad implements Descripciones, Comparable<Actividad>{
    public Tipo tipo;
    public int duracion, precio;
    public String ciudad, nombre, descripcion, img;

    public Actividad(Tipo tipo,int duracion, int precio, String ciudad, String nombre, String descripcion, String img) {
        this.tipo = tipo;
        this.duracion = duracion;
        this.precio = precio;
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
    }

    public Actividad() {
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int compareTo(Actividad o) {
        return  o.precio - this.precio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.duracion;
        hash = 47 * hash + this.precio;
        hash = 47 * hash + Objects.hashCode(this.ciudad);
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.descripcion);
        hash = 47 * hash + Objects.hashCode(this.img);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actividad other = (Actividad) obj;
        if (this.duracion != other.duracion) {
            return false;
        }
        if (this.precio != other.precio) {
            return false;
        }
        if (!Objects.equals(this.ciudad, other.ciudad)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return Objects.equals(this.img, other.img);
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
        if (getDescripcion().length() > 50) {
            return getDescripcion().substring(0,50)+"...";   
        }else{
        return getDescripcion();
        }
    }
        
}
