package com.lasalle.mdpa.architecture.manager;

import com.lasalle.mdpa.architecture.model.Movie;
import com.lasalle.mdpa.architecture.model.TvShow;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    private List<Movie> movieList;
    private List<TvShow> tvShowList;

    public LibraryManager() {
        fillMovieList();
        fillTvShowList();
    }

    public List<String> getMovieTitleList() {
        List<String> movieTitleList = new ArrayList<String>();
        for (Movie m : movieList) {
            movieTitleList.add(m.getTitle());
        }

        return movieTitleList;
    }

    public List<String> getTvShowTitleList() {
        List<String> tvShowTitleList = new ArrayList<String>();
        for (TvShow s : tvShowList) {
            tvShowTitleList.add(s.getTitle());
        }

        return tvShowTitleList;
    }

    private void fillMovieList() {
        movieList = new ArrayList<Movie>();
        movieList.add(new Movie("Inception", "Christopher Nolan", 2010));
        movieList.add(new Movie("Star Wars IV – A New Hope (1977)", "George Lucas", 1977));
        movieList.add(new Movie("Star Wars V – The Empire Strikes Back (1980)", "Irvin Kershner", 1980));
        movieList.add(new Movie("Star Wars VI – Return of the Jedi (1983)", "Richard Marquand", 1983));
        movieList.add(new Movie("Lord of the rings - The Two Towers", "Peter Jackson", 2002));
        movieList.add(new Movie("The Greatest Showman", "Michael Gracey", 2017));
        movieList.add(new Movie("The Godfather", "Francis Ford Coppola", 1972));
        movieList.add(new Movie("The Fast and the Furious", "Rob Cohen", 2001));
        movieList.add(new Movie("Mad Max: Fury Road", "George Miller", 2015));
    }

    private void fillTvShowList() {
        tvShowList = new ArrayList<TvShow>();
        tvShowList.add(new TvShow("Sons of Anarchy", true, 7));
        tvShowList.add(new TvShow("Breaking Bad", true, 5));
        tvShowList.add(new TvShow("Dexter", true, 8));
        tvShowList.add(new TvShow("Luther", false, 4));
        tvShowList.add(new TvShow("Game of Thrones", false, 7));
        tvShowList.add(new TvShow("Lie to Me", true, 3));
        tvShowList.add(new TvShow("Big bang theory", false, 11));
        tvShowList.add(new TvShow("Modern Family", false,9));
        tvShowList.add(new TvShow("The Man in the High Castle", false, 2));
    }
}
