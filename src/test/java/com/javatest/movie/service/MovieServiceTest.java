package com.javatest.movie.service;

import com.javatest.movie.data.MovieRepository;
import com.javatest.movie.model.Genre;
import com.javatest.movie.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieServiceTest {
    MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION, "Director1"),
                        new Movie(2, "Memento", 113, Genre.THRILLER, "Director2"),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY, "Director3"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER, "Director4"),
                        new Movie(5, "Scream", 111, Genre.HORROR, "Director1"),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY, "Director6"),
                        new Movie(7, "Matrix", 136, Genre.ACTION, "Director7"),
                        new Movie(8, "SuperMan", 36, Genre.ACTION, "Director8"))

        );
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {
        Collection<Movie> moviesByGender = movieService.findMovieByGenre(Genre.COMEDY);
        assertThat(getMovieIds(moviesByGender), is(Arrays.asList(3, 6)));
    }

    @Test
    public void return_movies_by_length() {
        Collection<Movie> moviesByLength = movieService.findMoviesByLength(120);
        assertThat(getMovieIds(moviesByLength), is(Arrays.asList(2, 3, 4, 5, 6, 8)));
    }

    @Test
    public void return_movies_by_name() {
        Collection<Movie> moviesByLength = movieService.findByName("Super");
        assertThat(getMovieIds(moviesByLength), is(Arrays.asList(4, 8)));
    }

    @Test
    public void return_movies_by_name_director() {
        Collection<Movie> moviesByLength = movieService.findByNameDirector("director1");
        assertThat(getMovieIds(moviesByLength), is(Arrays.asList(1, 5)));
    }

    @Test
    public void return_movies_by_attributes() {
        String name = "super"; // no queremos buscar por nombre
        Integer minutes = 150; // 2h 30m
        Genre genre = Genre.ACTION;
        String director = null;
        Movie template = new Movie(name, minutes, genre, director);
        Collection<Movie> movies = movieService.findMoviesByTemplate(template);
        assertThat(getMovieIds(movies), is(Arrays.asList(4, 8)) );
    }

    private List<Integer> getMovieIds(Collection<Movie> moviesByLength) {
        return moviesByLength.stream().map(Movie::getId).collect(Collectors.toList());
    }
}