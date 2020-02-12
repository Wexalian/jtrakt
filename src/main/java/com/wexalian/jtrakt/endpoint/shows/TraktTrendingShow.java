package com.wexalian.jtrakt.endpoint.shows;

import com.wexalian.jtrakt.endpoint.TraktShow;

public class TraktTrendingShow
{
    private int watchers;
    private TraktShow show;
    
    public int getWatchers()
    {
        return watchers;
    }
    
    public TraktShow getShow()
    {
        return show;
    }
}
