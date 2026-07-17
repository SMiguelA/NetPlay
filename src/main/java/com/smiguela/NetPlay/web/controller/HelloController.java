package com.smiguela.NetPlay.web.controller;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.smiguela.NetPlay.domain.service.NetPlayAIService;
import com.smiguela.NetPlay.persistence.crud.CrudMovieEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    //Creamos una constante para guardar la respuesta de la AI junto con el constructor
    private final NetPlayAIService AISERVICE;

    public HelloController(NetPlayAIService AISERVICE) {
        this.AISERVICE = AISERVICE;
    }

    @GetMapping("/gretting")
    public String hello() {
        return this.AISERVICE.generateGreeting();
    }


}
