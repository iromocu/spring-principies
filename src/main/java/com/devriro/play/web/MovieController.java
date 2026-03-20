package com.devriro.play.web;

import com.devriro.play.domain.dto.MovieDto;
import com.devriro.play.domain.dto.UpdateMovieDto;
import com.devriro.play.persistance.entity.MovieEntity;
import com.devriro.play.domain.services.MovieService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll(){
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable long id){
        MovieDto movieDto = movieService.geById(id);
        if(movieDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDto);
    }

    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto){
        MovieDto newMovieDto = movieService.save(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMovieDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable long id, @RequestBody UpdateMovieDto updateMovieDto){
        MovieDto movieDto = movieService.update(id, updateMovieDto);
        if(movieDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> delete(@PathVariable long id){
        MovieDto movieDto = movieService.delete(id);
        if(movieDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
