package com.example.watchlistapp.controller;

import com.example.watchlistapp.entity.Movie;
import com.example.watchlistapp.service.DatabaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView showWatchListForm(@RequestParam(required = false) Integer id) {
        //Fetch the form and Dynamically mapping with object
        String viewName = "watchlistItemForm";
        Map<String, Object> model = new HashMap<>();
        if (id != null) {
            model.put("watchlistItem", service.getMovieById(id));
        } else {
            model.put("watchlistItem", new Movie());
        }
        return new ModelAndView(viewName, model);
    }

    @PostMapping(value = "/watchlistItemForm")
    public ModelAndView submitWatchListForm(@Valid @ModelAttribute("watchlistItem") Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //if errors are there re-display the page
            return new ModelAndView("watchlistItemForm");
        }
        Integer id = movie.getId();
        if (id == null) {
            service.create(movie);
        } else {
            service.update(movie, id);
        }
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

//    @DeleteMapping("/deleteWatchlistItem")
//    public String deleteMovie( Movie movie) {
//        service.deleteMovieById(movie);
//        return "redirect:/watchlist";
//    }
}
