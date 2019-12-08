package com.wexalian.jtrakt.http.query;

public enum Extended
{
    FULL("full"), //complete info for an item
    NO_SEASONS("noseasons"), //only works with sync/getWatched
    EPISODES("episodes"),
    FULL_EPISODES("full,episodes"),
    GUEST_STARS("guest_stars");
    
    private final String value;
    
    Extended(String value)
    {
        this.value = value;
    }
    
    @Override
    public String toString()
    {
        return value;
    }
}
