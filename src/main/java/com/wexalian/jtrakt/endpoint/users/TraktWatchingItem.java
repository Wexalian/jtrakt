package com.wexalian.jtrakt.endpoint.users;

import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

import java.time.OffsetDateTime;

public class TraktWatchingItem
{
    private OffsetDateTime expires_at;
    private OffsetDateTime started_at;
    private String action;
    private TraktItemType type;
    private TraktMovie movie;
    private TraktShow show;
    private TraktEpisode episode;
    
    public OffsetDateTime getExpiresAt()
    {
        return expires_at;
    }
    
    public OffsetDateTime getStartedAt()
    {
        return started_at;
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
    
    public TraktEpisode getEpisode()
    {
        return episode;
    }
}
