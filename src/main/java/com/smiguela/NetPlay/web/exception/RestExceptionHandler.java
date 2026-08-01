package com.smiguela.NetPlay.web.exception;

import com.smiguela.NetPlay.domain.exception.MovieAlreadyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Indica a spring que esta clase captura los errores de la app
@RestControllerAdvice
public class RestExceptionHandler {
    // Decimos que tipo de error se va a manejar
    @ExceptionHandler(MovieAlreadyExistException.class)
    public ResponseEntity<Error> handlerException(MovieAlreadyExistException exception){
        Error error = new Error("movie-already-exists",  exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
