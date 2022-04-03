package com.fabiocarlesso.fmdb.rest;

import org.springframework.web.bind.annotation.RestController;

import com.fabiocarlesso.fmdb.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ApiRestController {
    
    @Autowired
    MovieService movieService;
    
    @GetMapping(value="/top250")
    public String gitAll() {
        return movieService.getJsonToStringFromImdb();
    }
    
}
