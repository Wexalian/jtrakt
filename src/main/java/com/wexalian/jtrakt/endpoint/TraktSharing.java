package com.wexalian.jtrakt.endpoint;

public class TraktSharing {
    private final boolean twitter;
    private final boolean tumblr;
    private final boolean medium;
    
    public TraktSharing(boolean twitter, boolean tumblr, boolean medium) {
        this.twitter = twitter;
        this.tumblr = tumblr;
        this.medium = medium;
    }
    
    public boolean isTwitter() {
        return twitter;
    }
    
    public boolean isTumblr() {
        return tumblr;
    }
    
    public boolean isMedium() {
        return medium;
    }
    
    public static TraktSharing of(boolean twitter, boolean tumblr, boolean medium) {
        return new TraktSharing(twitter, tumblr, medium);
    }
}
