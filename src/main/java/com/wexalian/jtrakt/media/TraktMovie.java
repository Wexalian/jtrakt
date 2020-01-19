package com.wexalian.jtrakt.media;

import com.wexalian.jtrakt.media.info.TraktIds;

public class TraktMovie
{
    private String title;
    private int year;
    private TraktIds ids;
    
    public TraktMovie() {}
    
    public TraktMovie(String title, int year, TraktIds ids)
    {
        this.title = title;
        this.year = year;
        this.ids = ids;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public TraktIds getIds()
    {
        return ids;
    }
}
