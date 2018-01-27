package com.lasalle.mdpa.architecture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lasalle.mdpa.architecture.manager.LibraryManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LibraryManager libraryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        libraryManager = new LibraryManager(getResources());

        PopulateMoviesList();
        PopulateTvShowsList();
    }

    private void PopulateMoviesList() {
        ListView movieListView = (ListView) findViewById(R.id.movie_list);
        PopulateListView(movieListView, libraryManager.getMovieTitleList());
    }


    private void PopulateTvShowsList() {
        ListView tvShowListView = (ListView) findViewById(R.id.shows_list);
        PopulateListView(tvShowListView, libraryManager.getTvShowTitleList());
    }

    private void PopulateListView(ListView listView, List<String> items) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                items );

        listView.setAdapter(arrayAdapter);
    }

}
