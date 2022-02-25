package com.example.moviesworkshop.Controllers;


import com.example.moviesworkshop.Models.Movie;
import com.example.moviesworkshop.repositories.MovieDataRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

@RestController
public class MovieController {
    MovieDataRepository data = new MovieDataRepository();
    ArrayList<Movie> allMovies =  data.allMovies();

    @GetMapping("/")
    public String welcomePage() {
        return "Welcome to the movie website";
    }

    @GetMapping("/getFirst")
    public String getFirst() {
        return allMovies.get(0).toString();
    }

    @GetMapping("/getRandom")
    public String showRandom(){
        return getRandom().toString();
    }

    @GetMapping("/getTenSortByPopularity")
    public String getTopTen(){
        ArrayList<Movie> moviesToSort = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            moviesToSort.add(getRandom());
        }
        Collections.sort(moviesToSort);
        String stringToPrint = "";
        for(int i = 0 ; i < 10 ; i++){
            stringToPrint = stringToPrint + moviesToSort.get(i).toString() +"                   ";
        }
        return stringToPrint;
    }

    @GetMapping("/howManyWonAnAward")
    public String awards(){
        int count =0;
        for(int i = 0; i < allMovies.size(); i++){
            if(allMovies.get(i).getAwards() == true){
                count ++;
            }
        }
        return String.valueOf(count);
    }

    public Movie getRandom(){
        Random rand = new Random();
        int randomnumber = rand.nextInt(allMovies.size());
        return allMovies.get(randomnumber);
    }


}
