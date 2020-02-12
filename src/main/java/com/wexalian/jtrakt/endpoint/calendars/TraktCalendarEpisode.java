package com.wexalian.jtrakt.endpoint.calendars;

import com.wexalian.jtrakt.endpoint.TraktEpisode;
import com.wexalian.jtrakt.endpoint.TraktShow;

import java.time.OffsetDateTime;

public class TraktCalendarEpisode
{
    private OffsetDateTime first_aired;
    private TraktEpisode episode;
    private TraktShow show;
    
    public OffsetDateTime getFirstAired()
    {
        return first_aired;
    }
    
    public TraktEpisode getEpisode()
    {
        return episode;
    }
    
    public TraktShow getShow()
    {
        return show;
    }
}
