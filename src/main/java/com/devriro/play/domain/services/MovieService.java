package com.devriro.play.domain.services;

import com.devriro.play.domain.dto.MovieDto;
import com.devriro.play.domain.dto.UpdateMovieDto;
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

    public MovieDto geById(long id) {
        return movieRepository.getById(id);
    }

    public MovieDto save(MovieDto movieDto){
        return movieRepository.save(movieDto);
    }

    public MovieDto update(long id, UpdateMovieDto updateMovieDto){
        return  movieRepository.update(id, updateMovieDto);
    }

    public MovieDto delete(long id){
        return movieRepository.delete(id);
    }
}
