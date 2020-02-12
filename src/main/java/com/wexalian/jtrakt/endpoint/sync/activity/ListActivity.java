package com.wexalian.jtrakt.endpoint.sync.activity;

import java.time.OffsetDateTime;

public class ListActivity
{
    private OffsetDateTime liked_at;
    private OffsetDateTime updated_at;
    private OffsetDateTime commented_at;
    
    public OffsetDateTime getLikedAt()
    {
        return liked_at;
    }
    
    public OffsetDateTime getUpdatedAt()
    {
        return updated_at;
    }
    
    public OffsetDateTime getCommentedAt()
    {
        return commented_at;
    }
}
