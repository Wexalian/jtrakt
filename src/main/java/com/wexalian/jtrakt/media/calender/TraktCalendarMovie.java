package com.wexalian.jtrakt.media.calender;

import com.wexalian.jtrakt.media.TraktMovie;

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
