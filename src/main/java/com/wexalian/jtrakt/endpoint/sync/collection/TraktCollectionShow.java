package com.wexalian.jtrakt.endpoint.sync.collection;

import com.wexalian.jtrakt.endpoint.shows.TraktShow;

import java.time.OffsetDateTime;
import java.util.List;

public class TraktCollectionShow {
    private OffsetDateTime last_collected_at;
    private OffsetDateTime last_updated_at;
    private TraktShow show;
    private List<Season> seasons;
    
    public OffsetDateTime getLastCollectedAt() {
        return last_collected_at;
    }
    
    public OffsetDateTime getLastUpdatedAt() {
        return last_updated_at;
    }
    
    public TraktShow getShow() {
        return show;
    }
    
    public List<Season> getSeasons() {
        return seasons;
    }
    
    public static class Season {
        private int number;
        private List<Episode> episodes;
        
        public int getNumber() {
            return number;
        }
        
        public List<Episode> getEpisodes() {
            return episodes;
        }
    }
    
    public static class Episode {
        private int number;
        private OffsetDateTime collected_at;
        private TraktItemMetadata metadata;
        
        public int getNumber() {
            return number;
        }
        
        public OffsetDateTime getCollectedAt() {
            return collected_at;
        }
        
        public TraktItemMetadata getMetadata() {
            return metadata;
        }
    }
}
