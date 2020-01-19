package com.wexalian.jtrakt.media.sync.watched;

import com.wexalian.jtrakt.media.TraktEpisode;
import com.wexalian.jtrakt.media.TraktMovie;
import com.wexalian.jtrakt.media.TraktSeason;
import com.wexalian.jtrakt.media.TraktShow;

import java.time.OffsetDateTime;

public class TraktWatchedUpdate
{
    private TraktMovie movie;
    private TraktShow show;
    private TraktSeason season;
    private TraktEpisode episode;
    private OffsetDateTime watched_at;
    
    public TraktWatchedUpdate(TraktMovie movie)
    {
        this.movie = movie;
    }
    
    public TraktWatchedUpdate(TraktShow show)
    {
        this.show = show;
    }
    
    public TraktWatchedUpdate(TraktSeason season)
    {
        this.season = season;
    }
    
    public TraktWatchedUpdate(TraktEpisode episode)
    {
        this.episode = episode;
    }
    
    public TraktWatchedUpdate(TraktMovie movie, OffsetDateTime watched_at)
    {
        this.movie = movie;
        this.watched_at = watched_at;
    }
    
    public TraktWatchedUpdate(TraktShow show, OffsetDateTime watched_at)
    {
        this.show = show;
        this.watched_at = watched_at;
    }
    
    public TraktWatchedUpdate(TraktSeason season, OffsetDateTime watched_at)
    {
        this.season = season;
        this.watched_at = watched_at;
    }
    
    public TraktWatchedUpdate(TraktEpisode episode, OffsetDateTime watched_at)
    {
        this.episode = episode;
        this.watched_at = watched_at;
    }
}
