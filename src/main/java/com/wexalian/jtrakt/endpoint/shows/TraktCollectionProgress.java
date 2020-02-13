package com.wexalian.jtrakt.endpoint.shows;

import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeason;

import java.time.OffsetDateTime;
import java.util.List;

public class TraktCollectionProgress
{
    public static class Show
    {
        private int aired;
        private int completed;
        private OffsetDateTime last_collected_at;
        private List<Season> seasons;
        private List<TraktSeason> hidden_seasons;
        private TraktEpisode next_episode;
        private TraktEpisode last_episode;
        
        public int getAired()
        {
            return aired;
        }
        
        public int getCompleted()
        {
            return completed;
        }
        
        public OffsetDateTime getLastCollectedAt()
        {
            return last_collected_at;
        }
        
        public List<Season> getSeasons()
        {
            return seasons;
        }
        
        public List<TraktSeason> getHiddenSeasons()
        {
            return hidden_seasons;
        }
        
        public TraktEpisode getNextEpisode()
        {
            return next_episode;
        }
        
        public TraktEpisode getLastEpisode()
        {
            return last_episode;
        }
    }
    
    public static class Season
    {
        private int number;
        private int aired;
        private int completed;
        private List<Episode> episodes;
        
        public int getNumber()
        {
            return number;
        }
        
        public int getAired()
        {
            return aired;
        }
        
        public int getCompleted()
        {
            return completed;
        }
        
        public List<Episode> getEpisodes()
        {
            return episodes;
        }
    }
    
    public static class Episode
    {
        private int number;
        private boolean completed;
        private OffsetDateTime collected_at;
        
        public int getNumber()
        {
            return number;
        }
        
        public boolean isCompleted()
        {
            return completed;
        }
        
        public OffsetDateTime getCollectedAt()
        {
            return collected_at;
        }
    }
}
