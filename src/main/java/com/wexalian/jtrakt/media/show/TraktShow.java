package com.wexalian.jtrakt.media.show;

import com.wexalian.jtrakt.http.query.Genre;
import com.wexalian.jtrakt.http.query.Language;
import com.wexalian.jtrakt.media.info.Airs;
import com.wexalian.jtrakt.media.info.Ids;
import com.wexalian.jtrakt.media.info.Status;

import java.time.OffsetDateTime;
import java.util.List;

public class TraktShow
{
    //standard
    private String title;
    private int year;
    private Ids ids;
    
    //extended
    private String overview;
    private OffsetDateTime first_aired;
    private Airs airs;
    private int runtime;
    private String certification;
    private String network;
    private String country;
    private OffsetDateTime updated_at;
    private String trailer;
    private String homepage;
    private Status status;
    private double rating;
    private int votes;
    private int comment_count;
    private Language language;
    private List<Language> available_translations;
    private List<Genre> genres;
    private int aired_episodes;
    
    public TraktShow() {}
    
    public TraktShow(String title, int year, Ids ids)
    {
        this.title = title;
        this.year = year;
        this.ids = ids;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public Ids getIds()
    {
        return ids;
    }
    
    public String getOverview()
    {
        return overview;
    }
    
    public OffsetDateTime getFirstAired()
    {
        return first_aired;
    }
    
    public Airs getAirs()
    {
        return airs;
    }
    
    public int getRuntime()
    {
        return runtime;
    }
    
    public String getCertification()
    {
        return certification;
    }
    
    public String getNetwork()
    {
        return network;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public OffsetDateTime getUpdatedAt()
    {
        return updated_at;
    }
    
    public String getTrailer()
    {
        return trailer;
    }
    
    public String getHomepage()
    {
        return homepage;
    }
    
    public Status getStatus()
    {
        return status;
    }
    
    public double getRating()
    {
        return rating;
    }
    
    public int getVotes()
    {
        return votes;
    }
    
    public int getCommentCount()
    {
        return comment_count;
    }
    
    public Language getLanguage()
    {
        return language;
    }
    
    public List<Language> getAvailableTranslations()
    {
        return available_translations;
    }
    
    public List<Genre> getGenres()
    {
        return genres;
    }
    
    public int getAiredEpisodes()
    {
        return aired_episodes;
    }
    
    public static class Listed
    {
        private int list_count;
        private TraktShow show;
        
        public int getListCount()
        {
            return list_count;
        }
        
        public TraktShow getShow()
        {
            return show;
        }
    }
    
    public static class Trending
    {
        private int watchers;
        private TraktShow show;
        
        public int getWatchers()
        {
            return watchers;
        }
        
        public TraktShow getShow()
        {
            return show;
        }
    }
    
    public static class Updated
    {
        private OffsetDateTime updated_at;
        private TraktShow show;
        
        public OffsetDateTime getUpdatedAt()
        {
            return updated_at;
        }
        
        public TraktShow getShow()
        {
            return show;
        }
    }
    
    public static class Watched
    {
        private int watcher_count;
        private int play_count;
        private int collected_count;
        private int collector_count;
        private TraktShow show;
        
        public int getWatcherCount()
        {
            return watcher_count;
        }
        
        public int getPlayCount()
        {
            return play_count;
        }
        
        public int getCollectedCount()
        {
            return collected_count;
        }
        
        public int getCollectorCount()
        {
            return collector_count;
        }
        
        public TraktShow getShow()
        {
            return show;
        }
    }
}
