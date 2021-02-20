package com.wexalian.jtrakt.endpoint.episodes;

import com.wexalian.jtrakt.endpoint.TraktIds;

import java.time.OffsetDateTime;
import java.util.List;

public class TraktEpisode {
    private int season;
    private int number;
    private String title;
    private TraktIds ids;
    
    private int number_abs;
    private String overview;
    private OffsetDateTime first_aired;
    private OffsetDateTime updated_at;
    private float rating;
    private int votes;
    private int comment_count;
    private List<String> available_translations;
    private int runtime;
    
    public TraktEpisode() {}
    
    public TraktEpisode(int season, int number, String title, TraktIds ids) {
        this.season = season;
        this.number = number;
        this.title = title;
        this.ids = ids;
    }
    
    public int getSeason() {
        return season;
    }
    
    public int getNumber() {
        return number;
    }
    
    public String getTitle() {
        return title;
    }
    
    public TraktIds getIds() {
        return ids;
    }
    
    public int getNumberAbs() {
        return number_abs;
    }
    
    public String getOverview() {
        return overview;
    }
    
    public OffsetDateTime getFirstAired() {
        return first_aired;
    }
    
    public OffsetDateTime getUpdatedAt() {
        return updated_at;
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
    
    public List<String> getAvailableTranslations() {
        return available_translations;
    }
    
    public int getRuntime() {
        return runtime;
    }
}
