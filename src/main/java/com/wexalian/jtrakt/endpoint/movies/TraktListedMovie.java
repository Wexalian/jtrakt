package com.wexalian.jtrakt.endpoint.movies;

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
