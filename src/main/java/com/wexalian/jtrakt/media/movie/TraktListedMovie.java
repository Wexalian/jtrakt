package com.wexalian.jtrakt.media.movie;

import com.wexalian.jtrakt.media.TraktMovie;

public class TraktListedMovie
{
    private int list_count;
    private TraktMovie movie;
    
    public int getListCount()
    {
        return list_count;
    }
    
    public TraktMovie getMovie()
    {
        return movie;
    }
}
