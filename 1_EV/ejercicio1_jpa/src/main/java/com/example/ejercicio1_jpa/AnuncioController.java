package com.example.ejercicio1_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class AnuncioController {

    @Autowired
    private AnuncioServicio servicio;

    @GetMapping("/insert")
    public String metodo(@RequestParam(name = "nombre")String nombre, @RequestParam(name = "asunto")String asunto, @RequestParam(name = "comen")String comen, HttpSession session){
        servicio.guardarAnuncio(new Anuncio(nombre, asunto, comen));
        return "insert"; // A qué html me voy
    }

    @GetMapping("/nuevoAnuncio")
    public String intro(){
        return "nuevoAnuncio";
    }

    @GetMapping("/inicio")
    public String mostrarPagina(Model model){
        model.addAttribute("anuncios", servicio.listarAnuncio());
        return "inicio";
    }

    @GetMapping("/final")
    public String finalp(Model model, @RequestParam(name = "id")Integer id){
        model.addAttribute("anuncio", servicio.obtenerAnuncio(id));
        return "final";
    }

}
