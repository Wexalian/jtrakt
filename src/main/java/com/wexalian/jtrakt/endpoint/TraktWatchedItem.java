package com.wexalian.jtrakt.endpoint;

import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

import java.time.OffsetDateTime;
import java.util.List;

public class TraktWatchedItem {
    private int plays;
    private OffsetDateTime last_watched_at;
    private OffsetDateTime last_updated_at;
    private OffsetDateTime reset_at;
    private TraktMovie movie;
    private TraktShow show;
    private List<Season> seasons;
    
    public int getPlays() {
        return plays;
    }
    
    public OffsetDateTime getLastWatchedAt() {
        return last_watched_at;
    }
    
    public OffsetDateTime getLastUpdatedAt() {
        return last_updated_at;
    }
    
    public OffsetDateTime getResetAt() {
        return reset_at;
    }
    
    public TraktMovie getMovie() {
        return movie;
    }
    
    public TraktShow getShow() {
        return show;
    }
    
    public List<Season> getSeasons() {
        return seasons;
    }
    
    public static class Season {
        private int number;
        private List<Episode> episodes;
        
        public int getNumber() {
            return number;
        }
        
        public List<Episode> getEpisodes() {
            return episodes;
        }
    }
    
    public static class Episode {
        private int number;
        private int plays;
        private OffsetDateTime last_watched_at;
        
        public int getNumber() {
            return number;
        }
        
        public int getPlays() {
            return plays;
        }
        
        public OffsetDateTime getLastWatchedAt() {
            return last_watched_at;
        }
    }
}

