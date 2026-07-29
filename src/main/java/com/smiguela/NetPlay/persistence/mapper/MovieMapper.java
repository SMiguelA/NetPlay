package com.smiguela.NetPlay.persistence.mapper;

import com.smiguela.NetPlay.domain.dto.MovieDto;
import com.smiguela.NetPlay.persistence.entity.MovieEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

// Mapper para pasar de MovieEntity a MovieDto usando MapStruct

@Mapper(componentModel = "spring", uses = GenreMapper.class)
public interface MovieMapper {
    // Mapeamos los atributos del MovieEntity
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "length", target = "length")
    @Mapping(source = "gender", target = "gender", qualifiedByName = "stringToGenre")
    @Mapping(source = "premiereDate", target = "premiereDate")
    @Mapping(source = "rating", target = "rating")
    @Mapping(source = "isAvailable", target = "isAvailable")
    // Metodos para transformar a tipo Dto
    MovieDto toDto(MovieEntity entity);

    List<MovieDto> toDtos(Iterable<MovieEntity> entities);

    // Optiene los mappings anteriores y los coloca alreves ( source ahora es target y viceversa) para no repetir el mismo codigo de arriba
    @InheritInverseConfiguration
    @Mapping(source = "gender", target = "gender", qualifiedByName = "genreToString")
    MovieEntity toEntity(MovieDto dto);
}
