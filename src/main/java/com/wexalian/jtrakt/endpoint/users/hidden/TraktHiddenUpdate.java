package com.wexalian.jtrakt.endpoint.users.hidden;

import com.wexalian.jtrakt.endpoint.TraktMovie;
import com.wexalian.jtrakt.endpoint.TraktSeason;
import com.wexalian.jtrakt.endpoint.TraktShow;

public class TraktHiddenUpdate
{
    private TraktMovie movie;
    private TraktShow show;
    private TraktSeason season;
    
    public TraktHiddenUpdate(TraktMovie movie)
    {
        this.movie = movie;
    }
    
    public TraktHiddenUpdate(TraktShow show)
    {
        this.show = show;
    }
    
    public TraktHiddenUpdate(TraktSeason season)
    {
        this.season = season;
    }
}
