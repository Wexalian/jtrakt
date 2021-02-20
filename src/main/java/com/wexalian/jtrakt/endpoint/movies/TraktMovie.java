package com.wexalian.jtrakt.endpoint.movies;

import com.wexalian.jtrakt.endpoint.TraktIds;
import com.wexalian.jtrakt.endpoint.genres.TraktGenre;
import com.wexalian.jtrakt.endpoint.languages.TraktLanguage;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public class TraktMovie {
    private String title;
    private int year;
    private TraktIds ids;
    
    private String tagline;
    private String overview;
    private LocalDate released;
    private int runtime;
    private String country;
    private OffsetDateTime updated_at;
    private String trailer;
    private String homepage;
    private TraktMovieStatus status;
    private float rating;
    private int votes;
    private int comment_count;
    private TraktLanguage language;
    private List<TraktLanguage> available_translations;
    private List<TraktGenre> genres;
    private String certification;
    
    public TraktMovie() {}
    
    public TraktMovie(String title, int year, TraktIds ids) {
        this.title = title;
        this.year = year;
        this.ids = ids;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getYear() {
        return year;
    }
    
    public TraktIds getIds() {
        return ids;
    }
    
    public String getTagline() {
        return tagline;
    }
    
    public String getOverview() {
        return overview;
    }
    
    public LocalDate getReleased() {
        return released;
    }
    
    public int getRuntime() {
        return runtime;
    }
    
    public String getCountry() {
        return country;
    }
    
    public OffsetDateTime getUpdatedAt() {
        return updated_at;
    }
    
    public String getTrailer() {
        return trailer;
    }
    
    public String getHomepage() {
        return homepage;
    }
    
    public TraktMovieStatus getStatus() {
        return status;
    }
    
    public float getRating() {
        return rating;
    }
    
    public int getVotes() {
        return votes;
    }
    
    public int getCommentCount() {
        return comment_count;
    }
    
    public TraktLanguage getLanguage() {
        return language;
    }
    
    public List<TraktLanguage> getAvailableTranslations() {
        return available_translations;
    }
    
    public List<TraktGenre> getGenres() {
        return genres;
    }
    
    public String getCertification() {
        return certification;
    }
}
