package com.wexalian.jtrakt.endpoint.users.hidden;

import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeason;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

import java.time.OffsetDateTime;

public class TraktHiddenItem
{
    private OffsetDateTime hidden_at;
    
    private TraktItemType type;
    private TraktMovie movie;
    private TraktShow show;
    private TraktSeason season;
    
    public OffsetDateTime getHiddenAt()
    {
        return hidden_at;
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
    
    public enum Section
    {
        CALENDAR("calendar"),
        PROGRESS_WATCHED("progress_watched"),
        PROGRESS_WATCHED_RESET("progress_watched_reset"),
        PROGRESS_COLLECTED("progress_collected"),
        RECOMMENDATIONS("recommendations");
        
        private String name;
        
        Section(String name)
        {
            this.name = name;
        }
        
        @Override
        public String toString()
        {
            return getName();
        }
        
        public String getName()
        {
            return name;
        }
    }
}
