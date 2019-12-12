package com.wexalian.jtrakt.media.calender;

import com.wexalian.jtrakt.media.TraktEpisode;
import com.wexalian.jtrakt.media.show.TraktShow;

import java.time.OffsetDateTime;

public class TraktCalenderEpisode
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
