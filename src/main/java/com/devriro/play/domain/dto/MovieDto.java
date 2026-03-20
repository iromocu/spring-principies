package com.devriro.play.domain.dto;

import com.devriro.play.domain.enums.Gender;

import java.time.LocalDate;

public record MovieDto(
        String title,
        Integer duration,
        Gender gender,
        LocalDate releaseDate,
        Double rating,
        String status
) {
}
