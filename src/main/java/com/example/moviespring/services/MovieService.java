package com.example.moviespring.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String getMostPopularGenre() {
        if (allMovies.isEmpty()) return "No movies available";
        Map<String, Integer> genrePopularity = new HashMap<>();
        for (Movie m : allMovies) {
            genrePopularity.put(m.getSubject(), genrePopularity.getOrDefault(m.getSubject(), 0) + m.getPopularity());
        }
        return genrePopularity.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No genres available");
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }
}
