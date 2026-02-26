package com.example.moviespring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.moviespring.models.Movie;
import com.example.moviespring.services.MovieService;



@Controller
public class MovieController {
        @GetMapping("/examples/averageAwardAge")
        public ModelAndView getAverageAwardAgeExample(){
            return getAverageAwardAge();
        }
    private MovieService service = new MovieService();

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("name","Nicklas");
        return mav;
    }

    //Return how many movies are in the data file
    @GetMapping("/count")
    public ModelAndView count(){
        ModelAndView mav = new ModelAndView("examples/count");
        int count = service.getCount();
        mav.addObject("count", count);
        return mav;
    }

    @GetMapping("/first")
    public ModelAndView getFirst(){
        ModelAndView mav = new ModelAndView();
        Movie first = service.getFirst();
        mav.addObject("firstMovie",first);
        return new ModelAndView("first");
    }

    @GetMapping("/averageLength")
    public ModelAndView getAverageLength(){
        ModelAndView mav = new ModelAndView("examples/averageLength");
        double avgLength = service.getAverageLength();
        mav.addObject("averageLength", avgLength);
        return mav;
    }
    @GetMapping("/averageAwardAge")
    public ModelAndView getAverageAwardAge(){
        ModelAndView mav = new ModelAndView("examples/averageAwardAge");
        double avgAwardAge = service.getAverageAwardsAge();
        mav.addObject("averageAwardAge", avgAwardAge);
        return mav;
    }
    
}
