package com.alejandra.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.alejandra.springboot.webapp.springboot_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola") String message){
        //public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola", name ="mensaje") String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

}
