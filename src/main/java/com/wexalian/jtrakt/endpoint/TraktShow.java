package com.wexalian.jtrakt.endpoint;

import com.wexalian.jtrakt.endpoint.certifications.TraktCertification;
import com.wexalian.jtrakt.endpoint.languages.TraktLanguage;
import com.wexalian.jtrakt.endpoint.shows.TraktStatus;

import java.time.OffsetDateTime;
import java.util.List;

public class TraktShow
{
    //standard
    private String title;
    private int year;
    private TraktIds ids;
    
    //extended
    private String overview;
    private OffsetDateTime first_aired;
    private TraktAirsInfo airs;
    private int runtime;
    private TraktCertification certification;
    private String network;
    private String country;
    private OffsetDateTime updated_at;
    private String trailer;
    private String homepage;
    private TraktStatus status;
    private double rating;
    private int votes;
    private int comment_count;
    private TraktLanguage language;
    private List<TraktLanguage> available_translations;
    private List<Genre> genres;
    private int aired_episodes;
    
    public TraktShow() {}
    
    public TraktShow(String title, int year, TraktIds ids)
    {
        this.title = title;
        this.year = year;
        this.ids = ids;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public TraktIds getIds()
    {
        return ids;
    }
    
    public String getOverview()
    {
        return overview;
    }
    
    public OffsetDateTime getFirstAired()
    {
        return first_aired;
    }
    
    public TraktAirsInfo getAirs()
    {
        return airs;
    }
    
    public int getRuntime()
    {
        return runtime;
    }
    
    public TraktCertification getCertification()
    {
        return certification;
    }
    
    public String getNetwork()
    {
        return network;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public OffsetDateTime getUpdatedAt()
    {
        return updated_at;
    }
    
    public String getTrailer()
    {
        return trailer;
    }
    
    public String getHomepage()
    {
        return homepage;
    }
    
    public TraktStatus getStatus()
    {
        return status;
    }
    
    public double getRating()
    {
        return rating;
    }
    
    public int getVotes()
    {
        return votes;
    }
    
    public int getCommentCount()
    {
        return comment_count;
    }
    
    public TraktLanguage getLanguage()
    {
        return language;
    }
    
    public List<TraktLanguage> getAvailableTranslations()
    {
        return available_translations;
    }
    
    public List<Genre> getGenres()
    {
        return genres;
    }
    
    public int getAiredEpisodes()
    {
        return aired_episodes;
    }
    
}