package com.smiguela.NetPlay.domain.repository;

import com.smiguela.NetPlay.domain.dto.MovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(long id);
    MovieDto createMovie(MovieDto movieDto);
}
