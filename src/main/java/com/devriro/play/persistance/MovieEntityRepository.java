package com.devriro.play.persistance;

import com.devriro.play.domain.dto.MovieDto;
import com.devriro.play.domain.dto.UpdateMovieDto;
import com.devriro.play.domain.exceptions.MovieAlreadyExistException;
import com.devriro.play.domain.repository.MovieRepository;
import com.devriro.play.persistance.crud.CrudMovieEntity;
import com.devriro.play.persistance.entity.MovieEntity;
import com.devriro.play.persistance.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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

    @Override
    public MovieDto save(MovieDto movieDto) {
        if(crudMovieEntity.findFirstByTitle(movieDto.title()) != null){
            throw  new MovieAlreadyExistException(movieDto.title());
        }
        MovieEntity entity = this.movieMapper.toEntity(movieDto);
        crudMovieEntity.save(entity);
        return movieDto;
    }

    @Override
    public MovieDto update(long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = crudMovieEntity.findById(id).orElse(null);

        if(movieEntity == null) return null;

        this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);
        return movieMapper.toDto(crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto delete(long id) {
        MovieEntity movieEntity = crudMovieEntity.findById(id).orElse(null);

        if(movieEntity == null) return null;

        movieEntity.setActive(false);

        return movieMapper.toDto(crudMovieEntity.save(movieEntity));
    }
}
