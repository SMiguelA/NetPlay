package com.smiguela.NetPlay.domain.service;

import com.smiguela.NetPlay.domain.dto.MovieDto;
import com.smiguela.NetPlay.domain.dto.UpdateMovieDto;
import com.smiguela.NetPlay.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Anotacion de Langchain4j
    // Solo con esto ya Langchain4j guarda las peliculas dentro de la plataforma para usar esa informacion en cualquier parte del proyecto
    @Tool("Busca todas las peliculas dentro de la plataforma")
    public List<MovieDto> getAll(){
        return movieRepository.getAll();
    }

    public MovieDto getById(long id){
        return movieRepository.getById(id);
    }

    public MovieDto createMovie(MovieDto movieDto){
        return movieRepository.createMovie(movieDto);
    }

    public MovieDto updateMovie(long id, UpdateMovieDto updateMovieDto){
        return this.movieRepository.updateMovie(id, updateMovieDto);
    }

    public String deleteMovie(long id){
        return this.movieRepository.deleteMovie(id);
    }
}
