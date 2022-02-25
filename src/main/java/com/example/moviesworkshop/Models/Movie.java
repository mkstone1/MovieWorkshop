package com.example.moviesworkshop.Models;

public class Movie implements Comparable<Movie>{

    private int yearCreated;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    private boolean awards;

    public Movie(int yearCreated, int length, String title, String subject, int popularity, boolean awards) {
        this.yearCreated = yearCreated;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;
    }

    private int getPopularity(){
        return popularity;
    }

    public boolean getAwards(){
        return awards;
    }

    @Override
    public String toString() {
        return "yearCreated=" + yearCreated +
                ", length=" + length +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", popularity=" + popularity +
                ", awards=" + awards +
                '}';
    }

    @Override
    public int compareTo(Movie movieToCompare) {
        if (this.getPopularity() < movieToCompare.getPopularity()){
            return -1;
        }
        else{
            return 1;
        }
    }
}
