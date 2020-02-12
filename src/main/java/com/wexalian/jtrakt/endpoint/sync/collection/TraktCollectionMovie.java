package com.wexalian.jtrakt.endpoint.sync.collection;

import com.wexalian.jtrakt.endpoint.TraktItemMetadata;
import com.wexalian.jtrakt.endpoint.TraktMovie;

import java.time.OffsetDateTime;

public class TraktCollectionMovie
{
    private OffsetDateTime collected_at;
    private OffsetDateTime updated_at;
    private TraktMovie movie;
    private TraktItemMetadata metadata;
    
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
