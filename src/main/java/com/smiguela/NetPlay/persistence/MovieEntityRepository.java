package com.smiguela.NetPlay.persistence;

import com.smiguela.NetPlay.domain.dto.MovieDto;
import com.smiguela.NetPlay.domain.dto.UpdateMovieDto;
import com.smiguela.NetPlay.domain.exception.MovieAlreadyExistException;
import com.smiguela.NetPlay.domain.exception.MovieDoNotExistException;
import com.smiguela.NetPlay.domain.repository.MovieRepository;
import com.smiguela.NetPlay.persistence.crud.CrudMovieEntity;
import com.smiguela.NetPlay.persistence.entity.MovieEntity;
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

    @Override
    public MovieDto getById(long id){
        return this.movieMapper.toDto(this.crudMovieEntity.findById(id).orElse(null));
    }

    @Override
    public MovieDto createMovie(MovieDto movieDto){
        if(this.crudMovieEntity.findFirstByName(movieDto.name()) != null){
            throw new MovieAlreadyExistException(movieDto.name());
        }

        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto updateMovie(long id, UpdateMovieDto updateMovieDto){
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        if(movieEntity == null){
            throw new MovieDoNotExistException(id);
        }

        if(updateMovieDto.name() != null) movieEntity.setName(updateMovieDto.name());
        if(updateMovieDto.description() != null) movieEntity.setDescription(updateMovieDto.description());
        if(updateMovieDto.premiereDate() != null) movieEntity.setPremiereDate(updateMovieDto.premiereDate());
        if(updateMovieDto.rating() != null) movieEntity.setRating(updateMovieDto.rating());
        if(updateMovieDto.isAvailable() != null) movieEntity.setIsAvailable(updateMovieDto.isAvailable());

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public String deleteMovie(long id){
        if(this.crudMovieEntity.findById(id).orElse(null) == null){
            throw new MovieDoNotExistException(id);
        }
        this.crudMovieEntity.deleteById(id);
        return "Movie has been deleted.";
    }
}
