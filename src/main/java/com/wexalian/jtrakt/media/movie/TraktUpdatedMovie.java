package com.wexalian.jtrakt.media.movie;

import com.wexalian.jtrakt.media.TraktMovie;

import java.time.OffsetDateTime;

public class TraktUpdatedMovie
{
    private OffsetDateTime updated_at;
    private TraktMovie movie;
    
    public OffsetDateTime getUpdatedAt()
    {
        return updated_at;
    }
    
    public TraktMovie getMovie()
    {
        return movie;
    }
}
