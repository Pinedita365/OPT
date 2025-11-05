package com.example.ej_inventado.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class inicio {

    @GetMapping("/index")
    public String iniciohtml(){
        return "index";
    }

    @GetMapping("/inicio")
    public String principal(@RequestParam(name = "nombre")String nombre,HttpSession session){
        session.setAttribute("nombre", nombre);
        return "inicio";
    }

}
