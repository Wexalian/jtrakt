package com.wexalian.jtrakt.endpoint.movies;

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
