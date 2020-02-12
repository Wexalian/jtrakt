package com.wexalian.jtrakt.endpoint.sync.rating;

import com.wexalian.jtrakt.endpoint.*;

import java.time.OffsetDateTime;

public class TraktRatedItem
{
    private OffsetDateTime rated_at;
    private int rating;
    
    private TraktItemType type;
    private TraktMovie movie;
    private TraktShow show;
    private TraktSeason season;
    private TraktEpisode episode;
    
    public OffsetDateTime getRatedAt()
    {
        return rated_at;
    }
    
    public int getRating()
    {
        return rating;
    }
    
    public TraktItemType getType()
    {
        return type;
    }
    
    public TraktMovie getMovie()
    {
        return movie;
    }
    
    public TraktShow getShow()
    {
        return show;
    }
    
    public TraktSeason getSeason()
    {
        return season;
    }
    
    public TraktEpisode getEpisode()
    {
        return episode;
    }
}
