package com.wexalian.jtrakt.endpoint.sync;

import com.wexalian.jtrakt.endpoint.TraktIds;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class TraktSyncItems<T> {
    private final List<T> movies = new ArrayList<>();
    private final List<T> shows = new ArrayList<>();
    private final List<T> seasons = new ArrayList<>();
    private final List<T> episodes = new ArrayList<>();
    private final List<T> people = new ArrayList<>();
    private final List<T> ids = new ArrayList<>();
    
    public void addMovie(T movie) {
        movies.add(movie);
    }
    
    public void addShow(T show) {
        shows.add(show);
    }
    
    public void addSeason(T season) {
        seasons.add(season);
    }
    
    public void addEpisode(T episode) {
        episodes.add(episode);
    }
    
    public void addPeople(T person) {
        people.add(person);
    }
    
    public void addHistoryId(T id) {
        ids.add(id);
    }
    
    public static class Movie {
        private final String title;
        private final int year;
        private final TraktIds ids;
        
        public Movie(String title, int year, TraktIds ids) {
            this.title = title;
            this.year = year;
            this.ids = ids;
        }
        
    }
    
    public static class Show {
        private final String title;
        private final int year;
        private final TraktIds ids;
        
        private final List<Season> seasons = new ArrayList<>();
        
        public Show(String title, int year, TraktIds ids) {
            this.title = title;
            this.year = year;
            this.ids = ids;
        }
        
        public void addSeason(Season season) {
            seasons.add(season);
        }
        
        public static class Season {
            private final int number;
            private final OffsetDateTime watched_at;
            
            private final List<Episode> episodes = new ArrayList<>();
            
            public Season(int number, OffsetDateTime watched_at) {
                this.number = number;
                this.watched_at = watched_at;
            }
            
            public void addEpisode(Episode episode) {
                episodes.add(episode);
            }
            
            public static class Episode {
                private final int number;
                private final OffsetDateTime watched_at;
                
                public Episode(int number, OffsetDateTime watched_at) {
                    this.number = number;
                    this.watched_at = watched_at;
                }
            }
        }
    }
    
    public static class Season {
        private final int number;
        private final TraktIds ids;
        
        public Season(int number, TraktIds ids) {
            this.number = number;
            this.ids = ids;
        }
    }
    
    public static class Episode {
        private final int season;
        private final int number;
        private final String title;
        private final TraktIds ids;
        
        public Episode(int season, int number, String title, TraktIds ids) {
            this.season = season;
            this.number = number;
            this.title = title;
            this.ids = ids;
        }
    }
}
