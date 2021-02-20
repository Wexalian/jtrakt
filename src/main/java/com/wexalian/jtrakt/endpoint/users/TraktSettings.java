package com.wexalian.jtrakt.endpoint.users;

import java.time.ZoneId;

public class TraktSettings {
    private TraktUser user;
    private Account account;
    private Connections connections;
    private SharingTexts sharing_texts;
    
    public TraktUser getUser() {
        return user;
    }
    
    public Account getAccount() {
        return account;
    }
    
    public Connections getConnections() {
        return connections;
    }
    
    public SharingTexts getSharingTexts() {
        return sharing_texts;
    }
    
    public static class Account {
        private ZoneId timezone;
        private String date_format;
        private boolean time_24hr;
        private String cover_image;
        
        public ZoneId getTimezone() {
            return timezone;
        }
        
        public String getDateFormat() {
            return date_format;
        }
        
        public boolean isTime24hr() {
            return time_24hr;
        }
        
        public String getCoverImage() {
            return cover_image;
        }
    }
    
    public static class Connections {
        private boolean facebook;
        private boolean twitter;
        private boolean google;
        private boolean tumblr;
        private boolean medium;
        private boolean slack;
        
        public boolean isFacebook() {
            return facebook;
        }
        
        public boolean isTwitter() {
            return twitter;
        }
        
        public boolean isGoogle() {
            return google;
        }
        
        public boolean isTumblr() {
            return tumblr;
        }
        
        public boolean isMedium() {
            return medium;
        }
        
        public boolean isSlack() {
            return slack;
        }
    }
    
    public static class SharingTexts {
        private String watching;
        private String watched;
        private String rated;
        
        public String getWatching() {
            return watching;
        }
        
        public String getWatched() {
            return watched;
        }
        
        public String getRated() {
            return rated;
        }
    }
}
