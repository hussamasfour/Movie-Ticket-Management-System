package com.hussam.movieservice.service.impl;

import com.hussam.movieservice.entity.Movie;
import com.hussam.movieservice.exception.NoSuchElementFoundException;
import com.hussam.movieservice.repository.MovieRepository;
import com.hussam.movieservice .service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie findMovieByName(String name) {
       Movie movie = movieRepository.findMovieByName(name);
       if(movie == null){
           throw new NoSuchElementFoundException("Movie with name "  +name.toUpperCase(Locale.ROOT) + " not found");
       }
       return movie;
    }
    @Override
    public void addNewMovie(Movie movie) {
        movieRepository.save(movie);
    }
}
