package com.hussam.movieservice.controller;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.hussam.movieservice.dto.request.AddMovieRequest;
import com.hussam.movieservice.entity.Movie;
import com.hussam.movieservice.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/movie")
@Slf4j
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{name}")
    public ResponseEntity<?> getMovieByName(@PathVariable("name") String name){
        log.info("Inside getMovieByName() in MovieController");
        Movie movie = movieService.findMovieByName(name);
        Link link = linkTo(methodOn(MovieController.class).getMovieByName(name)).withSelfRel();
        movie.add(link);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addMovie(@RequestBody @Valid AddMovieRequest movie){
        log.info("Inside addMovie() in MovieController");
        movieService.addNewMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }
}
