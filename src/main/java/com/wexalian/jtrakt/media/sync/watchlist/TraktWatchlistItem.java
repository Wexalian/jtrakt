package com.wexalian.jtrakt.media.sync.watchlist;

import com.wexalian.jtrakt.media.TraktEpisode;
import com.wexalian.jtrakt.media.TraktMovie;
import com.wexalian.jtrakt.media.TraktSeason;
import com.wexalian.jtrakt.media.TraktShow;
import com.wexalian.jtrakt.media.info.MediaType;

import java.time.OffsetDateTime;

public class TraktWatchlistItem
{
    private int rank;
    private OffsetDateTime listed_at;
    
    private MediaType type;
    private TraktMovie movie;
    private TraktShow show;
    private TraktSeason season;
    private TraktEpisode episode;
    
    public int getRank()
    {
        return rank;
    }
    
    public OffsetDateTime getListedAt()
    {
        return listed_at;
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
