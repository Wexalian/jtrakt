package com.wexalian.jtrakt.endpoint.search;

import com.wexalian.jtrakt.endpoint.*;

public class TraktSearchItem
{
    private float score;
    
    private TraktItemType type;
    private TraktMovie movie;
    private TraktShow show;
    private TraktSeason season;
    private TraktEpisode episode;
    private TraktList list;
    
    public TraktItemType getType()
    {
        return type;
    }
    
    public float getScore()
    {
        return score;
    }
    
    public TraktMovie getMovie()
    {
        return movie;
    }
    
    public TraktShow getShow()
    {
        return show;
    }
    
    public TraktSeason getSeason()
    {
        return season;
    }
    
    public TraktEpisode getEpisode()
    {
        return episode;
    }
    
    public TraktList getList()
    {
        return list;
    }
}
