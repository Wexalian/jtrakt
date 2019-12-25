package com.wexalian.jtrakt.media.search;

import com.wexalian.jtrakt.media.*;
import com.wexalian.jtrakt.media.info.MediaType;

public class TraktSearchMedia
{
    private MediaType type;
    private float score;
    private TraktMovie movie;
    private TraktShow show;
    private TraktSeason season;
    private TraktEpisode episode;
    private TraktList list;
    
    public MediaType getType()
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
