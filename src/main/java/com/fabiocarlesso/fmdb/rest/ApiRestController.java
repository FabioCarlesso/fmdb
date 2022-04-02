package com.fabiocarlesso.fmdb.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fabiocarlesso.fmdb.domain.Movie;
import com.fabiocarlesso.fmdb.domain.TOP250Info;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ApiRestController {
    
    @Value("${apikey}")
    private String imdbApiKey;
    
    @GetMapping(value="/top250")
    public String getImdbClient() {
        String uri = "https://imdb-api.com/en/API/Top250Movies/"+this.imdbApiKey;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        Gson gson = new Gson();
        TOP250Info top250info = gson.fromJson(result, TOP250Info.class);
        for(Movie movie : top250info.getItems()) {
            System.out.println(movie.getRank() +" - "+movie.getTitle()+" "+movie.getYear()+" - "+movie.getImDbRating());
            // System.out.println(movie.toString());
        }
        return result;
    }
    
}
