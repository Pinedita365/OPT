package com.example.tema2_2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnlaceController {
    @GetMapping("/enlace_2") //Peticion de la direccion web
    public String lista(@RequestParam(name = "enlace")String enlace , Model model){
        model.addAttribute("enlace",enlace);
        return "enlace_2"; // A qué html me voy
    }
    @GetMapping("/enlace")
    public String home(){
        return "enlace";
    }
}
