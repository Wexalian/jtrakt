package com.wexalian.jtrakt.endpoint.sync;

import com.wexalian.jtrakt.endpoint.TraktEpisode;
import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.endpoint.TraktMovie;
import com.wexalian.jtrakt.endpoint.TraktShow;

import java.time.OffsetDateTime;

public class TraktPlayback
{
    private float progress;
    private OffsetDateTime paused_at;
    private int id;
    private TraktItemType type;
    private TraktMovie movie;
    private TraktShow show;
    private TraktEpisode episode;
    
    public float getProgress()
    {
        return progress;
    }
    
    public OffsetDateTime getPausedAt()
    {
        return paused_at;
    }
    
    public int getId()
    {
        return id;
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
