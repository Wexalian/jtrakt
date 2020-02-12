package com.wexalian.jtrakt.endpoint.sync.rating;

import com.wexalian.jtrakt.endpoint.TraktIds;

public class TraktRatedSyncItem
{
    private int rating;
    private TraktIds ids;
    
    public int getRating()
    {
        return rating;
    }
    
    public TraktIds getIds()
    {
        return ids;
    }
}
