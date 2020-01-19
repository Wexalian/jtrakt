package com.wexalian.jtrakt.media;

import com.wexalian.jtrakt.media.info.TraktIds;

public class TraktPerson
{
    private String name;
    private TraktIds ids;
    
    public TraktPerson() {}
    
    public TraktPerson(String name, TraktIds ids)
    {
        this.name = name;
        this.ids = ids;
    }
    
    public String getName()
    {
        return name;
    }
    
    public TraktIds getIds()
    {
        return ids;
    }
    
}
