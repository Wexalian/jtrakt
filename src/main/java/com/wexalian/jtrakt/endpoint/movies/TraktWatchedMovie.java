package com.wexalian.jtrakt.endpoint.movies;

import com.wexalian.jtrakt.endpoint.TraktMovie;

public class TraktWatchedMovie
{
    private int watcher_count;
    private int play_count;
    private int collected_count;
    private TraktMovie show;
    
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
    
    public TraktMovie getShow()
    {
        return show;
    }
}
