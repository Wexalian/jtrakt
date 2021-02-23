package com.wexalian.jtrakt.endpoint.sync.rating;

import com.wexalian.jtrakt.endpoint.TraktIds;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeason;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class TraktRatingData {
    private List<MovieData> movies;
    private List<ShowData> shows;
    private List<SeasonData> seasons;
    private List<EpisodeData> episodes;
    
    public void addMovie(TraktMovie movie, int rating, OffsetDateTime rated_at) {
        if (movies == null) {
            movies = new ArrayList<>();
        }
        movies.add(new MovieData(movie, rated_at, rating));
    }
    
    public ShowData addShow(TraktShow show) {
        
        if (shows == null) {
            shows = new ArrayList<>();
        }
        ShowData showData = new ShowData(show);
        shows.add(showData);
        return showData;
    }
    
    public ShowData addShow(TraktShow show, int rating, OffsetDateTime rated_at) {
        if (shows == null) {
            shows = new ArrayList<>();
        }
        ShowData showData = new ShowData(show, rating, rated_at);
        shows.add(showData);
        return showData;
    }
    
    public void addSeason(TraktSeason season, int rating, OffsetDateTime rated_at) {
        if (seasons == null) {
            seasons = new ArrayList<>();
        }
        seasons.add(new SeasonData(season, rating, rated_at));
    }
    
    public void addEpisode(TraktEpisode episode, int rating, OffsetDateTime rated_at) {
        if (episodes == null) {
            episodes = new ArrayList<>();
        }
        episodes.add(new EpisodeData(episode, rating, rated_at));
    }
    
    private static class MovieData {
        private final String title;
        private final int year;
        private final TraktIds ids;
        
        private OffsetDateTime rated_at;
        private int rating;
        
        public MovieData(TraktMovie movie) {
            this.title = movie.getTitle();
            this.year = movie.getYear();
            this.ids = movie.getIds();
        }
        
        public MovieData(TraktMovie movie, OffsetDateTime rated_at, int rating) {
            this(movie);
            this.rated_at = rated_at;
            this.rating = rating;
        }
    }
    
    public static class ShowData {
        private final String title;
        private final int year;
        private final TraktIds ids;
        
        private OffsetDateTime rated_at;
        private int rating;
        
        private List<Season> seasons;
        
        public ShowData(TraktShow show) {
            this.title = show.getTitle();
            this.year = show.getYear();
            this.ids = show.getIds();
        }
        
        public ShowData(TraktShow show, int rating, OffsetDateTime rated_at) {
            this(show);
            this.rated_at = rated_at;
            this.rating = rating;
        }
        
        public Season addSeason(int number, int rating, OffsetDateTime rated_at) {
            if (seasons == null) {
                seasons = new ArrayList<>();
            }
            Season season = new Season(number, rating, rated_at);
            seasons.add(season);
            return season;
        }
        
        public static class Season {
            private final int number;
            private final OffsetDateTime rated_at;
            private final int rating;
            private List<Episode> episodes;
            
            public Season(int number, int rating, OffsetDateTime rated_at) {
                this.number = number;
                this.rated_at = rated_at;
                this.rating = rating;
            }
            
            public void addEpisode(int number, int rating, OffsetDateTime rated_at) {
                if (episodes == null) {
                    episodes = new ArrayList<>();
                }
                episodes.add(new Episode(number, rating, rated_at));
            }
            
            public static class Episode {
                private final int number;
                
                private final OffsetDateTime rated_at;
                private final int rating;
                
                public Episode(int number, int rating, OffsetDateTime rated_at) {
                    this.number = number;
                    this.rated_at = rated_at;
                    this.rating = rating;
                }
            }
        }
        
    }
    
    public static class SeasonData {
        private final TraktIds ids;
        
        private OffsetDateTime rated_at;
        private int rating;
        
        public SeasonData(TraktSeason episode) {
            this.ids = episode.getIds();
        }
        
        public SeasonData(TraktSeason episode, int rating, OffsetDateTime rated_at) {
            this(episode);
            this.rated_at = rated_at;
            this.rating = rating;
        }
    }
    
    public static class EpisodeData {
        private final TraktIds ids;
        
        private OffsetDateTime rated_at;
        private int rating;
        
        public EpisodeData(TraktEpisode episode) {
            this.ids = episode.getIds();
        }
        
        public EpisodeData(TraktEpisode episode, int rating, OffsetDateTime rated_at) {
            this(episode);
            this.rated_at = rated_at;
            this.rating = rating;
        }
    }
}
