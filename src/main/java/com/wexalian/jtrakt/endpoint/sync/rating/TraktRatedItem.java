package com.wexalian.jtrakt.endpoint.sync.rating;

import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeason;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

import java.time.OffsetDateTime;

public class TraktRatedItem {
    private OffsetDateTime rated_at;
    private float rating;
    
    private TraktItemType type;
    private TraktMovie movie;
    private TraktShow show;
    private TraktSeason season;
    private TraktEpisode episode;
    
    public OffsetDateTime getRatedAt() {
        return rated_at;
    }
    
    public float getRating() {
        return rating;
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
