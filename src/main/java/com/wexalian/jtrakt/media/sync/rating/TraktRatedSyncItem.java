package com.wexalian.jtrakt.media.sync.rating;

import com.wexalian.jtrakt.media.info.TraktIds;

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
