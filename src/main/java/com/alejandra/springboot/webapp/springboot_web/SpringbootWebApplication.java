package com.alejandra.springboot.webapp.springboot_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @PropertySources({
// 	@PropertySource("classpath:values.properties")
// }) Podemos tener varios archivos de propiedades y leerlos en la aplicacion
//@PropertySource("classpath:values.properties") //para poder leer el archivo values.properties y poder inyectar los valores en las variables de la clase PathVariableController
public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}

}
