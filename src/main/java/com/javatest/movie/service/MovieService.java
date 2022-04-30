package com.javatest.movie.service;

import com.javatest.movie.data.MovieRepository;
import com.javatest.movie.model.Genre;
import com.javatest.movie.model.Movie;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMovieByGenre(Genre genre) {
        return movieRepository.findAll().stream().filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(Integer minutes) {
        return movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= minutes).collect(Collectors.toList());
    }

    public Collection<Movie> findByName(String name) {
        return movieRepository.findAll().stream().filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }

    public Collection<Movie> findByNameDirector(String director) {
        return movieRepository.findAll().stream().filter(movie -> movie.getDirector().toLowerCase().contains(director.toLowerCase())).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByTemplate(Movie template) {
        Collection<Movie> movies = movieRepository.findAll();

        if ( template.getName() != null) {
            movies = movies.stream().filter(movie -> movie.getName().toLowerCase().contains(template.getName().toLowerCase())).collect(Collectors.toList());
        }

        if (template.getDirector() != null) {;
            movies = movies.stream().filter(movie -> movie.getDirector().toLowerCase().contains(template.getDirector().toLowerCase())).collect(Collectors.toList());
        }

        if (template.getGenre() != null) {
            movies = movies.stream().filter(movie -> movie.getGenre() == template.getGenre()).collect(Collectors.toList());
        }

        if (template.getMinutes() != null) {
            movies = movies.stream().filter(movie -> movie.getMinutes() <= template.getMinutes()).collect(Collectors.toList());
        }


        return movies;
    }
}
