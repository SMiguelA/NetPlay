package com.smiguela.NetPlay.persistence.crud;

import com.smiguela.NetPlay.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

// Se podria cambiar CrudRepository por JpaRepository para evitar el casteo de los valores output que generemos en nustres consultas
public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {

}
