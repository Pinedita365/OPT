package com.example.tema2_2.clases;

public class Anuncio {

    static public int id = 0 ;
    public int idObjeto;
    public String nombre;
    public String asunto;
    public String descripcion;
    public Anuncio() {
    }
    public Anuncio(String nombre, String asunto, String descripcion) {

        this.idObjeto = id;
        this.nombre = nombre;
        this.asunto = asunto;
        this.descripcion = descripcion;
        id++;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

}
