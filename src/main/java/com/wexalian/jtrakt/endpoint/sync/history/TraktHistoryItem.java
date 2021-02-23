package com.wexalian.jtrakt.endpoint.sync.history;

import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeason;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

import java.time.OffsetDateTime;

public class TraktHistoryItem {
    private long id;
    private OffsetDateTime watched_at;
    private String action;
    
    private TraktItemType type;
    private TraktMovie movie;
    private TraktShow show;
    private TraktSeason season;
    private TraktEpisode episode;
    
    public long getId() {
        return id;
    }
    
    public OffsetDateTime getWatchedAt() {
        return watched_at;
    }
    
    public String getAction() {
        return action;
    }
    
    public TraktItemType getType() {
        return type;
    }
    
    public TraktMovie getMovie() {
        return movie;
    }
    
    public TraktShow getShow() {
        return show;
    }
    
    public TraktSeason getSeason() {
        return season;
    }
    
    public TraktEpisode getEpisode() {
        return episode;
    }
}
