package com.wexalian.jtrakt.endpoint.movies;

import com.wexalian.jtrakt.endpoint.TraktMovie;

public class TraktBoxOfficeMovie
{
    private int revenue;
    private TraktMovie movie;
    
    public int getRevenue()
    {
        return revenue;
    }
    
    public TraktMovie getMovie()
    {
        return movie;
    }
}
