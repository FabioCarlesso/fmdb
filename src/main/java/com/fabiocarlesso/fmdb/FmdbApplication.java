package com.fabiocarlesso.fmdb;

import java.util.List;

import com.fabiocarlesso.fmdb.domain.Movie;
import com.fabiocarlesso.fmdb.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FmdbApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FmdbApplication.class, args);
	}

	@Autowired
	MovieService movieService;

	@Override
	public void run(String... args) throws Exception {
		// Test movies
		// List<Movie> movies = movieService.findTOP250Movies();
		// for(Movie movie : movies) {
        //     System.out.println(movie.getRank() +" - "+movie.getTitle()+" "+movie.getYear()+" - "+movie.getImDbRating());
        // }
	}

}
