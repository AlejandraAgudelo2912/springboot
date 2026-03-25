package com.alejandra.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    @GetMapping("/details") //el mas tipico para indicar la ruta 
    public String details(Model model){ //aqui solo podemos pasar strings 
        model.addAttribute("title", "Hola mundo spring boot"); //param que pasamos a la vista con el model.add... añadimos cosas que queremos pasarle a la vista
        model.addAttribute("name", "alejandra");
        model.addAttribute("lastname", "agudelo");

        return "details"; //devolvemos las plantillas
    }
}
