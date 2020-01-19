package com.wexalian.jtrakt.media.sync.rating;

import com.wexalian.jtrakt.media.TraktEpisode;
import com.wexalian.jtrakt.media.TraktMovie;
import com.wexalian.jtrakt.media.TraktSeason;
import com.wexalian.jtrakt.media.TraktShow;
import com.wexalian.jtrakt.media.info.MediaType;

import java.time.OffsetDateTime;

public class TraktRatedItem
{
    private OffsetDateTime rated_at;
    private int rating;
    
    private MediaType type;
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
    
    public MediaType getType()
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
