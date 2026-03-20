package com.devriro.play.domain.repository;

import com.devriro.play.domain.dto.MovieDto;

import java.util.List;

public interface MovieRepository {

    List<MovieDto> getAll();

    MovieDto getById(long id);
}
