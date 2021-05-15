package com.hussam.movieservice.service.impl;

import com.hussam.movieservice.dto.request.AddMovieRequest;
import com.hussam.movieservice.entity.Movie;
import com.hussam.movieservice.exception.NoSuchElementFoundException;
import com.hussam.movieservice.repository.MovieRepository;
import com.hussam.movieservice .service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie findMovieByName(String name) {
       Movie movie = movieRepository.findMovieByName(name);
       if(movie == null){
           log.error("Error: Movie with name "  + name +  " is not found!!");
           throw new NoSuchElementFoundException("Movie with name "  +name.toUpperCase(Locale.ROOT) + " not found");
       }
       return movie;
    }
    @Override
    public void addNewMovie(AddMovieRequest newMovie) {

        Movie movie = new Movie();
        movie.setName(newMovie.getName());
        movie.setGenre(newMovie.getGenre());
        movie.setReleasedDate(newMovie.getReleaseDate());

        movieRepository.save(movie);
    }
}
