package com.wexalian.jtrakt.endpoint.seasons;

import com.wexalian.jtrakt.endpoint.TraktIds;

public class TraktSeason
{
    private int number;
    private TraktIds ids;
    
    public TraktSeason() {}
    
    public TraktSeason(int number, TraktIds ids)
    {
        this.number = number;
        this.ids = ids;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public TraktIds getIds()
    {
        return ids;
    }
}