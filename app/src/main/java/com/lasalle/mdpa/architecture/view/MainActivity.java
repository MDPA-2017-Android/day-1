package com.lasalle.mdpa.architecture.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lasalle.mdpa.architecture.R;
import com.lasalle.mdpa.architecture.presenter.ActivityPresenter;
import com.lasalle.mdpa.architecture.presenter.LibraryPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private ActivityPresenter libraryPresenter = new LibraryPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        libraryPresenter.onCreate();
    }

    @Override
    public void populateMovies(List<String> movies) {
        ListView movieListView = (ListView) findViewById(R.id.movie_list);
        PopulateListView(movieListView, movies);
    }

    @Override
    public void populateTvShows(List<String> tvShows) {
        ListView tvShowListView = (ListView) findViewById(R.id.shows_list);
        PopulateListView(tvShowListView, tvShows);
    }

    private void PopulateListView(ListView listView, List<String> items) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                items );

        listView.setAdapter(arrayAdapter);
    }

}
