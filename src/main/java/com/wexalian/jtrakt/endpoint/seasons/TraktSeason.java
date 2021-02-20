package com.wexalian.jtrakt.endpoint.seasons;

import com.wexalian.jtrakt.endpoint.TraktIds;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;

import java.time.OffsetDateTime;
import java.util.List;

public class TraktSeason {
    private int number;
    private TraktIds ids;
    
    private List<TraktEpisode> episodes;
    
    private float rating;
    private int votes;
    private int episode_count;
    private int aired_episodes;
    private String title;
    private String overview;
    private OffsetDateTime first_aired;
    private String network;
    
    public TraktSeason() {}
    
    public TraktSeason(int number, TraktIds ids) {
        this.number = number;
        this.ids = ids;
    }
    
    public int getNumber() {
        return number;
    }
    
    public TraktIds getIds() {
        return ids;
    }
    
    public float getRating() {
        return rating;
    }
    
    public int getVotes() {
        return votes;
    }
    
    public int getEpisodeCount() {
        return episode_count;
    }
    
    public int getAiredEpisodes() {
        return aired_episodes;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getOverview() {
        return overview;
    }
    
    public OffsetDateTime getFirstAired() {
        return first_aired;
    }
    
    public String getNetwork() {
        return network;
    }
    
    public List<TraktEpisode> getEpisodes() {
        return episodes;
    }
}
