package main.java.com.example.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnuncioController {

    @GetMapping() //Peticion de la direccion web
    public String metodo(){
        return "anuncio.html"; // A qué html me voy
    }

}
