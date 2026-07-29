package com.smiguela.NetPlay.domain.service;

import com.smiguela.NetPlay.domain.dto.MovieDto;
import com.smiguela.NetPlay.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAll(){
        return movieRepository.getAll();
    }

    public MovieDto getById(long id){
        return movieRepository.getById(id);
    }

    public MovieDto createMovie(MovieDto movieDto){
        return movieRepository.createMovie(movieDto);
    }
}
