package com.example.ej_inventado.Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ej_inventado.clases.Actividad;
import com.example.ej_inventado.repositories.ActividadRepository;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class Controllers {

    private final ActividadRepository actividadRepository;

    public Controllers(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    @GetMapping("/")
    public String iniciohtml(HttpSession session, HttpServletResponse response,
            @CookieValue(value = "nombre", required = false) String nombre,
            @CookieValue(value = "fEntrada", required = false) String fEntrada,
            @CookieValue(value = "fSalida", required = false) String fSalida,
            @CookieValue(value = "ciudad", required = false) String ciudad) {

        if (nombre != null) {
            session.setAttribute("nombre", nombre);
            session.setAttribute("ciudad", ciudad);
            session.setAttribute("fEntrada", fEntrada);
            session.setAttribute("fSalida", fSalida);
            return "redirect:/inicio";
        } else {
            return "index";
        }
    }

    @GetMapping("/comprobar")
    public String valida(Model model, HttpServletResponse response,
            @RequestParam(name = "ciudad") String ciudad,
            @RequestParam(name = "nombre") String nombre,
            @RequestParam(name = "fEntrada") LocalDate fEntrada,
            @RequestParam(name = "fSalida") LocalDate fSalida,
            HttpSession session) {
        try {
            if (fSalida.isBefore(fEntrada)) {
                throw new IllegalArgumentException(
                        "⚠️ La fecha de entrada no puede ser posterior a la de salida ⚠️");
            }

            session.setAttribute("nombre", nombre);
            Cookie cookieNombre = new Cookie("nombre", nombre);
            cookieNombre.setMaxAge(3600);

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaIn = fEntrada.format(formato);
            String fechaSal = fSalida.format(formato);

            session.setAttribute("fEntrada", fechaIn);
            Cookie cookieEntrada = new Cookie("fEntrada", fechaIn);
            cookieEntrada.setMaxAge(3600);

            session.setAttribute("fSalida", fechaSal);
            Cookie cookieSalida = new Cookie("fSalida", fechaSal);
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

    @GetMapping("/inicio")
    public String principal(Model model, HttpSession session,
            @RequestParam(name = "tipo", required = false) String tipo,
            @RequestParam(name = "orden", required = false) String orden,
            @RequestParam(name = "añadirCarrito", required = false) Long añadirCarrito) {

        // Inicializar tipo si no existe
        if (session.getAttribute("tipo") == null) {
            session.setAttribute("tipo", "all");
        }

        // Obtener ciudad de sesión (puede ser null)
        String ciudad = (String) session.getAttribute("ciudad");

        // 🚨 Cargar todas las actividades sin filtrar por ciudad para debug
        List<Actividad> listaAct = actividadRepository.findAll();

        // Filtrar por tipo si se especifica
        if (tipo != null && !tipo.equals("all")) {
            listaAct = listaAct.stream()
                    .filter(a -> a.getTipo().name().equals(tipo.toUpperCase()))
                    .toList();
            session.setAttribute("tipo", tipo);
        } else {
            session.setAttribute("tipo", "all");
        }

        // Ordenar según parámetro
        if (orden != null) {
            session.setAttribute("orden", orden);
            if ("precio".equals(orden)) {
                listaAct.sort(Comparator.comparingInt(Actividad::getPrecio).reversed());
            } else if ("defecto".equals(orden)) {
                Collections.shuffle(listaAct);
            }
        }

        // Carrito
        List<Actividad> carrito = (List<Actividad>) session.getAttribute("carrito");
        if (carrito == null)
            carrito = new ArrayList<>();

        if (añadirCarrito != null) {
            Actividad a = actividadRepository.findById(añadirCarrito).orElse(null);
            if (a != null && !carrito.contains(a)) {
                carrito.add(a);
            }
        }

        session.setAttribute("carrito", carrito);
        session.setAttribute("cont", carrito.size());
        session.setAttribute("precioCarro", carrito.stream().mapToDouble(Actividad::getPrecio).sum());

        model.addAttribute("listaAct", listaAct);

        return "inicio";
    }

    @GetMapping("/verMas")
    public String verMas(HttpSession session, Model model, @RequestParam(name = "id") Long id) {

        // Manejo seguro con Optional
        actividadRepository.findById(id).ifPresent(act -> {
            act.setDuracion(act.getTiempo());
            session.setAttribute("act", act);
        });

        return "verMas";
    }

    @GetMapping("/eliminarCarrito")
public String eliminarDelCarrito(HttpSession session,
        @RequestParam(name = "idEliminar") Long idEliminar) {

    List<Actividad> carrito = (List<Actividad>) session.getAttribute("carrito");
    if (carrito != null && idEliminar != null) {
        carrito.removeIf(act -> act.getId().equals(idEliminar));
        session.setAttribute("carrito", carrito);
        session.setAttribute("cont", carrito.size());
        double total = carrito.stream().mapToDouble(Actividad::getPrecio).sum();
        session.setAttribute("precioCarro", total);
    }

    return "redirect:/inicio";
}


    @GetMapping("/confirmarCarrito")
    public String confirmarCarrito(HttpSession session, Model model) {
        return "confirmarCarrito";
    }

    @GetMapping("/planificar")
public String planificarViaje(HttpSession session, Model model,
        @RequestParam(name = "actSel", required = false) Integer actSel,
        @RequestParam(name = "posSel", required = false) Integer posSel) {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String fEntradaStr = (String) session.getAttribute("fEntrada");
    String fSalidaStr = (String) session.getAttribute("fSalida");

    int diasTotales = 1;
    if (fEntradaStr != null && fSalidaStr != null) {
        LocalDate fEntrada = LocalDate.parse(fEntradaStr, formatter);
        LocalDate fSalida = LocalDate.parse(fSalidaStr, formatter);
        diasTotales = (int) ChronoUnit.DAYS.between(fEntrada, fSalida) + 1;
    }

    List<Actividad> carrito = (List<Actividad>) session.getAttribute("carrito");
    if (carrito == null) {
        carrito = new ArrayList<>();
        session.setAttribute("carrito", carrito);
    }

    Actividad[] plan = (Actividad[]) session.getAttribute("plan");
    if (plan == null || plan.length != diasTotales) {
        plan = new Actividad[diasTotales];
        session.setAttribute("plan", plan);
    }

    if (actSel != null && actSel >= 0 && actSel < carrito.size()) {
        session.setAttribute("actSel", carrito.get(actSel));
    }

    if (posSel != null) {
        session.setAttribute("posSel", posSel);
    }

    if (posSel != null && session.getAttribute("actSel") != null) {
        plan[posSel] = (Actividad) session.getAttribute("actSel");
        session.setAttribute("actSel", null);
    }

    session.setAttribute("plan", plan);

    model.addAttribute("diasTotales", diasTotales);
    model.addAttribute("plan", plan);
    model.addAttribute("carrito", carrito);
    model.addAttribute("fEntrada", fEntradaStr);
    model.addAttribute("fSalida", fSalidaStr);
    model.addAttribute("ciudad", session.getAttribute("ciudad"));
    model.addAttribute("nombre", session.getAttribute("nombre"));

    return "planificar";
}


    @GetMapping("/final")
    public String finalP(HttpSession session) {
        return "final";
    }
}
