package com.gfg.jbdll.Repository;

import com.gfg.jbdll.domain.GENRE;
import com.gfg.jbdll.domain.Movie;
import com.sun.jdi.ArrayReference;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    List<Movie> movieList = new ArrayList<>();

    @Override
    public List<Movie> find100moviebyOrder() {
        Movie movie1 = new Movie(2, "MIB-2", GENRE.ACTION, 5.0, "2023-07-01");
        movieList.add(1, );
    }

    @Override
    public Object save(Object entity) {
        return null;
    }

    @Override
    public Iterable saveAll(Iterable entities) {
        return null;
    }

    @Override
    public Optional findById(Object o) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Object o) {
        return false;
    }

    @Override
    public Iterable findAll() {
        return null;
    }

    @Override
    public Iterable findAllById(Iterable iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Object o) {

    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public void deleteAllById(Iterable iterable) {

    }

    @Override
    public void deleteAll(Iterable entities) {

    }

    @Override
    public void deleteAll() {

    }
}
