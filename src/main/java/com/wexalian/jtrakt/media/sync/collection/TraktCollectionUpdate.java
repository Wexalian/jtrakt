package com.wexalian.jtrakt.media.sync.collection;

import com.google.gson.annotations.SerializedName;
import com.wexalian.jtrakt.media.TraktEpisode;
import com.wexalian.jtrakt.media.TraktMovie;
import com.wexalian.jtrakt.media.TraktSeason;
import com.wexalian.jtrakt.media.TraktShow;

import java.time.OffsetDateTime;

public class TraktCollectionUpdate
{
    private TraktMovie movie;
    private TraktShow show;
    private TraktSeason season;
    private TraktEpisode episode;
    private OffsetDateTime collected_at;
    
    private String media_type;
    private String resolution;
    private String hdr;
    private String audio;
    private String audio_channels;
    @SerializedName("3d")
    private boolean is3d;
    
    public TraktCollectionUpdate(TraktMovie movie)
    {
        this.movie = movie;
    }
    
    public TraktCollectionUpdate(TraktShow show)
    {
        this.show = show;
    }
    
    public TraktCollectionUpdate(TraktSeason season)
    {
        this.season = season;
    }
    
    public TraktCollectionUpdate(TraktEpisode episode)
    {
        this.episode = episode;
    }
    
    public TraktCollectionUpdate(TraktMovie movie, OffsetDateTime collected_at, String media_type, String resolution, String hdr, String audio, String audio_channels, boolean is3d)
    {
        this.movie = movie;
        this.collected_at = collected_at;
        this.media_type = media_type;
        this.resolution = resolution;
        this.hdr = hdr;
        this.audio = audio;
        this.audio_channels = audio_channels;
        this.is3d = is3d;
    }
    
    public TraktCollectionUpdate(TraktShow show, OffsetDateTime collected_at, String media_type, String resolution, String hdr, String audio, String audio_channels, boolean is3d)
    {
        this.show = show;
        this.collected_at = collected_at;
        this.media_type = media_type;
        this.resolution = resolution;
        this.hdr = hdr;
        this.audio = audio;
        this.audio_channels = audio_channels;
        this.is3d = is3d;
    }
    
    public TraktCollectionUpdate(TraktSeason season, OffsetDateTime collected_at, String media_type, String resolution, String hdr, String audio, String audio_channels, boolean is3d)
    {
        this.season = season;
        this.collected_at = collected_at;
        this.media_type = media_type;
        this.resolution = resolution;
        this.hdr = hdr;
        this.audio = audio;
        this.audio_channels = audio_channels;
        this.is3d = is3d;
    }
    
    public TraktCollectionUpdate(TraktEpisode episode, OffsetDateTime collected_at, String media_type, String resolution, String hdr, String audio, String audio_channels, boolean is3d)
    {
        this.episode = episode;
        this.collected_at = collected_at;
        this.media_type = media_type;
        this.resolution = resolution;
        this.hdr = hdr;
        this.audio = audio;
        this.audio_channels = audio_channels;
        this.is3d = is3d;
    }
}
