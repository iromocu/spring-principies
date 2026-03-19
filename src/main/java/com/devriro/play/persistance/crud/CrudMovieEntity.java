package com.devriro.play.persistance.crud;

import com.devriro.play.persistance.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {

}
