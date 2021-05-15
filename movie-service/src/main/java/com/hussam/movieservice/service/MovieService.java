package com.hussam.movieservice.service;

import com.hussam.movieservice.dto.request.AddMovieRequest;
import com.hussam.movieservice.entity.Movie;


public interface MovieService {
    public Movie findMovieByName(String name);

    void addNewMovie(AddMovieRequest NewMovie);
}
