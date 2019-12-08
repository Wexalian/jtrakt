package com.wexalian.jtrakt.media;

import com.wexalian.jtrakt.media.info.Ids;

public class TraktSeason
{
    private int number;
    private Ids ids;
    
    public TraktSeason() {}
    
    public TraktSeason(int number, Ids ids)
    {
        this.number = number;
        this.ids = ids;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public Ids getIds()
    {
        return ids;
    }
}
