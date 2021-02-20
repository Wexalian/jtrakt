package com.wexalian.jtrakt.endpoint.sync.watched;

import com.wexalian.jtrakt.endpoint.sync.TraktSyncItems;

import java.time.OffsetDateTime;

public class TraktWatchedUpdate {
    private TraktSyncItems.Movie movie;
    private TraktSyncItems.Show show;
    private TraktSyncItems.Season season;
    private TraktSyncItems.Episode episode;
    private OffsetDateTime watched_at;
    
    public TraktWatchedUpdate(TraktSyncItems.Movie movie) {
        this.movie = movie;
    }
    
    public TraktWatchedUpdate(TraktSyncItems.Show show) {
        this.show = show;
    }
    
    public TraktWatchedUpdate(TraktSyncItems.Season season) {
        this.season = season;
    }
    
    public TraktWatchedUpdate(TraktSyncItems.Episode episode) {
        this.episode = episode;
    }
    
    public TraktWatchedUpdate(TraktSyncItems.Movie movie, OffsetDateTime watched_at) {
        this.movie = movie;
        this.watched_at = watched_at;
    }
    
    public TraktWatchedUpdate(TraktSyncItems.Show show, OffsetDateTime watched_at) {
        this.show = show;
        this.watched_at = watched_at;
    }
    
    public TraktWatchedUpdate(TraktSyncItems.Season season, OffsetDateTime watched_at) {
        this.season = season;
        this.watched_at = watched_at;
    }
    
    public TraktWatchedUpdate(TraktSyncItems.Episode episode, OffsetDateTime watched_at) {
        this.episode = episode;
        this.watched_at = watched_at;
    }
}
