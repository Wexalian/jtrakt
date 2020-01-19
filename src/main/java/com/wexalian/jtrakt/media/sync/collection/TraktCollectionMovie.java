package com.wexalian.jtrakt.media.sync.collection;

import com.wexalian.jtrakt.media.TraktMovie;

import java.time.OffsetDateTime;

public class TraktCollectionMovie
{
    private OffsetDateTime collected_at;
    private OffsetDateTime updated_at;
    private TraktMovie movie;
    
    public OffsetDateTime getCollectedAt()
    {
        return collected_at;
    }
    
    public OffsetDateTime getUpdatedAt()
    {
        return updated_at;
    }
    
    public TraktMovie getMovie()
    {
        return movie;
    }
}
