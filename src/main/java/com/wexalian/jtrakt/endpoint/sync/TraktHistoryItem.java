package com.wexalian.jtrakt.endpoint.sync;

import com.wexalian.jtrakt.endpoint.*;

import java.time.OffsetDateTime;

public class TraktHistoryItem
{
    private long id;
    private OffsetDateTime watched_at;
    private String action;
    
    private TraktItemType type;
    private TraktMovie movie;
    private TraktShow show;
    private TraktSeason season;
    private TraktEpisode episode;
    
    public long getId()
    {
        return id;
    }
    
    public OffsetDateTime getWatchedAt()
    {
        return watched_at;
    }
    
    public String getAction()
    {
        return action;
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
