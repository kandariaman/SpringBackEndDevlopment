package com.gfg.jbdll.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class Movie implements Serializable {
   private Integer id;
   private String title;
   private GENRE genre;
   private Double rating;
   private LocalDate releaseDate;

   public Movie(Integer id, String title, GENRE genre, Double rating, LocalDate releaseDate) {
      this.id = id;
      this.title = title;
      this.genre = genre;
      this.rating = rating;
      this.releaseDate = releaseDate;
   }


   protected boolean canEqual(final Object other) {
      return other instanceof Movie;
   }

}
