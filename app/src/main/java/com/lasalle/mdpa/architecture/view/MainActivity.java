package com.lasalle.mdpa.architecture.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lasalle.mdpa.architecture.R;
import com.lasalle.mdpa.architecture.view.model.ActivityViewModel;
import com.lasalle.mdpa.architecture.view.model.LibraryViewModel;
import com.lasalle.mdpa.architecture.view.model.ListObserver;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityViewModel libraryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        libraryViewModel = new LibraryViewModel(getResources());

        libraryViewModel.subscribeMovieListChanges(new ListObserver() {
            @Override
            public void onListItemsChanged(List items) {
                ListView movieListView = (ListView) findViewById(R.id.movie_list);
                populateListView(movieListView, items);
            }
        });

        libraryViewModel.subscribeTvShowListChanges(new ListObserver() {
            @Override
            public void onListItemsChanged(List items) {
                ListView tvShowListView = (ListView) findViewById(R.id.shows_list);
                populateListView(tvShowListView, items);
            }
        });

        libraryViewModel.onViewCreated();
    }

    private void populateListView(ListView listView, List<String> items) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                items );

        listView.setAdapter(arrayAdapter);
    }

}
