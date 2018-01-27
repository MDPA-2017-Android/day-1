package com.lasalle.mdpa.architecture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView movieListView = (ListView) findViewById(R.id.movie_list);
        ListView tvShowListView = (ListView) findViewById(R.id.shows_list);

        // Fill Movies
        List<String> movieList = new ArrayList<String>();
        movieList.add("Origin");
        movieList.add("Star Wars IV – A New Hope (1977)");
        movieList.add("V – The Empire Strikes Back (1980)");
        movieList.add("VI – Return of the Jedi (1983)");
        movieList.add("Lord of the rings - The Two Towers");
        movieList.add("The Greatest Showman");
        movieList.add("The Godfather");
        movieList.add("The Fast and the Furious");
        movieList.add("Mad Max: Fury Road");

        // Fill tv shows
        List<String> showsList = new ArrayList<String>();
        showsList.add("Sons of Anarchy");
        showsList.add("Breaking Bad");
        showsList.add("Dexter");
        showsList.add("Luther");
        showsList.add("Game of Thrones");
        showsList.add("Lie to Me");
        showsList.add("Big bang theory");
        showsList.add("Modern Family");
        showsList.add("The Man in the High Castle");

        PopulateListView(movieListView, movieList);
        PopulateListView(tvShowListView, showsList);
    }

    private void PopulateListView(ListView listView, List<String> items)
    {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                items );

        listView.setAdapter(arrayAdapter);
    }

}
