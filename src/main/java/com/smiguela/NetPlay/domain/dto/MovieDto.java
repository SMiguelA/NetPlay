package com.smiguela.NetPlay.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieDto(
        String name,
        String description,
        Integer length,
        String gender,
        LocalDate premiereDate,
        BigDecimal rating,
        Boolean isAvailable
) {
}
