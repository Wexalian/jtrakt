package com.wexalian.jtrakt.endpoint.users;

import com.wexalian.jtrakt.endpoint.TraktRatings;

public class TraktUserStats {
    private Movies movies;
    private Shows shows;
    private Seasons seasons;
    private Episodes episodes;
    private Network network;
    private TraktRatings ratings;
    
    public Movies getMovies() {
        return movies;
    }
    
    public Shows getShows() {
        return shows;
    }
    
    public Seasons getSeasons() {
        return seasons;
    }
    
    public Episodes getEpisodes() {
        return episodes;
    }
    
    public Network getNetwork() {
        return network;
    }
    
    public TraktRatings getRatings() {
        return ratings;
    }
    
    public static class Movies {
        private int plays;
        private int watched;
        private int minutes;
        private int collected;
        private int ratings;
        private int comments;
        
        public int getPlays() {
            return plays;
        }
        
        public int getWatched() {
            return watched;
        }
        
        public int getMinutes() {
            return minutes;
        }
        
        public int getCollected() {
            return collected;
        }
        
        public int getRatings() {
            return ratings;
        }
        
        public int getComments() {
            return comments;
        }
    }
    
    public static class Shows {
        private int watched;
        private int collected;
        private int ratings;
        private int comments;
        
        public int getWatched() {
            return watched;
        }
        
        public int getCollected() {
            return collected;
        }
        
        public int getRatings() {
            return ratings;
        }
        
        public int getComments() {
            return comments;
        }
    }
    
    public static class Seasons {
        private int ratings;
        private int comments;
        
        public int getRatings() {
            return ratings;
        }
        
        public int getComments() {
            return comments;
        }
    }
    
    public static class Episodes {
        private int plays;
        private int watched;
        private int minutes;
        private int collected;
        private int ratings;
        private int comments;
        
        public int getPlays() {
            return plays;
        }
        
        public int getWatched() {
            return watched;
        }
        
        public int getMinutes() {
            return minutes;
        }
        
        public int getCollected() {
            return collected;
        }
        
        public int getRatings() {
            return ratings;
        }
        
        public int getComments() {
            return comments;
        }
    }
    
    public static class Network {
        private int friends;
        private int followers;
        private int following;
        
        public int getFriends() {
            return friends;
        }
        
        public int getFollowers() {
            return followers;
        }
        
        public int getFollowing() {
            return following;
        }
    }
}
