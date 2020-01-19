package com.wexalian.jtrakt.media.sync.collection;

import com.wexalian.jtrakt.media.TraktShow;

import java.time.OffsetDateTime;

public class TraktCollectionShow
{
    private OffsetDateTime last_collected_at;
    private OffsetDateTime last_updated_at;
    private TraktShow show;
    
    public OffsetDateTime getLastCollectedAt()
    {
        return last_collected_at;
    }
    
    public OffsetDateTime getLastUpdatedAt()
    {
        return last_updated_at;
    }
    
    public TraktShow getShow()
    {
        return show;
    }
}
