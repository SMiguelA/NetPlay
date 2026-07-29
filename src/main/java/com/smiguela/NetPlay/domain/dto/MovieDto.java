package com.smiguela.NetPlay.domain.dto;

import com.smiguela.NetPlay.domain.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieDto(
        Long id,
        String name,
        String description,
        Integer length,
        Genre gender,
        LocalDate premiereDate,
        BigDecimal rating,
        Boolean isAvailable
) {
}
