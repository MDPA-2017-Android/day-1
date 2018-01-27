package com.lasalle.mdpa.architecture.manager;

import android.content.res.Resources;
import android.util.Log;

import com.lasalle.mdpa.architecture.R;
import com.lasalle.mdpa.architecture.model.Movie;
import com.lasalle.mdpa.architecture.model.TvShow;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    private List<Movie> movieList;
    private List<TvShow> tvShowList;

    private Resources resources;

    public LibraryManager(Resources resources) {
        this.resources = resources;
        fillMovieListFromFile();
        fillTvShowListFromFile();
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

    private void fillMovieListFromFile() {
        try {
            String jsonContent = readJsonFile(R.raw.movies);
            if(jsonContent.isEmpty()) {
                return;
            }

            movieList = new ArrayList<Movie>();
            JSONArray jsonArray = new JSONArray(jsonContent);
            for(int index = 0; index < jsonArray.length(); ++index)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                String title = jsonObject.getString("title");
                String director = jsonObject.getString("director");
                int releaseYear = jsonObject.getInt("release");

                movieList.add(new Movie(title, director, releaseYear));
            }
        }
        catch (Exception e) {
            Log.e(this.getClass().getName(), e.getMessage());
        }
    }

    private void fillTvShowListFromFile() {
        try {
            String jsonContent = readJsonFile(R.raw.tvshows);
            if(jsonContent.isEmpty()) {
                return;
            }

            tvShowList = new ArrayList<TvShow>();
            JSONArray jsonArray = new JSONArray(jsonContent);
            for(int index = 0; index < jsonArray.length(); ++index)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                String title = jsonObject.getString("title");
                boolean ended = jsonObject.getBoolean("ended");
                int seasons = jsonObject.getInt("seasons");

                tvShowList.add(new TvShow(title, ended, seasons));
            }
        }
        catch (Exception e) {
            Log.e(this.getClass().getName(), e.getMessage());
        }
    }

    private String readJsonFile(int file) {
        InputStream is = resources.openRawResource(file);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        }
        catch (Exception e) {
            Log.e(this.getClass().getName(), e.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                Log.e(this.getClass().getName(), e.getMessage());
            }
        }

        String jsonString = writer.toString();
        return jsonString;
    }
}
