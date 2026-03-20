package com.devriro.play.domain.dto;

import com.devriro.play.domain.enums.Gender;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record MovieDto(
        Long id,
        @NotBlank(message = "The title has not be empty or null")
        String title,
        @Min(value = 1, message = "The duration has not be minor to 1.")
        @Max(value = 1000, message = "The duration has not be major to 999.")
        Integer duration,
        
        Gender gender,
        @PastOrPresent(message = "The releaseDate must be minor to today")
        LocalDate releaseDate,
        @Min(value = 0, message = "The rating must be major to 0.")
        @Max(value = 5, message = "The rating must be minor to 5.")
        Double rating,

        String status
) {
}
