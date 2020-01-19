package com.wexalian.jtrakt.media.sync.watched;

import com.wexalian.jtrakt.media.TraktShow;

import java.time.OffsetDateTime;
import java.util.List;

public class TraktWatchedShow
{
    private int plays;
    private OffsetDateTime last_watched_at;
    private OffsetDateTime last_updated_at;
    private OffsetDateTime reset_at;
    private TraktShow show;
    
    public int getPlays()
    {
        return plays;
    }
    
    public OffsetDateTime getLastWatchedAt()
    {
        return last_watched_at;
    }
    
    public OffsetDateTime getLastUpdatedAt()
    {
        return last_updated_at;
    }
    
    public OffsetDateTime getResetAt()
    {
        return reset_at;
    }
    
    public TraktShow getShow()
    {
        return show;
    }
    
    private static class Season
    {
        private int number;
        private List<Episode> episodes;
        
        public int getNumber()
        {
            return number;
        }
        
        public List<Episode> getEpisodes()
        {
            return episodes;
        }
    }
    
    private static class Episode
    {
        private int number;
        private int plays;
        private OffsetDateTime last_watched_at;
        
        public int getNumber()
        {
            return number;
        }
        
        public int getPlays()
        {
            return plays;
        }
        
        public OffsetDateTime getLastWatchedAt()
        {
            return last_watched_at;
        }
    }
}

