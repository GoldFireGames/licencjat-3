package com.nergamed.backend.controller;

import com.nergamed.backend.model.Movie;
import com.nergamed.backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>>searchMovies(@RequestParam String title) {
        List<Movie> foundMovies = movieService.searchByTitle(title);
        return new ResponseEntity<>(foundMovies, HttpStatus.OK);
    }


}
