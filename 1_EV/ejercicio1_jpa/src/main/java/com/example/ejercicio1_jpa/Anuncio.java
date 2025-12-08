package com.example.ejercicio1_jpa;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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


@Entity
@Table(name = "anuncios")
public class Anuncio {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer id;

    @Column(name="nombre")
    public String nombre;

    @Column(name="asunto")
    public String asunto;

    @Column(name="descripcion")
    public String descripcion;

    @Column(name="FechaAnuncio")
    public LocalDate fecha;

    public Anuncio(String nombre, String asunto, String descripcion) {
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.nombre = nombre;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.fecha = LocalDate.now();
    }
   
    

}