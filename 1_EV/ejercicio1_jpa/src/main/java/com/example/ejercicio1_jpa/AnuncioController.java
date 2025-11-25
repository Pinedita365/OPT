package com.example.ejercicio1_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AnuncioController {

    @Autowired
    private AnuncioServicio servicio;

    @GetMapping({"/anuncios","/"})
    public String listarAnuncios(Model model){
        model.addAttribute("anuncios",servicio.listarAnuncio());
        return "insert";
    }

    @GetMapping("/anuncios/crear")
    public String crear(Model model){
        Anuncio anuncio = new Anuncio();
        model.addAttribute("anuncio",anuncio);
        return "crear";
    }

    @PostMapping("/anuncios")
    public String guardarTrabajador(@ModelAttribute("anuncio") Anuncio anuncio){
        servicio.guardarAnuncio(anuncio);
        return "redirect:/anuncios";
    }

}
