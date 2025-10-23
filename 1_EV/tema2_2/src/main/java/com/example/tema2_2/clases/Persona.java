package com.example.tema2_2.clases;

import org.springframework.stereotype.Component;

@Component
public class Persona {
    public String nombre;
    public String apellido;
    public String email;
    public String sexo;

    
    
    public Persona() {
    }

    public Persona(String nombre, String apellido, String email, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", email=").append(email);
        sb.append(", sexo=").append(sexo);
        sb.append('}');
        return sb.toString();
    }

    
}
