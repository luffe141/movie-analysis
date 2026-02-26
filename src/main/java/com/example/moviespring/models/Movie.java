package com.example.moviespring.models;

public class Movie {
    private int year;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    public boolean awards;
    private int awardsAge;

    public Movie(String unparsedMovie){
        String[] splitMovie = unparsedMovie.split(";");
        this.year = Integer.parseInt(splitMovie[0]);
        this.length = Integer.parseInt(splitMovie[1]);
        this.title = splitMovie[2];
        this.subject = splitMovie[3];
        this.popularity = Integer.parseInt(splitMovie[4]);

        if(splitMovie[5].equalsIgnoreCase("yes")) {
            this.awards = true;
        } else {
            this.awards = false;
        }

        // If awardsAge exists in CSV, parse it, otherwise set to 0
        if (splitMovie.length > 6) {
            try {
                this.awardsAge = Integer.parseInt(splitMovie[6]);
            } catch (Exception e) {
                this.awardsAge = 0;
            }
        } else {
            this.awardsAge = 0;
        }
    }

    public int getYear() {
        return year;
    }

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public int getPopularity() {
        return popularity;
    }

    public boolean isAwards() {
        return awards;
    }

    public int getAwardsAge() {
        return awardsAge;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "year=" + year +
                ", length=" + length +
                ", title='" + title + '\'' +
                ", Subject='" + subject + '\'' +
                ", popularity=" + popularity +
                ", awards=" + awards +
                '}';
    }

    
}
