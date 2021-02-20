package com.wexalian.jtrakt.endpoint.checkin;

import com.wexalian.jtrakt.endpoint.TraktSharing;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

import java.time.OffsetDateTime;

public class TraktCheckinItem {
    private long id;
    private OffsetDateTime watched_at;
    private TraktSharing sharing;
    
    private TraktMovie movie;
    private TraktShow show;
    private TraktEpisode episode;
    
    public long getId() {
        return id;
    }
    
    public OffsetDateTime getWatchedAt() {
        return watched_at;
    }
    
    public TraktSharing getSharing() {
        return sharing;
    }
    
    public TraktMovie getMovie() {
        return movie;
    }
    
    public TraktShow getShow() {
        return show;
    }
    
    public TraktEpisode getEpisode() {
        return episode;
    }
}
