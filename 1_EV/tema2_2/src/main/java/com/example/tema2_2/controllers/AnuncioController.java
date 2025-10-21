package com.example.tema2_2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AnuncioController {

    @GetMapping("/controller") //Peticion de la direccion web
    public String metodo(@RequestParam(name = "nombre")String nombre, @RequestParam(name = "asunto")String asunto, @RequestParam(name = "com")String comentario, Model model){
        model.addAttribute("nombre", nombre);
        model.addAttribute("asunto",asunto);
        model.addAttribute("comentario", comentario);
        return "anuncio"; // A qué html me voy
    }

    

}
