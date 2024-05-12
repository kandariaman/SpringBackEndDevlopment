package com.gfg.jbdll.domain;

import lombok.Data;

import java.io.Serializable;

@Data

public class Movie implements Serializable {
   private Integer id;
   private String title;
   private GENRE genre;
   private Double rating;

   public Movie(Integer id, String title, GENRE genre, Double rating) {
      this.id = id;
      this.title = title;
      this.genre = genre;
      this.rating = rating;
   }

   protected boolean canEqual(final Object other) {
      return other instanceof Movie;
   }

}
