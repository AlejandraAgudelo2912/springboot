package com.alejandra.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"", "/", "/home"})
    public String home(){

        return "redirect:/details";
        //retunr "forward:/details";

        //Forward vs Redirect
        //La diferencia es que con el Forward se mantiene dentro de la misma peticion http,
        //y no pierdes los parametros que tienes dentro del request, tampoco cambia la ruta 
        //url, ya que no hace refresh, sino que despacha a otra accion del controlador pero sin
        //recargar la pagina, mientras que el redirect cambia la ruta url, reinicia el 
        //request y refresca el navegador, además que todos los parametros del request que 
        //tenias se pierden, ya que es una nueva peticion http.
    }
}
