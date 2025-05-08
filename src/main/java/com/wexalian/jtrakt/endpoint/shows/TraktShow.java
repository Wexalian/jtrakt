package com.wexalian.jtrakt.endpoint.shows;

import com.wexalian.jtrakt.endpoint.TraktAirsInfo;
import com.wexalian.jtrakt.endpoint.TraktIds;
import com.wexalian.jtrakt.endpoint.genres.TraktGenre;
import com.wexalian.jtrakt.endpoint.languages.TraktLanguage;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TraktShow {
    //standard
    private String title;
    private int year;
    private TraktIds ids;
    
    //extended
    private String overview;
    private OffsetDateTime first_aired;
    private TraktAirsInfo airs;
    private int runtime;
    private String certification;
    private String network;
    private String country;
    private OffsetDateTime updated_at;
    private String trailer;
    private String homepage;
    private Status status;
    private double rating;
    private int votes;
    private int comment_count;
    private TraktLanguage language;
    private List<TraktLanguage> available_translations;
    private List<TraktGenre> genres;
    private int aired_episodes;
    
    public TraktShow() {}
    
    public TraktShow(String title, int year, TraktIds ids) {
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
    
    public String getOverview() {
        return overview;
    }
    
    public OffsetDateTime getFirstAired() {
        return first_aired;
    }
    
    public TraktAirsInfo getAirs() {
        return airs;
    }
    
    public int getRuntime() {
        return runtime;
    }
    
    public String getCertification() {
        return certification;
    }
    
    public String getNetwork() {
        return network;
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
    
    public Status getStatus() {
        return status;
    }
    
    public double getRating() {
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
    
    public int getAiredEpisodes() {
        return aired_episodes;
    }
    
    public enum Status {
        ENDED("ended"),
        RETURNING("returning series"),
        CANCELED("canceled"),
        IN_PRODUCTION("in production");
        
        private static final Map<String, Status> STRING_MAPPING = new HashMap<>();
        
        static {
            for (Status status : Status.values()) {
                STRING_MAPPING.put(status.toString(), status);
            }
        }
        
        private final String value;
        
        Status(String value) {
            this.value = value;
        }
        
        public static Status fromValue(String value) {
            return STRING_MAPPING.get(value);
        }
        
        @Override
        public String toString() {
            return value;
        }
    }
}
