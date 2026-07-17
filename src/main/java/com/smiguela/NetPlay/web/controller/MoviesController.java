package com.smiguela.NetPlay.web.controller;

import com.smiguela.NetPlay.persistence.crud.CrudMovieEntity;
import com.smiguela.NetPlay.persistence.entity.MovieEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {
    private final CrudMovieEntity crudMovieEntity;

    public MoviesController(CrudMovieEntity crudMovieEntity) {
        this.crudMovieEntity = crudMovieEntity;
    }

    @GetMapping("/movies")
    public List<MovieEntity> getAll() {
        // Lo casteamos para generar la lista, la interfaz nos devuelve un Iterable<MovieEntity> mas no una lista de objetos
        List<MovieEntity> movieEntities = (List<MovieEntity>) this.crudMovieEntity.findAll();
        return movieEntities;
    }
}
