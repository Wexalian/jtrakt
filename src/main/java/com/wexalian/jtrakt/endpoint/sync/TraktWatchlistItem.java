package com.wexalian.jtrakt.endpoint.sync;

import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeason;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

import java.time.OffsetDateTime;

public class TraktWatchlistItem
{
    private int rank;
    private OffsetDateTime listed_at;
    
    private TraktItemType type;
    private TraktMovie movie;
    private TraktShow show;
    private TraktSeason season;
    private TraktEpisode episode;
    
    public int getRank()
    {
        return rank;
    }
    
    public OffsetDateTime getListedAt()
    {
        return listed_at;
    }
    
    public TraktItemType getType()
    {
        return type;
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
}
