package com.devriro.play.domain.repository;

import com.devriro.play.domain.dto.MovieDto;
import com.devriro.play.domain.dto.UpdateMovieDto;

import java.util.List;

public interface MovieRepository {

    List<MovieDto> getAll();

    MovieDto getById(long id);

    MovieDto save(MovieDto movieDto);

    MovieDto update(long id, UpdateMovieDto updateMovieDto);

    MovieDto delete(long id);
}
