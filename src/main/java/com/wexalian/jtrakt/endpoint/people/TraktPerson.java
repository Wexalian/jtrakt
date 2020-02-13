package com.wexalian.jtrakt.endpoint.people;

import com.wexalian.jtrakt.endpoint.TraktIds;

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
