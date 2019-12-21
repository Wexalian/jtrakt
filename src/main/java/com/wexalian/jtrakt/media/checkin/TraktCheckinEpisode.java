package com.wexalian.jtrakt.media.checkin;

import com.wexalian.jtrakt.media.TraktEpisode;

import java.time.OffsetDateTime;

public class TraktCheckinEpisode
{
    private long id;
    private OffsetDateTime watched_at;
    private TraktSharing sharing;
    private TraktEpisode episode;
    
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
    
    public TraktEpisode getEpisode()
    {
        return episode;
    }
}
