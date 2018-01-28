package com.lasalle.mdpa.architecture.view.model;

import android.content.res.Resources;

import com.lasalle.mdpa.architecture.manager.LibraryManager;

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
        List<String> movieList = libraryManager.getMovieTitleList();
        movieListObserver.onListItemsChanged(movieList);

        List<String> tvshowList = libraryManager.getTvShowTitleList();
        tvShowListObserver.onListItemsChanged(tvshowList);
    }

    @Override
    public void subscribeMovieListChanges(ListObserver observer) {
        movieListObserver = observer;
    }

    @Override
    public void subscribeTvShowListChanges(ListObserver observer) {
        tvShowListObserver = observer;
    }
}
