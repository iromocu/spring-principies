package com.devriro.play.persistance;

import com.devriro.play.domain.dto.MovieDto;
import com.devriro.play.domain.repository.MovieRepository;
import com.devriro.play.persistance.crud.CrudMovieEntity;
import com.devriro.play.persistance.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDto(crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(long id) {
        return this.movieMapper.toDto(crudMovieEntity.findById(id).orElse(null));
    }
}
