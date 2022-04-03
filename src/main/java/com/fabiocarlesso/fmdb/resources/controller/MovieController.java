package com.fabiocarlesso.fmdb.resources.controller;

import com.fabiocarlesso.fmdb.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {
    
    @Autowired
    MovieService movieService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("movies", movieService.findTOP250Movies());
        return "movie"; 
    }
    
}
