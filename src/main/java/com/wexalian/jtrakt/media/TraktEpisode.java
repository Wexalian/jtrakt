package com.wexalian.jtrakt.media;

import com.wexalian.jtrakt.media.info.Ids;

public class TraktEpisode
{
    private int season;
    private int number;
    private String title;
    private Ids ids;
    
    public TraktEpisode() {}
    
    public TraktEpisode(int season, int number, String title, Ids ids)
    {
        this.season = season;
        this.number = number;
        this.title = title;
        this.ids = ids;
    }
    
    public int getSeason()
    {
        return season;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public Ids getIds()
    {
        return ids;
    }
}
