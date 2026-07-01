package com.smiguela.NetPlay.domain.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface NetPlayAIService {
    //Creamos un metodo y pasamos un prompt a la AI LangChain4j
    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de gestion de peliculas NetPlay.
            Usa menos de 120 caracteres.
            """)
    //Creamos un metodo para recibir la respuesta de la AI
    String generateGreeting();
}
