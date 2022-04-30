package com.javatest.movie.data;

import com.javatest.movie.model.Genre;
import com.javatest.movie.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;
import java.util.Objects;

public class MovieRepositoryJdbc implements MovieRepository {

    private final JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", movieRowMapper, args);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieRowMapper);
    }

    private final RowMapper<Movie> movieRowMapper = (rs, rowNum) -> new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("minutes"),
            Genre.valueOf(rs.getString("genre")),
            rs.getString("director")
    );

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies (id, name, minutes, genre) values (?, ?, ? ,?)", movie.getId(), movie.getName(), movie.getMinutes(), movie.getGenre().toString());
    }

    public Integer getMaxRowsMovies() {
        return jdbcTemplate.queryForObject("SELECT MAX(id) FROM movies", Integer.class);
    }

    public Collection<Movie> findByName(String name){
        return jdbcTemplate.query("SELECT * FROM movies WHERE name ilike '%" + name + "%'", movieRowMapper);
    }

    public Collection<Movie> findByNameDirector(String director){
        return jdbcTemplate.query("SELECT * FROM movies WHERE director ilike '%" + director + "%'", movieRowMapper);
    }

}
