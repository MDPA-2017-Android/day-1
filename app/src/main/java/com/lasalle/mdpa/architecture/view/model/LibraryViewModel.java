package com.lasalle.mdpa.architecture.view.model;

import android.content.res.Resources;

import com.lasalle.mdpa.architecture.manager.LibraryManager;
import com.lasalle.mdpa.architecture.model.Movie;
import com.lasalle.mdpa.architecture.model.TvShow;

import java.util.ArrayList;
import java.util.List;


public class LibraryViewModel implements ActivityViewModel {

    private LibraryManager libraryManager = new LibraryManager();

    private ListObserver movieListObserver;
    private ListObserver tvShowListObserver;

    public LibraryViewModel(Resources resources)
    {
        libraryManager.setResources(resources);
    }

    @Override
    public void onViewCreated() {
        populateMovieList();
        populateTvShowList();
    }

    @Override
    public void subscribeMovieListChanges(ListObserver observer) {
        movieListObserver = observer;
    }

    @Override
    public void subscribeTvShowListChanges(ListObserver observer) {
        tvShowListObserver = observer;
    }

    private void populateMovieList() {
        List<Movie> movieList = libraryManager.getMovieList();
        List<String> movieTitleList = new ArrayList<String>();
        for (Movie m : movieList) {
            movieTitleList.add(m.getTitle());
        }

        movieListObserver.onListItemsChanged(movieTitleList);
    }

    private void populateTvShowList() {
        List<TvShow> tvShowList = libraryManager.getTvShowList();
        List<String> tvShowTitleList = new ArrayList<String>();
        for (TvShow s : tvShowList) {
            tvShowTitleList.add(s.getTitle());
        }

        tvShowListObserver.onListItemsChanged(tvShowTitleList);
    }
}
