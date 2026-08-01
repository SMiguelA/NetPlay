package com.smiguela.NetPlay.web.controller;

import com.smiguela.NetPlay.domain.dto.SuggestRequestDto;
import com.smiguela.NetPlay.domain.service.NetPlayAIService;
import dev.langchain4j.service.UserMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ai")
public class HelloController {
    //Creamos una constante para guardar la respuesta de la AI junto con el constructor
    private final NetPlayAIService AISERVICE;
    private final String appName;
    // Utilizando el @Value accedemos a informacion almacenada en application.properties
    public HelloController(@Value("${spring.application.name}") String appName, NetPlayAIService AISERVICE) {
        this.AISERVICE = AISERVICE;
        this.appName = appName;
    }

    @GetMapping("")
    public String hello() {
        return this.AISERVICE.generateGreeting(appName);
    }

    @PostMapping("")
    public ResponseEntity<String> generateMoviesSuggestion(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(this.AISERVICE.generateMovieSuggestion(suggestRequestDto.userPreferences()));
    }
}
