package com.devriro.play.domain.dto;

import com.devriro.play.domain.enums.Gender;

import java.time.LocalDate;

public record UpdateMovieDto(
        String title,
        LocalDate releaseDate,
        Double rating
) {
}
