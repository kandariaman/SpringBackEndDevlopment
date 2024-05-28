package com.gfg.jbdll.service;

import com.gfg.jbdll.domain.Movie;
import jakarta.annotation.PostConstruct;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {

    @Autowired
    Connection connection;

    PreparedStatement getAllMovieStatement = null;

    PreparedStatement addMovieStatement =null;

    @PostConstruct
    public void createTable() throws SQLException {
        String query = "create table if not exists movie (id INT auto_increment primary key "
    }

    try(
    Statement statement = connection.createStatement()) {

    }catch (Exception ex){
        logger.error("error creating table");
    }

    try {
        addMovieStatement=
    }

    @Autowired
    RedisTemplate redisTemplate;

//    @Autowired
//    MovieRepository repository;

    public MovieService() {
        logger.info("Constructor called");
    }

    @PostConstruct
    public void createTable() throws SQLException {

        logger.info("post construct is called");
    }

    public boolean addMovie(Movie movie){
        int id=this.movieMap.size()+1;
        movie.setId(id);
        this.movieMap.put(id,movie);
        return true;
    }

    public boolean deleteMovie(Integer  id){
        movieMap.remove(id);
        return true;
    }

    public boolean updateMovie(Integer id,Movie movie){
        if(this.movieMap.containsKey(id)){
            this.movieMap.put(id,movie);
            return  true;
        }
        return false;
    }
    public List<Movie> getAllMovies(){
        return this.movieMap.values().stream().toList();
    }

    public Movie getMovieByTitle(String title){
        return this.movieMap.values()
                .stream()
                .filter(movie -> title.equals(movie.getTitle())).findFirst().orElse(null);
    }

    // Check if the movie is less than 30 days old add it to the cache
//    public void addToCache(Movie movie){
//        LocalDate now = movie.getReleaseDate().minusDays(30);
//        System.out.println("Value of now is : " + now);
//    }

    public List<Movie> getMoviesFromHomePage() {
        List<Movie> movieList = redisTemplate.opsForList().range(homepageMovieKeys, 0, -1);

        if(CollectionUtils.isEmpty(movieList)) {
//            movieList = repository.find100moviebyOrder();
            if(CollectionUtils.isEmpty(movieList)){
                movieList.stream().forEach(movie -> redisTemplate.opsForList().rightPush(homepageMovieKeys, movie));
            }


        }
        return movieList;
    }
}
