package com.example.moviesworkshop.repositories;

import com.example.moviesworkshop.Models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDataRepository {


    public ArrayList<Movie> allMovies() {
        File file = new File("./datafiles/imdb-data.csv");
        Scanner scan;

        int yearCreated;
        int length;
        String title;
        String subject;
        int popularity;
        boolean awards;
        String parseAwards;

        ArrayList<Movie> allMovies = new ArrayList<>();

        {
            try {
                scan = new Scanner(file);
                scan.nextLine();
               // scan.useDelimiter(";");
                int i = 0;
                String input;
                String nextInput;
                int index;
                while (scan.hasNext()) {

                    input = scan.nextLine();


                    index = input.indexOf(";");
                    nextInput = input.substring(0,index);
                    input = input.substring(index+1);
                    yearCreated = Integer.parseInt(nextInput);

                    index = input.indexOf(";");
                    nextInput = input.substring(0,index);
                    input = input.substring(index+1);
                    length = Integer.parseInt(nextInput);

                    index = input.indexOf(";");
                    nextInput = input.substring(0,index);
                    input = input.substring(index+1);
                    title = nextInput;

                    index = input.indexOf(";");
                    nextInput = input.substring(0,index);
                    input = input.substring(index+1);
                    subject = nextInput;

                    index = input.indexOf(";");
                    nextInput = input.substring(0,index);
                    input = input.substring(index+1);
                    popularity = Integer.parseInt(nextInput);


                    parseAwards = input;

                    if (parseAwards.equals("Yes")) {
                        awards = true;
                    } else {
                        awards = false;
                    }
                    allMovies.add(new Movie(yearCreated, length, title, subject, popularity, awards));

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return allMovies;
    }


}
