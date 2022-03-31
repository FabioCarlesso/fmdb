package com.fabiocarlesso.fmdb.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
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
        return restTemplate.getForObject(uri, String.class);
    }
    
}
