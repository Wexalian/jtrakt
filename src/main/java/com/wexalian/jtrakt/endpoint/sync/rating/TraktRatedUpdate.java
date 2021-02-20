package com.wexalian.jtrakt.endpoint.sync.rating;

import com.wexalian.jtrakt.endpoint.sync.TraktSyncItems;

import java.time.OffsetDateTime;

public class TraktRatedUpdate {
    private TraktSyncItems.Movie movie;
    private TraktSyncItems.Show show;
    private TraktSyncItems.Season season;
    private TraktSyncItems.Episode episode;
    private float rating;
    
    private OffsetDateTime rated_at;
    
    public TraktRatedUpdate(TraktSyncItems.Movie movie) {
        this.movie = movie;
    }
    
    public TraktRatedUpdate(TraktSyncItems.Show show) {
        this.show = show;
    }
    
    public TraktRatedUpdate(TraktSyncItems.Season season) {
        this.season = season;
    }
    
    public TraktRatedUpdate(TraktSyncItems.Episode episode) {
        this.episode = episode;
    }
    
    public TraktRatedUpdate(TraktSyncItems.Movie movie, float rating, OffsetDateTime rated_at) {
        this.movie = movie;
        this.rating = rating;
        this.rated_at = rated_at;
    }
    
    public TraktRatedUpdate(TraktSyncItems.Show show, float rating, OffsetDateTime rated_at) {
        this.show = show;
        this.rating = rating;
        this.rated_at = rated_at;
    }
    
    public TraktRatedUpdate(TraktSyncItems.Season season, float rating, OffsetDateTime rated_at) {
        this.season = season;
        this.rating = rating;
        this.rated_at = rated_at;
    }
    
    public TraktRatedUpdate(TraktSyncItems.Episode episode, float rating, OffsetDateTime rated_at) {
        this.episode = episode;
        this.rating = rating;
        this.rated_at = rated_at;
    }
}
