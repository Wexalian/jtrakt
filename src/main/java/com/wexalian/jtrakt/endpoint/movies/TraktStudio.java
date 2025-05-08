package com.wexalian.jtrakt.endpoint.movies;

import com.wexalian.jtrakt.endpoint.TraktIds;

public class TraktStudio {
    private String name;
    private String country;
    private TraktIds ids;
    
    public String getName() {
        return name;
    }
    
    public String getCountry() {
        return country;
    }
    
    public TraktIds getIds() {
        return ids;
    }
}
