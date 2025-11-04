package com.example.tema2_2.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tema2_2.clases.Anuncio;

import jakarta.servlet.http.HttpSession;

@Controller
public class Ej4Controllers {
    @SuppressWarnings("unchecked")
    @GetMapping("/insert")
    public String metodo(@RequestParam(name = "nombre")String nombre, @RequestParam(name = "asunto")String asunto, @RequestParam(name = "comen")String comen, HttpSession session){
        ArrayList<Anuncio> lista;
        if (session.getAttribute("lista") == null) {
            lista = new ArrayList<>();
        }else{
            lista =(ArrayList<Anuncio>) session.getAttribute("lista");
        }
        lista.add(new Anuncio(nombre, asunto, comen));
        session.setAttribute("lista", lista);
        return "insert"; // A qué html me voy
    }

    @GetMapping("/nuevoAnuncio")
    public String intro(){
        return "nuevoAnuncio";
    }

    @GetMapping("/inicio")
    public String mostrarPagina(){
        return "inicio";
    }

    @GetMapping("/final")
    public String finalp(@RequestParam(name = "id")int id,HttpSession session){
        session.setAttribute("id",id);
        return "final";
    }
}
