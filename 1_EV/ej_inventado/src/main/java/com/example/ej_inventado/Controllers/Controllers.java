package com.example.ej_inventado.Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ej_inventado.clases.Actividad;
import com.example.ej_inventado.clases.Deportiva;
import com.example.ej_inventado.clases.Gastronomica;
import com.example.ej_inventado.clases.Nivel;
import com.example.ej_inventado.clases.Tipo;
import com.example.ej_inventado.clases.Turistica;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class Controllers {

    @GetMapping("/")
    public String iniciohtml(HttpSession session,HttpServletResponse response,@CookieValue(value = "nombre",required=false)String nombre,@CookieValue(value = "fEntrada",required=false)String fEntrada,@CookieValue(value = "fSalida",required=false)String fSalida, @CookieValue(value = "ciudad",required=false)String ciudad) {
        if (nombre != null) {
            session.setAttribute("nombre", nombre);
            session.setAttribute("ciudad", ciudad);
            session.setAttribute("fEntrada", fEntrada);
            session.setAttribute("fSalida", fSalida);
            return "redirect:/inicio";
        }else{
        return "index";
    }
    }

    @GetMapping("/comprobar")
    public String valida(Model model, HttpServletResponse response, @RequestParam(name = "ciudad") String ciudad,
            @RequestParam(name = "nombre") String nombre, @RequestParam(name = "fEntrada") LocalDate fEntrada,
            @RequestParam(name = "fSalida") LocalDate fSalida, HttpSession session) {
        try {
            if (fSalida.isBefore(fEntrada)) {
                throw new IllegalArgumentException("⚠️  La fecha de entrada no puede ser posterior a la de salida  ⚠️");
            }
            session.setAttribute("nombre", nombre);
            Cookie cookieNombre = new Cookie("nombre", nombre);
            cookieNombre.setMaxAge(3600);
            
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaIn = fEntrada.format(formato);
            String fechaSal = fSalida.format(formato);
            session.setAttribute("fEntrada", fechaIn);
            Cookie cookieEntrada = new Cookie("fEntrada", (String)session.getAttribute("fEntrada"));
            cookieEntrada.setMaxAge(3600);
            session.setAttribute("fSalida", fechaSal);
            Cookie cookieSalida = new Cookie("fSalida", (String)session.getAttribute("fSalida"));
            cookieSalida.setMaxAge(3600);
            session.setAttribute("ciudad", ciudad);
            Cookie cookieCiudad = new Cookie("ciudad", ciudad);
            cookieCiudad.setMaxAge(3600);
            cookieNombre.setPath("/");
            cookieEntrada.setPath("/");
            cookieSalida.setPath("/");
            cookieCiudad.setPath("/");
            response.addCookie(cookieNombre);
            response.addCookie(cookieEntrada);
            response.addCookie(cookieSalida);
            response.addCookie(cookieCiudad);
            return "redirect:/inicio";
        } catch (IllegalArgumentException e) {
            session.setAttribute("errorMensaje", e.getMessage());
            return "redirect:/";
        }

    }

    @ModelAttribute("listaAct")
    public ArrayList<Actividad> getAct() {
        ArrayList<Actividad> listaAct = new ArrayList<>();
        listaAct.add(new Turistica(Tipo.TURISTICA, 120, 25, "Sevilla", "Acuario de Sevilla",
                "Visita el acuario de Sevilla donde podrás encontrar el tanque de agua de 9m, el más grande de Europa.",
                "img/acuario.jpg", false));
        listaAct.add(new Turistica(Tipo.TURISTICA, 300, 50, "Sevilla", "Visita guiada en Sevilla",
                "Visita Sevilla con un profesional en la historia de esta ciudad. Visita monumentos como la Giralda, la Torre del Oro, la Plaza de España",
                "img/giralda.jpg", false));
        listaAct.add(new Turistica(Tipo.TURISTICA, 180, 15, "Cantabria", "Reserva Natural de Cabárcenos",
                "Visita la reserva natural más grande de Europa. Un lugar donde podrás disfrutar de la presencia de animales como leones, elfantes, tigres...",
                "img/reservanat.jpg", true));
        listaAct.add(new Turistica(Tipo.TURISTICA, 120, 0, "Almeria", "Faro de Cabo de Gata",
                "Visita el faro de Cabo de Gata. un lugar donde tendrás las mejores vistas de la costa de Almeria.",
                "img/faroCaboGata.jpg", true));
        listaAct.add(new Deportiva(Tipo.DEPORTIVA, 180, 45, "Sevilla", "Kayak por el Guadalquivir",
                "¿Está usted listo para vivir una experiencia inolvidable?. Esta actividad es perfecta para una de las tardes calurosas en la ciudad de Sevilla, perfecta para que los peques y los no tan peques aprendan un deporte nuevo.",
                "img/kayak.jpg", Nivel.Bajo));
        listaAct.add(new Deportiva(Tipo.DEPORTIVA, 120, 30, "Sevilla", "Visita el Sanchez Pizjuan",
                "Visita el Sanchez Pizjuan desde la vista de tus jugadores favoritos. Entra a los vestuarios de los jugadores y pisa el campo donde juegan",
                "img/sevilla.jpg", Nivel.Bajo));
        listaAct.add(new Deportiva(Tipo.DEPORTIVA, 300, 35, "Cantabria", "Descenso del Seya",
                "Realiza el descenso del Seya con profesionales. Un lugar donde, mientras haces deporte, vas a ver la parte más bonita de la naturaleza cantabrica.",
                "img/descensoSeya.jpg", Nivel.Medio));
        listaAct.add(new Deportiva(Tipo.DEPORTIVA, 120, 25, "Almeria", "Snorquel en Cabo de Gata",
                "Practica snorquel a la orilla de una de las playas virgenes de Cabo de Gata. Allí podrás presenciar muchisima diversidad maritima, desde peces de muchos colores hasta corales de lo más misteriosos.",
                "img/snorkel.jpg", Nivel.Medio));
        listaAct.add(new Deportiva(Tipo.DEPORTIVA, 120, 69, "Almeria", "Paseo en lancha",
                "Disfruta de una lancha durante 2 horas en el Cabo de Gata. Con ella podrás ver focas, tortugas, peces y demás animales que no se ven todos los días. Deberas tener el carnet de lancha.",
                "img/lancha.jpg", Nivel.Alto));
        listaAct.add(new Gastronomica(Tipo.GASTRONOMICA, 180, 40, "Sevilla", "Ruta Cruzcampo",
                "Disfruta de 3 horas de pura cruzcampo y tapas.", "img/cerveza.jpg", "Formal"));
        listaAct.add(new Gastronomica(Tipo.GASTRONOMICA, 120, 60, "Cantabria", "Anchoa",
                "Disfruta de la mejor cena de anchoas del cantábrico.", "img/anchoas.jpg", "Gala"));
        listaAct.add(new Gastronomica(Tipo.GASTRONOMICA, 240, 100, "Cantabria", "Vinos Cantabricos",
                "Disfruta de la mejor ruta de vinos de la costa cantábrica.", "img/vino.jpg", "Usual"));
        listaAct.add(new Gastronomica(Tipo.GASTRONOMICA, 180, 40, "Almeria", "Comida almeriense",
                "Disfruta de la gastronomía almeriense acompañado de un grupo de personas con los mismos intereses.",
                "img/comidaalmeria.jpg", "Casual"));

        return listaAct;
    }

    @GetMapping("/inicio")
    public String principal(Model model, HttpSession session,
            @RequestParam(name = "tipo", required = false) String tipo,
            @RequestParam(name = "orden", required = false) String orden,
            @RequestParam(name = "añadirCarrito", required = false) Integer añadirCarrito,
            @ModelAttribute("listaAct") ArrayList<Actividad> listaAct) {

        model.addAttribute("listaAct", listaAct);
        // Metemos el orden de las actividades a la sesion (Ordenar por tipo y por
        // precio)
        if (orden != null) {
            session.setAttribute("orden", orden);
            if (session.getAttribute("orden").equals("precio")) {
                Collections.sort(listaAct);
            } else if (session.getAttribute("orden").equals("defecto")) {
                Collections.shuffle(listaAct);
            }
        }

        if (tipo != null) {
            session.setAttribute("tipo", tipo);
        } else if (session.getAttribute("tipo") == null) {
            session.setAttribute("tipo", "all");
        }

        // Metodo Date para obtener los dias entre dos fechas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fEntrada = LocalDate.parse((String) session.getAttribute("fEntrada"), formatter);
        LocalDate fSalida = LocalDate.parse((String) session.getAttribute("fSalida"), formatter);
        long dias = ChronoUnit.DAYS.between(fEntrada, fSalida);
        session.setAttribute("dias", dias);

        // Carrito
        ArrayList<Actividad> carrito = (ArrayList<Actividad>) session.getAttribute("carrito");
        int precioCarro = 0;
        if (carrito == null) {
            carrito = new ArrayList<>();
        }
        if (añadirCarrito != null) {
            boolean existe = false;

            if (carrito.contains(listaAct.get(añadirCarrito))) {
                existe = true;
            }

            if (carrito.size() >= dias) {
                model.addAttribute("errorMensaje2", "⚠️ No puede añadir más cosas al carrito ⚠️");
                return "redirect:/inicio";
            }

            if (!existe) {
                carrito.add(listaAct.get(añadirCarrito));
            }
        }
        // Contador actividades
        int cont = carrito.size();
        // Precio carro
        for (int i = 0; i < carrito.size(); i++) {
            precioCarro += carrito.get(i).precio;
        }

        session.setAttribute("precioCarro", precioCarro);
        session.setAttribute("cont", cont);
        session.setAttribute("carrito", carrito);

        return "inicio";
    }

    @GetMapping("/eliminarCarrito")
    public String eliminarDelCarrito(HttpSession session,
            @RequestParam(name = "idEliminar", defaultValue = "-1") int idEliminar) {
        ArrayList<Actividad> carrito = (ArrayList<Actividad>) session.getAttribute("carrito");
        if (carrito != null) {
            for (int i = 0; i < carrito.size(); i++) {
                if (carrito.get(i) == carrito.get(idEliminar)) {
                    carrito.remove(i);
                }
            }
            session.setAttribute("carrito", carrito);
        }
        return "redirect:/inicio";
    }

    @GetMapping("/verMas")
    public String verMas(HttpSession session, Model model, @ModelAttribute("listaAct") ArrayList<Actividad> listaAct,
            @RequestParam(name = "id") int id) {
        Actividad act = listaAct.get(id);
        act.duracion = act.getTiempo();
        session.setAttribute("act", act);
        return "verMas";
    }

    @GetMapping("/confirmarCarrito")
    public String confirmarCarrito(HttpSession session, Model model,
            @ModelAttribute("listaAct") ArrayList<Actividad> listaAct) {
        ArrayList<Actividad> carrito = (ArrayList<Actividad>) session.getAttribute("carrito");
        return "confirmarCarrito";
    }

    @GetMapping("/planificar")
    public String planificarViaje(HttpSession session, Model model,
            @RequestParam(name = "actSel", required = false) Integer actSel,
            @RequestParam(name = "posSel", required = false) Integer posSel) {
        Long diasLong = (Long) session.getAttribute("dias");
        int dias = diasLong.intValue();
        ArrayList<Actividad> carrito = (ArrayList<Actividad>) session.getAttribute("carrito");
        Actividad[] plan = (Actividad[]) session.getAttribute("plan");
        if (plan == null) {
            plan = new Actividad[dias];
            session.setAttribute("plan", plan);
        }
        if (actSel != null) {
            session.setAttribute("actSel", carrito.get(actSel));
        }
        if (posSel != null) {
            session.setAttribute("posSel", posSel);
        }
        if (posSel != null && session.getAttribute("actSel") != null) {
            plan[posSel] = (Actividad)session.getAttribute("actSel");
            session.setAttribute("actSel", null);
        }
        session.setAttribute("plan", plan);
        return "planificar";
    }

    @GetMapping("/final")
    public String finalP(HttpSession session){
        return "final";
    }

}
