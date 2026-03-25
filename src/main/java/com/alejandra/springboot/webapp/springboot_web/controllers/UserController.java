package com.alejandra.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    @GetMapping("/details") //el mas tipico para indicar la ruta 
    public String details(){

        return "details"; //devolvemos las plantillas
    }
}
