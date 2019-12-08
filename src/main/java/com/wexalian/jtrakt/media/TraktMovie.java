package com.wexalian.jtrakt.media;

import com.wexalian.jtrakt.media.info.Ids;

public class TraktMovie
{
    private String title;
    private int year;
    private Ids ids;
    
    public TraktMovie() {}
    
    public TraktMovie(String title, int year, Ids ids)
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
    
    public Ids getIds()
    {
        return ids;
    }
}
