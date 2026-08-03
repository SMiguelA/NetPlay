package com.smiguela.NetPlay.web.exception;

import com.smiguela.NetPlay.domain.exception.MovieAlreadyExistException;
import com.smiguela.NetPlay.domain.exception.MovieDoNotExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

// Indica a spring que esta clase captura los errores de la app
@RestControllerAdvice
public class RestExceptionHandler {
    // Decimos que tipo de error se va a manejar
    @ExceptionHandler(MovieAlreadyExistException.class)
    public ResponseEntity<Error> handlerException(MovieAlreadyExistException exception){
        Error error = new Error("movie-already-exists",  exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MovieDoNotExistException.class)
    public ResponseEntity<Error> handlerException(MovieDoNotExistException exception){
        Error error = new Error("movie-do-not-exists",  exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    // Error para cuando un campo no cumple con el requerimiento especificado
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handlerException(MethodArgumentNotValidException exception){
        List<Error> errors = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach((fieldError) -> {
            errors.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });

        return ResponseEntity.badRequest().body(errors);
    }

    // Para manejar las exepciones generales y no las especifiquemos, capturar errores que no son ninguno de los anteriores
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handlerException(Exception exception){
        Error error = new Error("unknown-error",  exception.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
