package com.wexalian.jtrakt.media.movie;

import com.wexalian.jtrakt.media.TraktMovie;

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
