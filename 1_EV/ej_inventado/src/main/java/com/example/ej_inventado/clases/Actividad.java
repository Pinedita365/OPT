package com.example.ej_inventado.clases;

abstract class Actividad implements Descripciones{
    public int id, duracion, precio;
    public String nombre, descripcion, img;

    public Actividad(int id, int duracion, int precio, String nombre, String descripcion, String img) {
        this.id = id;
        this.duracion = duracion;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
    }

    public Actividad() {
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuracion() {
        return duracion * 60;
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

    
    
}
