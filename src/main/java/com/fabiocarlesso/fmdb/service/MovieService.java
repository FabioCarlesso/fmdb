package com.fabiocarlesso.fmdb.service;

import java.util.List;

import com.fabiocarlesso.fmdb.domain.Movie;
import com.fabiocarlesso.fmdb.domain.TOP250Info;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {
    
    @Value("${apikey}")
    private String imdbApiKey;
    
    private static final String IMDB_URI = "https://imdb-api.com/en/API/Top250Movies/";

    public List<Movie> findTOP250Movies() {
        String result = getJsonToStringFromImdb();
        Gson gson = new Gson();
        TOP250Info top250info = gson.fromJson(result, TOP250Info.class);
        return top250info.getItems();
    }

    public String getJsonToStringFromImdb (){
        String uri = IMDB_URI+imdbApiKey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }

}
