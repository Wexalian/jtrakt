package com.wexalian.jtrakt.endpoint;

public class TraktEpisode
{
    private int season;
    private int number;
    private String title;
    private TraktIds ids;
    
    public TraktEpisode() {}
    
    public TraktEpisode(int season, int number, String title, TraktIds ids)
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
    
    public TraktIds getIds()
    {
        return ids;
    }
}
