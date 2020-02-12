package com.wexalian.jtrakt.endpoint.calendars;

import com.wexalian.jtrakt.endpoint.TraktMovie;

import java.time.OffsetDateTime;

public class TraktCalendarMovie
{
    private OffsetDateTime released;
    private TraktMovie movie;
    
    public OffsetDateTime getReleased()
    {
        return released;
    }
    
    public TraktMovie getMovie()
    {
        return movie;
    }
}
