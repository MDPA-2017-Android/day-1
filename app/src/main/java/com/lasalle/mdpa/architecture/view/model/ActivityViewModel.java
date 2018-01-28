package com.lasalle.mdpa.architecture.view.model;

public interface ActivityViewModel {

    void onViewCreated();

    void subscribeMovieListChanges(ListObserver observer);
    void subscribeTvShowListChanges(ListObserver observer);


}
