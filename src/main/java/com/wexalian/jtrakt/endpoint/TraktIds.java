package com.wexalian.jtrakt.endpoint;

public class TraktIds
{
    private int trakt;
    private String slug;
    private int tvdb;
    private String imdb;
    private int tmdb;
    private int tvrage;
    
    public TraktIds() {}
    
    public TraktIds(int trakt, String slug, int tvdb, String imdb, int tmdb, int tvrage)
    {
        this.trakt = trakt;
        this.slug = slug;
        this.tvdb = tvdb;
        this.imdb = imdb;
        this.tmdb = tmdb;
        this.tvrage = tvrage;
    }
    
    public int getTraktId()
    {
        return trakt;
    }
    
    public String getSlug()
    {
        return slug;
    }
    
    public int getTvdbId()
    {
        return tvdb;
    }
    
    public String getImdbId()
    {
        return imdb;
    }
    
    public int getTmdbId()
    {
        return tmdb;
    }
    
    public int getTvRageId()
    {
        return tvrage;
    }
}
