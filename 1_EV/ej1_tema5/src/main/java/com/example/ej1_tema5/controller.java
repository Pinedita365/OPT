package com.example.ej1_tema5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class controller {

    @Autowired
    private loginServicio service;

    @GetMapping("/")
    public String a(){
        return "inicio.html";
    }

    @PostMapping("/")
    public String realizarLogin(@RequestParam String username, @RequestParam String password) {
        boolean esValido = service.login(username, password);
        
        if (esValido) {
            return "redirect:/inicio";
        } else {
            return "redirect:/fallo";
        }
    }

    @GetMapping("/inicio")
        public String inicio(){
            return "inicio";
        }

    @GetMapping("/fallo")
        public String fallo(){
            return "fallo";
        }

}
