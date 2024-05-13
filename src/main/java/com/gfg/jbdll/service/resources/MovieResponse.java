package com.gfg.jbdll.service.resources;

import com.gfg.jbdll.domain.GENRE;
import com.gfg.jbdll.domain.Movie;

import java.time.LocalDate;

public class MovieResponse {

    private Integer id;
    private String title;
    private GENRE genre;
    private Double rating;
    private LocalDate releaseDate;

    public Movie getResponseFromMovie(Movie movie) {
        return movie;
    }

}
