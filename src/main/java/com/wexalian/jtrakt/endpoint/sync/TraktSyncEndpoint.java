package com.wexalian.jtrakt.endpoint.sync;

import com.wexalian.jtrakt.http.TraktHTTP;

public class TraktSyncEndpoint
{
    /*
    TODO last activity
    TODO playback
    TODO remove playback
    TODO get collection
    TODO add to collection
    TODO remove from collection
    TODO get watched
    TODO get history
    TODO add to history
    TODO remove from history
    TODO get ratings
    TODO add ratings
    TODO remove ratings
    TODO get watchlist
    TODO add to watchlist
    TODO remove from watchlist
     */
    private final TraktHTTP http;
    
    public TraktSyncEndpoint(TraktHTTP http) {this.http = http;}
}
