package com.smiguela.NetPlay.web.controller;

import com.smiguela.NetPlay.domain.service.NetPlayAIService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    //Creamos una constante para guardar la respuesta de la AI junto con el constructor
    private final NetPlayAIService AISERVICE;
    private final String appName;
    // Utilizando el @Value accedemos a informacion almacenada en application.properties
    public HelloController(@Value("${spring.application.name}") String appName, NetPlayAIService AISERVICE) {
        this.AISERVICE = AISERVICE;
        this.appName = appName;
    }

    @GetMapping("/gretting")
    public String hello() {
        return this.AISERVICE.generateGreeting(appName);
    }


}
