package com.devriro.play.persistance.mapper;

import com.devriro.play.domain.dto.MovieDto;
import com.devriro.play.persistance.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(source = "title", target = "title")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "openingDay", target = "releaseDate")
    @Mapping(source = "rankin", target = "rating")
    MovieDto toDto(MovieEntity entity);
    List<MovieDto> toDto(Iterable<MovieEntity> entities);
}
