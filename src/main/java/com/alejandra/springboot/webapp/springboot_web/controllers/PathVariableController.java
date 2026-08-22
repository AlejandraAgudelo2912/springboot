package com.alejandra.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandra.springboot.webapp.springboot_web.models.User;
import com.alejandra.springboot.webapp.springboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    // @Value("${config.message}")
    // private String message;
    //se puede inyectar directamente en el metodo de la peticion get

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("${config.code}")
    private Integer code;

    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valueList;
    // convertimos la lista en un arreglo manualmente

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String valueString;
    // convertimos la lista en un string manualmente

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.price}")
    private Long price;

    @Autowired
    private Environment environment;
    //el environment nos permite acceder a las propiedades de configuracion de la aplicacion

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable() String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();

        json.put("product", product);
        json.put("id", id);

        return json;
    }
    
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        //hacer algo con el ususario por ejmeplo save en la bbdd
        user.setName(user.getName().toUpperCase());
        
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.message}") String message ){
        Long code2 = environment.getProperty("config.code", Long.class);
        //lo podemos convertir directamente en vez de hacerlo en el json.put al final es lo mismo da igual
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);

        json.put("message", message);
        json.put("message2", environment.getProperty("config.message"));

        json.put("listOfValues", listOfValues);
        json.put("valueString", valueString);
        json.put("valueList", valueList);

        json.put("code", code);
        json.put("code2", code2);
        //json.put("code2", environment.getProperty("config.code", Long.class));

        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);
        return json;
    }

}