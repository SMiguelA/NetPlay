package com.smiguela.NetPlay.persistence;

import com.smiguela.NetPlay.domain.dto.MovieDto;
import com.smiguela.NetPlay.domain.repository.MovieRepository;
import com.smiguela.NetPlay.persistence.crud.CrudMovieEntity;
import com.smiguela.NetPlay.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll(){
        return this.movieMapper.toDtos(this.crudMovieEntity.findAll());
    }
}
