package com.example.moviespring.repositories;

import com.example.moviespring.models.Movie;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieRepository {
    private File movieFile;
    private ArrayList<Movie> allMovies = new ArrayList<Movie>();

    public MovieRepository(){
        //Fetching the file
        InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("data/imdb-data.csv");

        Scanner scanner = new Scanner(is);
        //Skip the first line of the file
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            allMovies.add(new Movie(scanner.nextLine()));
        }
        scanner.close();
    }

    public ArrayList<Movie> getAllMovies(){
        return allMovies;
    }
}
