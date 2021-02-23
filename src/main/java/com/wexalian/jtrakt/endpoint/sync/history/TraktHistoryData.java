package com.wexalian.jtrakt.endpoint.sync.history;

import com.wexalian.jtrakt.endpoint.TraktIds;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeason;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TraktHistoryData {
    private List<MovieData> movies;
    private List<ShowData> shows;
    private List<SeasonData> seasons;
    private List<EpisodeData> episodes;
    private List<Long> ids;
    
    public void addMovie(TraktMovie movie) {
        addMovie(movie, (String) null);
    }
    
    public void addMovie(TraktMovie movie, OffsetDateTime watched_at) {
        addMovie(movie, watched_at.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
    }
    
    public void addMovie(TraktMovie movie, String watched_at) {
        if (movies == null) {
            movies = new ArrayList<>();
        }
        movies.add(new MovieData(movie, watched_at));
    }
    
    public ShowData addShow(TraktShow show) {
        return addShow(show, (String) null);
    }
    
    public ShowData addShow(TraktShow show, OffsetDateTime watched_at) {
        return addShow(show, watched_at.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
    }
    
    public ShowData addShow(TraktShow show, String watched_at) {
        if (shows == null) {
            shows = new ArrayList<>();
        }
        ShowData showData = new ShowData(show, watched_at);
        shows.add(showData);
        return showData;
    }
    
    public void addSeason(TraktSeason season) {
        addSeason(season, (String) null);
    }
    
    public void addSeason(TraktSeason season, OffsetDateTime watched_at) {
        addSeason(season, watched_at.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
    }
    
    public void addSeason(TraktSeason season, String watched_at) {
        if (seasons == null) {
            seasons = new ArrayList<>();
        }
        seasons.add(new SeasonData(season, watched_at));
    }
    
    public void addEpisode(TraktEpisode episode) {
        addEpisode(episode, (String) null);
    }
    
    public void addEpisode(TraktEpisode episode, OffsetDateTime watched_at) {
        addEpisode(episode, watched_at.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
    }
    
    public void addEpisode(TraktEpisode episode, String watched_at) {
        if (episodes == null) {
            episodes = new ArrayList<>();
        }
        episodes.add(new EpisodeData(episode, watched_at));
    }
    
    public void addId(long id) {
        if (ids == null) {
            ids = new ArrayList<>();
        }
        ids.add(id);
    }
    
    private static class MovieData {
        private final String title;
        private final int year;
        private final TraktIds ids;
        
        private String watched_at;
        
        public MovieData(TraktMovie movie) {
            this.title = movie.getTitle();
            this.year = movie.getYear();
            this.ids = movie.getIds();
        }
        
        public MovieData(TraktMovie movie, String watched_at) {
            this(movie);
            this.watched_at = watched_at;
        }
    }
    
    public static class ShowData {
        private final String title;
        private final int year;
        private final TraktIds ids;
        
        private String watched_at;
        
        private List<Season> seasons;
        
        public ShowData(TraktShow show) {
            this.title = show.getTitle();
            this.year = show.getYear();
            this.ids = show.getIds();
        }
        
        public ShowData(TraktShow show, String watched_at) {
            this(show);
            this.watched_at = watched_at;
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
        
        private String watched_at;
        
        public SeasonData(TraktSeason episode) {
            this.ids = episode.getIds();
        }
        
        public SeasonData(TraktSeason episode, String watched_at) {
            this(episode);
            this.watched_at = watched_at;
        }
    }
    
    public static class EpisodeData {
        private final TraktIds ids;
        
        private String watched_at;
        
        public EpisodeData(TraktEpisode episode) {
            this.ids = episode.getIds();
        }
        
        public EpisodeData(TraktEpisode episode, String watched_at) {
            this(episode);
            this.watched_at = watched_at;
        }
    }
}
