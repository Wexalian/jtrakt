package com.wexalian.jtrakt.endpoint.sync.rating;

import com.wexalian.jtrakt.endpoint.TraktIds;

public class TraktRatedSyncItem {
    private float rating;
    private TraktIds ids;
    
    public float getRating() {
        return rating;
    }
    
    public TraktIds getIds() {
        return ids;
    }
}
