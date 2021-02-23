package com.wexalian.jtrakt.endpoint.sync.activity;

import java.time.OffsetDateTime;

public class TraktActivity {
    private OffsetDateTime all;
    private MovieActivity movies;
    private EpisodeActivity episodes;
    private ShowActivity shows;
    private SeasonActivity seasons;
    private CommentActivity comments;
    private ListActivity lists;
    
    public OffsetDateTime getAll() {
        return all;
    }
    
    public MovieActivity getMovies() {
        return movies;
    }
    
    public EpisodeActivity getEpisodes() {
        return episodes;
    }
    
    public ShowActivity getShows() {
        return shows;
    }
    
    public SeasonActivity getSeasons() {
        return seasons;
    }
    
    public CommentActivity getComments() {
        return comments;
    }
    
    public ListActivity getLists() {
        return lists;
    }
    
    public static class CommentActivity {
        private OffsetDateTime liked_at;
        
        public OffsetDateTime getLikedAt() {
            return liked_at;
        }
    }
    
    public static class EpisodeActivity {
        private OffsetDateTime watched_at;
        private OffsetDateTime collected_at;
        private OffsetDateTime rated_at;
        private OffsetDateTime watchlisted_at;
        private OffsetDateTime commented_at;
        private OffsetDateTime paused_at;
        
        public OffsetDateTime getWatchedAt() {
            return watched_at;
        }
        
        public OffsetDateTime getCollectedAt() {
            return collected_at;
        }
        
        public OffsetDateTime getRatedAt() {
            return rated_at;
        }
        
        public OffsetDateTime getWatchlistedAt() {
            return watchlisted_at;
        }
        
        public OffsetDateTime getCommentedAt() {
            return commented_at;
        }
        
        public OffsetDateTime getPausedAt() {
            return paused_at;
        }
    }
    
    public static class ListActivity {
        private OffsetDateTime liked_at;
        private OffsetDateTime updated_at;
        private OffsetDateTime commented_at;
        
        public OffsetDateTime getLikedAt() {
            return liked_at;
        }
        
        public OffsetDateTime getUpdatedAt() {
            return updated_at;
        }
        
        public OffsetDateTime getCommentedAt() {
            return commented_at;
        }
    }
    
    public static class MovieActivity {
        private OffsetDateTime watched_at;
        private OffsetDateTime collected_at;
        private OffsetDateTime rated_at;
        private OffsetDateTime watchlisted_at;
        private OffsetDateTime commented_at;
        private OffsetDateTime paused_at;
        private OffsetDateTime hidden_at;
        
        public OffsetDateTime getWatchedAt() {
            return watched_at;
        }
        
        public OffsetDateTime getCollectedAt() {
            return collected_at;
        }
        
        public OffsetDateTime getRatedAt() {
            return rated_at;
        }
        
        public OffsetDateTime getWatchlistedAt() {
            return watchlisted_at;
        }
        
        public OffsetDateTime getCommentedAt() {
            return commented_at;
        }
        
        public OffsetDateTime getPausedAt() {
            return paused_at;
        }
        
        public OffsetDateTime getHiddenAt() {
            return hidden_at;
        }
    }
    
    public static class SeasonActivity {
        private OffsetDateTime rated_at;
        private OffsetDateTime watchlisted_at;
        private OffsetDateTime commented_at;
        private OffsetDateTime hidden_at;
        
        public OffsetDateTime getRatedAt() {
            return rated_at;
        }
        
        public OffsetDateTime getWatchlistedAt() {
            return watchlisted_at;
        }
        
        public OffsetDateTime getCommentedAt() {
            return commented_at;
        }
        
        public OffsetDateTime getHiddenAt() {
            return hidden_at;
        }
    }
    
    public static class ShowActivity {
        private OffsetDateTime rated_at;
        private OffsetDateTime watchlisted_at;
        private OffsetDateTime commented_at;
        private OffsetDateTime hidden_at;
        
        public OffsetDateTime getRatedAt() {
            return rated_at;
        }
        
        public OffsetDateTime getWatchlistedAt() {
            return watchlisted_at;
        }
        
        public OffsetDateTime getCommentedAt() {
            return commented_at;
        }
        
        public OffsetDateTime getHiddenAt() {
            return hidden_at;
        }
    }
}
