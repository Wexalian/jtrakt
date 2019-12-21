package com.wexalian.jtrakt.media;

import com.wexalian.jtrakt.media.info.Ids;

public class TraktPerson
{
    private String name;
    private Ids ids;
    
    public TraktPerson() {}
    
    public TraktPerson(String name, Ids ids)
    {
        this.name = name;
        this.ids = ids;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Ids getIds()
    {
        return ids;
    }
    
}
