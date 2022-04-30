package com.javatest.movie.data;

import com.javatest.movie.model.Genre;
import com.javatest.movie.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {
    public MovieRepositoryJdbc movieRepositoryJdbc;
    @Before
    public void setUp() throws Exception {
        DataSource dataSource = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/movies", "postgres", "QAZplm123");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
         movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
    }

//    @Test
//    public void load_all_movies() {
//        Collection<Movie> movies = movieRepositoryJdbc.findAll();
//
//        assertThat(movies, is(Arrays.asList(
//                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Director1"),
//                new Movie(2, "Memento", 113, Genre.THRILLER, "Director2"),
//                new Movie(3, "Matrix", 136, Genre.ACTION, "Director3"),
//                new Movie(5, "Super 8", 112, Genre.THRILLER, "Director4")
//        )));
//    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepositoryJdbc.findById(2);

        assertThat(movie, is(
                new Movie(2, "Memento", 113, Genre.THRILLER, "Director2")
        ));
    }

    @Test
    public void insert_movie() {
        Movie movie = new Movie("maxsuper", 128, Genre.THRILLER, "Director6");
        Integer idMax = movieRepositoryJdbc.getMaxRowsMovies() + 1;
        movie.setId(idMax);

        movieRepositoryJdbc.saveOrUpdate(movie);
        Integer idMaxAfterInsert = movieRepositoryJdbc.getMaxRowsMovies();
        assertThat(movie.getId(), is(idMaxAfterInsert));
    }

    @Test
    public void find_by_name() {
        Collection<Movie> movies = movieRepositoryJdbc.findByName("super");

        for (Movie mv: movies) {
            System.out.println(mv.getName());
            assertTrue(mv.getName().toLowerCase(Locale.ROOT).contains("super"));
        }

    }

    @Test
    public void find_by_name_Director() {
        Collection<Movie> movies = movieRepositoryJdbc.findByNameDirector("director1");
        assertTrue(movies.size() > 0);

        for (Movie mv : movies) {
            System.out.println(mv.getDirector());
            assertTrue(mv.getDirector().toLowerCase(Locale.ROOT).contains("director1"));
        }

    }
}