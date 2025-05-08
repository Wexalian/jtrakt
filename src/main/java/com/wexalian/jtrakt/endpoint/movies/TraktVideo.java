package com.wexalian.jtrakt.endpoint.movies;

import com.wexalian.jtrakt.endpoint.languages.TraktLanguage;

import java.time.OffsetDateTime;

public class TraktVideo {
    private String title;
    private String url;
    private String site;
    private String type;
    private int size;
    private boolean official;
    private OffsetDateTime published_at;
    private String country;
    private TraktLanguage language;
    
    public String getTitle() {
        return title;
    }
    
    public String getUrl() {
        return url;
    }
    
    public String getSite() {
        return site;
    }
    
    public String getType() {
        return type;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isOfficial() {
        return official;
    }
    
    public OffsetDateTime getPublishedAt() {
        return published_at;
    }
    
    public String getCountry() {
        return country;
    }
    
    public TraktLanguage getLanguage() {
        return language;
    }
}
