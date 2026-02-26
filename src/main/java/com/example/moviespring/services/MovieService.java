package com.example.moviespring.services;

import java.util.List;

import com.example.moviespring.models.Movie;
import com.example.moviespring.repositories.MovieRepository;

public class MovieService {
    private MovieRepository movieRepo = new MovieRepository();
    private List<Movie> allMovies = movieRepo.getAllMovies();

    public Movie getFirst(){
        return allMovies.get(0);
    }

    public int getCount(){
        return allMovies.size();
    }

    public double getAverageLength() {
        if (allMovies.isEmpty()) return 0;
        int totalLength = 0;
        for (Movie m : allMovies) {
            totalLength += m.getLength();
        }
        return (double) totalLength / allMovies.size();
    }

    public double getAverageAwardsAge() {
    if (allMovies.isEmpty()) return 0;
    int totalYear = 0;
    int count = 0;
    for (Movie m : allMovies) {
        if (m.isAwards()) {
            totalYear += m.getYear();
            count++;
        }
    }
    return count > 0 ? (double) totalYear / count : 0;
}
}
