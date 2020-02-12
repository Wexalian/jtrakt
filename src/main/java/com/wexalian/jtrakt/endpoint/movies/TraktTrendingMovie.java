package com.wexalian.jtrakt.endpoint.movies;

import com.wexalian.jtrakt.endpoint.TraktMovie;

public class TraktTrendingMovie
{
    private int watchers;
    private TraktMovie movie;
    
    public int getWatchers()
    {
        return watchers;
    }
    
    public TraktMovie getMovie()
    {
        return movie;
    }
}
