package com.example.tema2_2.controllers;

import java.net.http.HttpResponse;

import org.springframework.http.HttpCookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class RepasoCookies {

    @GetMapping("/RepasoCookies")
    public String RepasoCookies(Model model, HttpServletResponse response,
            @RequestParam(name = "nombre", required = false) String nombre,
            @CookieValue(value = "name", required = false) String cookieName,
            @CookieValue(value = "cont", required = false) Integer cont) {
        
        // Si se recibe valor la cookie se crea con el nuevo valor (Nombre)
        if (nombre != null) {
            Cookie cName = new Cookie("name", nombre);
            cName.setMaxAge(3600);
            response.addCookie(cName);
        }
        // Si el contador no esta inicializado se pone en 0
        if (cont == null)
            cont = 0;
        cont++;
        Cookie cCont = new Cookie("cont", cont.toString());
        cCont.setMaxAge(3600);
        response.addCookie(cCont);
        // Se meten los valores de las cookies al model pa que lo lea el html
        model.addAttribute("name", nombre);
        model.addAttribute("cont", cont);

        return "RepasoCookies";
    }

}
