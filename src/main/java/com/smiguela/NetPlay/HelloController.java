package com.smiguela.NetPlay;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //Creamos una constante para guardar la respuesta de la AI junto con el constructor
    private final NetPlayAIService AISERVICE;
    public HelloController(NetPlayAIService AISERVICE) {
        this.AISERVICE = AISERVICE;
    }

    @GetMapping("/")
    public String hello() {
        return this.AISERVICE.generateGreeting();
    }
}
