package com.gfg.jbdll.service.resources;

import com.gfg.jbdll.domain.GENRE;
import com.gfg.jbdll.domain.Movie;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {

    @NotBlank(message = "title cannot be blank")
    private String title;

    @NotBlank(message = "Genre cannot be blank")
    private GENRE genre;

    @NotBlank(message = "releaseDate cannot be blank")
    private String releaseDate;

    public Movie getMovieFromRequest(){
        return Movie.builder().title(this.title).genre(this.genre).releaseDate(LocalDate.parse(this.releaseDate)).build();
    }
}
