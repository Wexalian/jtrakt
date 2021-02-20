package com.wexalian.jtrakt.endpoint.sync.watchlist;

import com.wexalian.jtrakt.endpoint.sync.TraktSyncItems;

public class TraktWatchlistUpdate {
    private TraktSyncItems.Movie movie;
    private TraktSyncItems.Show show;
    private TraktSyncItems.Season season;
    private TraktSyncItems.Episode episode;
    
    public TraktWatchlistUpdate(TraktSyncItems.Movie movie) {
        this.movie = movie;
    }
    
    public TraktWatchlistUpdate(TraktSyncItems.Show show) {
        this.show = show;
    }
    
    public TraktWatchlistUpdate(TraktSyncItems.Season season) {
        this.season = season;
    }
    
    public TraktWatchlistUpdate(TraktSyncItems.Episode episode) {
        this.episode = episode;
    }
}
