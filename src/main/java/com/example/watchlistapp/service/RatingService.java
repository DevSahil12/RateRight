package com.example.watchlistapp.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingService {
    String API_URL = "https://www.omdbapi.com/?i=tt3896198&apikey=8440cd4e&t=";

    public String getMovieRating(String title) {
        try {
            RestTemplate rT = new RestTemplate();
            ResponseEntity<ObjectNode> response = rT.getForEntity(API_URL + title, ObjectNode.class);
            ObjectNode jsonNodes = response.getBody();
            return jsonNodes.path("imdbRating").asText();
        } catch (Exception e) {
            System.out.println("Either movie name is not available or api is down " + e.getMessage());
            return null;
        }
    }
}