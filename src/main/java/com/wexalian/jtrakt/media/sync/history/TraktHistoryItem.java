package com.wexalian.jtrakt.media.sync.history;

import com.wexalian.jtrakt.media.TraktEpisode;
import com.wexalian.jtrakt.media.TraktMovie;
import com.wexalian.jtrakt.media.TraktSeason;
import com.wexalian.jtrakt.media.TraktShow;
import com.wexalian.jtrakt.media.info.MediaType;

import java.time.OffsetDateTime;

public class TraktHistoryItem
{
    private long id;
    private OffsetDateTime watched_at;
    private String action;
    
    private MediaType type;
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
    
    public MediaType getType()
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
