package com.smiguela.NetPlay.domain.dto;

import com.smiguela.NetPlay.domain.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateMovieDto(
        String name,
        String description,
        LocalDate premiereDate,
        BigDecimal rating,
        Boolean isAvailable
) {
}
