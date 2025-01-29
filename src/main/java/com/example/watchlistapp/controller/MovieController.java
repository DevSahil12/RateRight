package com.example.watchlistapp.controller;

import com.example.watchlistapp.entity.Movie;
import com.example.watchlistapp.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MovieController {
    @Autowired
    DatabaseService service;

    @GetMapping(value = "/watchlistItemForm")
    public ModelAndView showWatchListForm() {
        //Fetch the form and Dynamically mapping with object
        String viewName = "watchlistItemForm";
        Map<String, Object> model = new HashMap<>();
        model.put("watchlistItem", new Movie());//map with html 35
        return new ModelAndView(viewName, model);

    }

    @PostMapping(value = "/watchlistItemForm")
    public ModelAndView submitWatchListForm(Movie movie) {
        service.create(movie);
        RedirectView rd = new RedirectView();
        rd.setUrl("/watchlist");
        return new ModelAndView(rd);

    }

    @GetMapping(path = "/watchlist")
    public ModelAndView getWatchlist() {
        String viewName = "watchlist";
        Map<String, Object> model = new HashMap<>();
        List<Movie> moviesList = service.getAllMovies();
        model.put("watchlistrows", moviesList);
        model.put("noofmovies", moviesList.size());
        return new ModelAndView(viewName, model);

    }

}
