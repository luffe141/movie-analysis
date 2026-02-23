package com.example.moviespring.controllers;

import com.example.moviespring.repositories.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {
    private MovieRepository service = new MovieRepository();

    @GetMapping("/welcome")
    public ModelAndView getFirst(){

    }
}
