package com.smiguela.NetPlay.web.controller;

import com.smiguela.NetPlay.domain.dto.MovieDto;
import com.smiguela.NetPlay.domain.dto.UpdateMovieDto;
import com.smiguela.NetPlay.domain.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.util.List;

@RestController
// Lo siguiente es para que todas las rutas dentro de este controlador tengan por defecto el path indicado el parentesis y no repetir el mismo path en cada metodo/peticion
@RequestMapping("/movies")
public class MoviesController {
    private final MovieService movieService;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("")
    public ResponseEntity<List<MovieDto>> getAll() {
        List<MovieDto> movies = this.movieService.getAll();
        if (movies.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable long id){
        MovieDto movieDto = this.movieService.getById(id);
        if(movieDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping("")
    public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto){
       MovieDto movie = this.movieService.createMovie(movieDto);
       return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable long id, @RequestBody UpdateMovieDto updateMovieDto){
        return ResponseEntity.ok(this.movieService.updateMovie(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable long id){
        return ResponseEntity.ok(this.movieService.deleteMovie(id));
    }
}
