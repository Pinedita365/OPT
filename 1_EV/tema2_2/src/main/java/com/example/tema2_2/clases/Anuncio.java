package com.example.tema2_2.clases;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter 
@EqualsAndHashCode
@Getter
@AllArgsConstructor //Todos los contructores posibles
@NoArgsConstructor //Constructor vacio
@Data

@Component
public class Anuncio {

    static int id = 0 ;
    public int idObjeto;
    public String nombre;
    public String asunto;
    public String descripcion;
    public Anuncio(String nombre, String asunto, String descripcion) {

        this.idObjeto = id;
        this.nombre = nombre;
        this.asunto = asunto;
        this.descripcion = descripcion;
        id++;
    }

}
