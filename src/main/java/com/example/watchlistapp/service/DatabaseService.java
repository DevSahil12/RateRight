package com.example.watchlistapp.service;

import com.example.watchlistapp.entity.Movie;
import com.example.watchlistapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {
    @Autowired //no need to create object explicitly
    MovieRepository movieRepository;
    @Autowired
    RatingService ratingService;

    public void create(Movie movie) {
        String rating = ratingService.getMovieRating(movie.getTitle());
        if (rating != null) {
            movie.setRating(Float.parseFloat(rating));
        }
        movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    public void update(Movie movie, Integer id) {
        Movie tobeUpdated = getMovieById(id);
        tobeUpdated.setTitle(movie.getTitle());
        tobeUpdated.setComment(movie.getComment());
        tobeUpdated.setPriority(movie.getPriority());
        tobeUpdated.setRating(movie.getRating());
        movieRepository.save(tobeUpdated);
    }

//    public void deleteMovieById(Movie movie) {
//        movieRepository.deleteById(movie.getId());
//    }
}
