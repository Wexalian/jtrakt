package com.wexalian.jtrakt.endpoint.sync;

import com.wexalian.jtrakt.endpoint.TraktIds;

import java.util.List;

public class TraktSyncUpdate {
    private Data added;
    private Data updated;
    private Data existing;
    private Data deleted;
    private NotFound not_found;
    
    public Data getAdded() {
        return added;
    }
    
    public Data getUpdated() {
        return updated;
    }
    
    public Data getExisting() {
        return existing;
    }
    
    public Data getDeleted() {
        return deleted;
    }
    
    public NotFound getNotFound() {
        return not_found;
    }
    
    public static class Data {
        private int movies;
        private int shows;
        private int seasons;
        private int episodes;
        private int people;
        
        public int getMovies() {
            return movies;
        }
        
        public int getShows() {
            return shows;
        }
        
        public int getSeasons() {
            return seasons;
        }
        
        public int getEpisodes() {
            return episodes;
        }
        
        public int getPeople() {
            return people;
        }
    }
    
    public static class NotFound {
        private List<Item> movies;
        private List<Item> shows;
        private List<Item> seasons;
        private List<Item> episodes;
        private List<Item> people;
        private List<Long> ids;
        
        public List<Item> getMovies() {
            return movies;
        }
        
        public List<Item> getShows() {
            return shows;
        }
        
        public List<Item> getSeasons() {
            return seasons;
        }
        
        public List<Item> getEpisodes() {
            return episodes;
        }
        
        public List<Item> getPeople() {
            return people;
        }
        
        public List<Long> getIds() {
            return ids;
        }
        
        public static class Item {
            private TraktIds ids;
            private float rating; //only used for ratings
            
            public TraktIds getIds() {
                return ids;
            }
            
            public float getRating() {
                return rating;
            }
        }
    }
}
