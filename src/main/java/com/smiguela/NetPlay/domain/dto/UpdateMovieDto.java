package com.smiguela.NetPlay.domain.dto;

import com.smiguela.NetPlay.domain.Genre;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateMovieDto(
        String name,
        String description,
        @PastOrPresent(message = "Cannot be a future date.")
        LocalDate premiereDate,
        @Min(value = 0, message = "The lower ammount can only be 0 and no less.")
        @Max(value = 5, message = "Max value is 5, cannot have a higher amount.")
        BigDecimal rating,
        Boolean isAvailable
) {
}
