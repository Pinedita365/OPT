package com.example.ej_inventado.Controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ej_inventado.clases.Deportiva;
import com.example.ej_inventado.clases.Gastronomica;
import com.example.ej_inventado.clases.Nivel;
import com.example.ej_inventado.clases.Turistica;

import jakarta.servlet.http.HttpSession;

@Controller
public class Controllers {

    @GetMapping("/index")
    public String iniciohtml(){
        return "index";
    }

    @GetMapping("/inicio")
    public String principal(@RequestParam(name = "ciudad")String ciudad ,@RequestParam(name = "nombre")String nombre,@RequestParam(name = "fEntrada")LocalDate fEntrada,@RequestParam(name = "fSalida")LocalDate fSalida,HttpSession session){
        session.setAttribute("nombre", nombre);
        session.setAttribute("fEntrada", fEntrada);
        session.setAttribute("fSalida", fSalida);
        if (ciudad != null) {
            session.setAttribute("ciudad", ciudad);
        }
        ArrayList<Turistica> listaTur = new ArrayList<>();
        listaTur.add(new Turistica(120,25,"Sevilla","Acuario de Sevilla","Visita el acuario de Sevilla donde podrás encontrar el tanque de agua de 9m, el más grande de Europa.","img/acuario.jpg",false));
        listaTur.add(new Turistica(300,50,"Sevilla","Visita guiada en Sevilla","Visita Sevilla con un profesional en la historia de esta ciudad. Visita monumentos como la Giralda, la Torre del Oro, la Plaza de España","img/giralda.jpg",false));
        listaTur.add(new Turistica(180,15,"Cantabria","Reserva Natural de Cabárcenos","Visita la reserva nattural más grande de Europa. Un lugar donde podrás disfrutar de la presencia de animales como leones, elfantes, tigres...","img/reservanat.jpg",true));
        listaTur.add(new Turistica(120,0,"Almeria","Faro de Cabo de Gata","Visita el faro de Cabo de Gata. un lugar donde tendrás las mejores vistas de la costa de Almeria.","img/faroCaboGata.jpg",true));
        ArrayList<Deportiva> listaDep = new ArrayList<>();
        listaDep.add(new Deportiva(180,45,"Sevilla","Kayak por el Guadalquivir","¿Está usted listo para vivir una experiencia inolvidable?. Esta actividad es perfecta para una de las tardes calurosas en la ciudad de Sevilla, perfecta para que los peques y los no tan peques aprendan un deporte nuevo.","img/kayak.jpg",Nivel.Bajo));
        listaDep.add(new Deportiva(120,30,"Sevilla","Visita el Sanchez Pizjuan","Visita el Sanchez Pizjuan desde la vista de tus jugadores favoritos. Entra a los vestuarios de los jugadores y pisa el campo donde juegan","img/sevilla.jpg",Nivel.Bajo));
        listaDep.add(new Deportiva(300,35,"Cantabria","Descenso del Seya","realiza el descenso del Seya con profesionales. un lugar donde, mientras haces deporte, vas a ver la parte más bonita de la naturaleza cantabrica.","img/descensoSeya.jpg",Nivel.Medio));
        listaDep.add(new Deportiva(120,25,"Almeria","Snorquel en Cabo de Gata","Practica snorquel a la orilla de una de las playas virgenes de Cabo de Gata. Allí podrás presenciar muchisima diversidad maritima, desde peces de muchos colores hasta corales de lo más misteriosos.","img/snorkel.jpg",Nivel.Medio));
        listaDep.add(new Deportiva(120,69,"Almeria","Paseo en lancha","Disfruta de una lancha durante 2 horas en el Cabo de Gata. Con ella podrás ver focas, tortugas, peces y demás animales que no se ven todos los días. Deberas tener el carnet de lancha.","img/lancha.jpg",Nivel.Alto));
        ArrayList<Gastronomica> listaGas = new ArrayList<>();
        listaGas.add(new Gastronomica(180,40,"Sevilla","Ruta Cruzcampo","Disfruta de 3 horas de pura cruzcampo y tapas.","img/cerveza.jpg","Formal"));
        listaGas.add(new Gastronomica(120,60,"Cantabria","Anchoa","Disfruta de la mejor cena de anchoas del cantábrico.","img/anchoas.jpg","Gala"));
        listaGas.add(new Gastronomica(240,100,"Cantabria","Vinos Cantabricos","Disfruta de la mejor ruta de vinos de la costa cantábrica.","img/vino.jpg","Usual"));
        listaGas.add(new Gastronomica(180,40,"Almeria","Comida almeriense","Disfruta de la gastronomía almeriense acompañado de un grupo de personas con los mismos intereses.","img/comidaalmeria.jpg","Casual"));


        return "inicio";
    }

}
