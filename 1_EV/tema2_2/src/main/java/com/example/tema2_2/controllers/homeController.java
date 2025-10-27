package com.example.tema2_2.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.tema2_2.clases.Persona;

@Controller
public class homeController {
    @GetMapping("/home") //Peticion de la direccion web
    public String lista(Model model){
        ArrayList<Persona> lista = new ArrayList<>();
        lista.add(new Persona("Javier","Pineda","miemail@gmail.com","Hombre"));
        lista.add(new Persona("Paula","Montes","tuemail@gmail.com","Mujer"));
        model.addAttribute("lista",lista);
        model.addAttribute("fecha", LocalDate.now());
        return "home"; // A qué html me voy
    }
}
