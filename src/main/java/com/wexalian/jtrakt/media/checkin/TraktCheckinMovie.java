package com.wexalian.jtrakt.media.checkin;

import com.wexalian.jtrakt.media.TraktMovie;

import java.time.OffsetDateTime;

public class TraktCheckinMovie
{
    private long id;
    private OffsetDateTime watched_at;
    private TraktSharing sharing;
    private TraktMovie movie;
    
    public long getId()
    {
        return id;
    }
    
    public OffsetDateTime getWatchedAt()
    {
        return watched_at;
    }
    
    public TraktSharing getSharing()
    {
        return sharing;
    }
    
    public TraktMovie getMovie()
    {
        return movie;
    }
}
