package com.lasalle.mdpa.architecture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lasalle.mdpa.architecture.model.Library;
import com.lasalle.mdpa.architecture.model.Movie;
import com.lasalle.mdpa.architecture.model.TvShow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Library library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        library = new Library();

        PopulateMoviesList();
        PopulateTvShowsList();
    }

    private void PopulateMoviesList() {
        List<Movie> movieList = library.getMovieList();

        List<String> movieTitleList = new ArrayList<String>();
        for (Movie m : movieList) {
            movieTitleList.add(m.getTitle());
        }

        ListView movieListView = (ListView) findViewById(R.id.movie_list);
        PopulateListView(movieListView, movieTitleList);
    }


    private void PopulateTvShowsList() {
        List<TvShow> showList = library.getTvShowList();

        List<String> tvShowTitleList = new ArrayList<String>();
        for (TvShow s : showList) {
            tvShowTitleList.add(s.getTitle());
        }

        ListView tvShowListView = (ListView) findViewById(R.id.shows_list);
        PopulateListView(tvShowListView, tvShowTitleList);
    }

    private void PopulateListView(ListView listView, List<String> items) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                items );

        listView.setAdapter(arrayAdapter);
    }

}
