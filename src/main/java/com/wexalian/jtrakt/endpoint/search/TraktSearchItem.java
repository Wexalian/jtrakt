package com.wexalian.jtrakt.endpoint.search;

import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.endpoint.TraktList;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeason;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

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
