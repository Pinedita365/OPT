package com.example.ejercicio1_jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer id;

    @Column(name="nombre")
    public String nombre;

    @Column(name="asunto")
    public String asunto;

    @Column(name="descripcion")
    public String descripcion;


}