package com.alejandra.springboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
 	@PropertySource(value="classpath:values.properties", encoding="UTF-8")
}) 
//otra alternativa es guardar el archivo values.properties con el encoding ISO-8859-1 en visual studio code

//@PropertySource(value="classpath:values.properties", encoding="UTF-8") para leer el archivo y detectar los caracteres especiales como acentos y �, si no se pone el encoding se mostrar� mal en la consola y en el navegador
public class ValuesConfig {

}
