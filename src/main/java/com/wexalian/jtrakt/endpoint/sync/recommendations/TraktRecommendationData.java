package com.wexalian.jtrakt.endpoint.sync.recommendations;

import com.wexalian.jtrakt.endpoint.TraktIds;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

import java.util.ArrayList;
import java.util.List;

public class TraktRecommendationData {
    private List<MovieData> movies;
    private List<ShowData> shows;
    
    public void addMovie(TraktMovie movie, String notes) {
        if (movies == null) {
            movies = new ArrayList<>();
        }
        movies.add(new MovieData(movie, notes));
    }
    
    public ShowData addShow(TraktShow show, String notes) {
        if (shows == null) {
            shows = new ArrayList<>();
        }
        ShowData showData = new ShowData(show, notes);
        shows.add(showData);
        return showData;
    }
    
    private static class MovieData {
        private final String title;
        private final int year;
        private final TraktIds ids;
        
        private final String notes;
        
        public MovieData(TraktMovie movie, String notes) {
            this.title = movie.getTitle();
            this.year = movie.getYear();
            this.ids = movie.getIds();
            this.notes = notes;
        }
    }
    
    public static class ShowData {
        private final String title;
        private final int year;
        private final TraktIds ids;
        
        private final String notes;
        
        public ShowData(TraktShow show, String notes) {
            this.title = show.getTitle();
            this.year = show.getYear();
            this.ids = show.getIds();
            this.notes = notes;
        }
    }
}
