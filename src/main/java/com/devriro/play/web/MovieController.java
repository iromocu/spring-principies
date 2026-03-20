package com.devriro.play.web;

import com.devriro.play.domain.dto.MovieDto;
import com.devriro.play.persistance.entity.MovieEntity;
import com.devriro.play.domain.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<MovieDto> getAll(){
        return movieService.getAll();
    }
}
