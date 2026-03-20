package com.devriro.play.persistance.mapper;

import com.devriro.play.domain.dto.MovieDto;
import com.devriro.play.domain.dto.UpdateMovieDto;
import com.devriro.play.persistance.entity.MovieEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenderMapper.class, StateMapper.class})
public interface MovieMapper {
    @Mapping(source = "title", target = "title")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "gender", target = "gender", qualifiedByName = "stringToGender")
    @Mapping(source = "openingDay", target = "releaseDate")
    @Mapping(source = "rankin", target = "rating")
    @Mapping(source = "active", target = "status", qualifiedByName = "boolToString")
    MovieDto toDto(MovieEntity entity);
    List<MovieDto> toDto(Iterable<MovieEntity> entities);

    @InheritInverseConfiguration
    @Mapping(source = "gender", target = "gender", qualifiedByName = "genderToString")
    @Mapping(source = "status", target = "active", qualifiedByName = "stringToBool")
    MovieEntity toEntity(MovieDto movieDto);



    @Mapping(target = "title", source = "title")
    @Mapping(target = "openingDay", source = "releaseDate")
    @Mapping(target = "rankin", source = "rating")
    void updateEntityFromDto(UpdateMovieDto updateMovieDto,@MappingTarget MovieEntity movieEntity);
}
