package com.lasalle.mdpa.architecture.presenter;

import com.lasalle.mdpa.architecture.manager.LibraryManager;
import com.lasalle.mdpa.architecture.view.MainView;

import java.util.List;

public class LibraryPresenter implements ActivityPresenter {

    private MainView view;
    private LibraryManager libraryManager = new LibraryManager();

    public LibraryPresenter(MainView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        libraryManager.setResources(view.getResources());

        List<String> movieList = libraryManager.getMovieTitleList();
        view.populateMovies(movieList);

        List<String> tvshowList = libraryManager.getTvShowTitleList();
        view.populateTvShows(tvshowList);
    }

}
