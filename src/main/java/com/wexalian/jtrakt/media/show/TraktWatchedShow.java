package com.wexalian.jtrakt.media.show;

import com.wexalian.jtrakt.media.TraktShow;

public class TraktWatchedShow
{
    private int watcher_count;
    private int play_count;
    private int collected_count;
    private int collector_count;
    private TraktShow show;
    
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
    
    public int getCollectorCount()
    {
        return collector_count;
    }
    
    public TraktShow getShow()
    {
        return show;
    }
}