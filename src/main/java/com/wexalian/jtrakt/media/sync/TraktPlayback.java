package com.wexalian.jtrakt.media.sync;

import com.wexalian.jtrakt.media.TraktEpisode;
import com.wexalian.jtrakt.media.TraktMovie;
import com.wexalian.jtrakt.media.TraktShow;
import com.wexalian.jtrakt.media.info.MediaType;

import java.time.OffsetDateTime;

public class TraktPlayback
{
    private float progress;
    private OffsetDateTime paused_at;
    private int id;
    private MediaType type;
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
    
    public TraktEpisode getEpisode()
    {
        return episode;
    }
}
