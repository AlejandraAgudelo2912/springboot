package com.alejandra.springboot.webapp.springboot_web.controllers;

//import java.util.HashMap;
//import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alejandra.springboot.webapp.springboot_web.models.User;
import com.alejandra.springboot.webapp.springboot_web.models.dto.UserDto;


@RestController
@RequestMapping("/api") //ruta primer nivel osea /api/details
public class UserRestController {

    @GetMapping("/details") //el mas tipico para indicar la ruta 
    public UserDto details(){ //aqui solo podemos pasar strings 

        UserDto userDto = new UserDto();
        User user = new User("alejandra", "agudelo");
        userDto.setUser(user);
        userDto.setTittle("Hola mundo spring boot");

        //Map<String, Object> body = new HashMap<>();

        //body.put("title", "Hola mundo spring boot"); //param que pasamos a la vista con el model.add... añadimos cosas que queremos pasarle a la vista
        //body.put("user", user );


        return userDto; //devolvemos el json
    }
}
