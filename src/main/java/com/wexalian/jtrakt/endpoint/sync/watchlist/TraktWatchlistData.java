package com.wexalian.jtrakt.endpoint.sync.watchlist;

import com.wexalian.jtrakt.endpoint.TraktIds;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeason;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

import java.util.ArrayList;
import java.util.List;

public class TraktWatchlistData {
    private List<MovieData> movies;
    private List<ShowData> shows;
    private List<SeasonData> seasons;
    private List<EpisodeData> episodes;
    
    public void addMovie(TraktMovie movie) {
        if (movies == null) {
            movies = new ArrayList<>();
        }
        movies.add(new MovieData(movie));
    }
    
    public ShowData addShow(TraktShow show) {
        if (shows == null) {
            shows = new ArrayList<>();
        }
        ShowData showData = new ShowData(show);
        shows.add(showData);
        return showData;
    }
    
    public void addSeason(TraktSeason season) {
        if (seasons == null) {
            seasons = new ArrayList<>();
        }
        seasons.add(new SeasonData(season));
    }
    
    public void addEpisode(TraktEpisode episode) {
        if (episodes == null) {
            episodes = new ArrayList<>();
        }
        episodes.add(new EpisodeData(episode));
    }
    
    private static class MovieData {
        private final String title;
        private final int year;
        private final TraktIds ids;
        
        public MovieData(TraktMovie movie) {
            this.title = movie.getTitle();
            this.year = movie.getYear();
            this.ids = movie.getIds();
        }
    }
    
    public static class ShowData {
        private final String title;
        private final int year;
        private final TraktIds ids;
        
        private List<Season> seasons;
        
        public ShowData(TraktShow show) {
            this.title = show.getTitle();
            this.year = show.getYear();
            this.ids = show.getIds();
        }
        
        public Season addSeason(int number) {
            if (seasons == null) {
                seasons = new ArrayList<>();
            }
            Season season = new Season(number);
            seasons.add(season);
            return season;
        }
        
        public static class Season {
            private final int number;
            private List<Episode> episodes;
            
            public Season(int number) {
                this.number = number;
            }
            
            public void addEpisode(int number) {
                if (episodes == null) {
                    episodes = new ArrayList<>();
                }
                episodes.add(new Episode(number));
            }
            
            public static class Episode {
                private final int number;
                
                public Episode(int number) {
                    this.number = number;
                }
            }
        }
        
    }
    
    public static class SeasonData {
        private final TraktIds ids;
        
        public SeasonData(TraktSeason episode) {
            this.ids = episode.getIds();
        }
    }
    
    public static class EpisodeData {
        private final TraktIds ids;
        
        public EpisodeData(TraktEpisode episode) {
            this.ids = episode.getIds();
        }
    }
}
