package com.smiguela.NetPlay.persistence.mapper;

import com.smiguela.NetPlay.domain.Genre;
import org.mapstruct.Named;

public class GenreMapper {
    @Named("stringToGenre")
    public static Genre stringToGenre(String genre) {
        if (genre == null) {
            return null;
        }
        return switch (genre.toUpperCase()){
            case "ACCION", "ACTION" -> Genre.ACTION;
            case "CIENCIA_FICCION", "SCI_FI" -> Genre.SCI_FI;
            case "DRAMA" -> Genre.DRAMA;
            case "TERROR", "HORROR" -> Genre.HORROR;
            case "ANIMADA", "ANIMATED" -> Genre.ANIMATED;
            case "COMEDIA", "COMEDY" -> Genre.COMEDY;
            default -> null;
        };
    }

    @Named("genreToString")
    public static String genreToString(Genre genre) {
        if (genre == null) {return null;}

        return switch (genre){
            case Genre.ACTION->"ACTION";
            case Genre.SCI_FI->"SCI_FI";
            case Genre.DRAMA->"DRAMA";
            case Genre.HORROR->"HORROR";
            case Genre.ANIMATED->"ANIMATED";
            case Genre.COMEDY->"COMEDY";
        };
    }
}
