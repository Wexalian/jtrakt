package com.wexalian.jtrakt.endpoint.shows;

import com.wexalian.jtrakt.endpoint.TraktShow;

public class TraktListedShow
{
    private int list_count;
    private TraktShow show;
    
    public int getListCount()
    {
        return list_count;
    }
    
    public TraktShow getShow()
    {
        return show;
    }
}
