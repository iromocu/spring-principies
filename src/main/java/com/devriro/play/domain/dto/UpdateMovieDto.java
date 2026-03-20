package com.devriro.play.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record UpdateMovieDto(
        @NotBlank(message = "The title field is required")
        String title,
        @PastOrPresent(message = "The release date must to be major or equals at today")
        LocalDate releaseDate,
        @Min(value = 0, message = "The rating must be major to 0.")
        @Max(value = 5, message = "The rating must be minor to 5.")
        Double rating
) {
}
