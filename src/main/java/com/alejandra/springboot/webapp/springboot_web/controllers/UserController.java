package com.alejandra.springboot.webapp.springboot_web.controllers;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.alejandra.springboot.webapp.springboot_web.models.User;


@Controller
public class UserController {

    @GetMapping("/details") //el mas tipico para indicar la ruta 
    public String details(Model model){ //aqui solo podemos pasar strings 
        User user = new User("alejandra", "agudelo");

        user.setEmail("alejandra@gmail.com");

        model.addAttribute("title", "Hola mundo spring boot"); //param que pasamos a la vista con el model.add... añadimos cosas que queremos pasarle a la vista
        model.addAttribute("user", user);

        return "details"; //devolvemos las plantillas
    }

    @GetMapping("/list")
    public String list(ModelMap model){
        List<User> users= Arrays.asList(
            new User("pepa", "gonzalez"),
            new User("lali", "perez", "lali@gmail.com"),
            new User("juanita", "ROE", "juanita@gmail.com"),
            new User("Andres", "DOE")
        );

        model.addAttribute("users", users);
        model.addAttribute("title", "Listado de usuarios");

        return "list";

    }
}
