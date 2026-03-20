package com.devriro.play.domain.services;

import com.devriro.play.domain.dto.MovieDto;
import com.devriro.play.domain.repository.MovieRepository;
import com.devriro.play.persistance.crud.CrudMovieEntity;
import com.devriro.play.persistance.entity.MovieEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAll(){
        return movieRepository.getAll();
    }
}
