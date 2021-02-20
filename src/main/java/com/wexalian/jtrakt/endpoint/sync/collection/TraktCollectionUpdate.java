package com.wexalian.jtrakt.endpoint.sync.collection;

import com.google.gson.annotations.SerializedName;
import com.wexalian.jtrakt.endpoint.sync.TraktSyncItems;

import java.time.OffsetDateTime;

public class TraktCollectionUpdate {
    private TraktSyncItems.Movie movie;
    private TraktSyncItems.Show show;
    private TraktSyncItems.Season season;
    private TraktSyncItems.Episode episode;
    
    private OffsetDateTime collected_at;
    
    private String media_type;
    private String resolution;
    private String hdr;
    private String audio;
    private String audio_channels;
    @SerializedName("3d")
    private boolean is3d;
    
    public TraktCollectionUpdate(TraktSyncItems.Movie movie) {
        this.movie = movie;
    }
    
    public TraktCollectionUpdate(TraktSyncItems.Show show) {
        this.show = show;
    }
    
    public TraktCollectionUpdate(TraktSyncItems.Season season) {
        this.season = season;
    }
    
    public TraktCollectionUpdate(TraktSyncItems.Episode episode) {
        this.episode = episode;
    }
    
    public TraktCollectionUpdate(TraktSyncItems.Movie movie, OffsetDateTime collected_at, String media_type, String resolution, String hdr, String audio, String audio_channels, boolean is3d) {
        this.movie = movie;
        this.collected_at = collected_at;
        this.media_type = media_type;
        this.resolution = resolution;
        this.hdr = hdr;
        this.audio = audio;
        this.audio_channels = audio_channels;
        this.is3d = is3d;
    }
    
    public TraktCollectionUpdate(TraktSyncItems.Show show, OffsetDateTime collected_at, String media_type, String resolution, String hdr, String audio, String audio_channels, boolean is3d) {
        this.show = show;
        this.collected_at = collected_at;
        this.media_type = media_type;
        this.resolution = resolution;
        this.hdr = hdr;
        this.audio = audio;
        this.audio_channels = audio_channels;
        this.is3d = is3d;
    }
    
    public TraktCollectionUpdate(TraktSyncItems.Season season, OffsetDateTime collected_at, String media_type, String resolution, String hdr, String audio, String audio_channels, boolean is3d) {
        this.season = season;
        this.collected_at = collected_at;
        this.media_type = media_type;
        this.resolution = resolution;
        this.hdr = hdr;
        this.audio = audio;
        this.audio_channels = audio_channels;
        this.is3d = is3d;
    }
    
    public TraktCollectionUpdate(TraktSyncItems.Episode episode, OffsetDateTime collected_at, String media_type, String resolution, String hdr, String audio, String audio_channels, boolean is3d) {
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
