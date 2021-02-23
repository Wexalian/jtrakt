package com.wexalian.jtrakt.endpoint.sync.collection;

import com.google.gson.annotations.SerializedName;
import com.wexalian.jtrakt.endpoint.TraktIds;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeason;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class TraktCollectionData {
    private List<MovieData> movies;
    private List<ShowData> shows;
    private List<SeasonData> seasons;
    private List<EpisodeData> episodes;
    
    public void addMovie(TraktMovie movie, OffsetDateTime collected_at, TraktItemMetadata metadata) {
        if (movies == null) {
            movies = new ArrayList<>();
        }
        movies.add(new MovieData(movie, collected_at, metadata));
    }
    
    public ShowData addShow(TraktShow show, OffsetDateTime collected_at, TraktItemMetadata metadata) {
        if (shows == null) {
            shows = new ArrayList<>();
        }
        ShowData showData = new ShowData(show, collected_at, metadata);
        shows.add(showData);
        return showData;
    }
    
    public void addSeason(TraktSeason season, OffsetDateTime collected_at, TraktItemMetadata metadata) {
        if (seasons == null) {
            seasons = new ArrayList<>();
        }
        seasons.add(new SeasonData(season, collected_at, metadata));
    }
    
    public void addEpisode(TraktEpisode episode, OffsetDateTime collected_at, TraktItemMetadata metadata) {
        if (episodes == null) {
            episodes = new ArrayList<>();
        }
        episodes.add(new EpisodeData(episode, collected_at, metadata));
    }
    
    private static class MovieData {
        private final String title;
        private final int year;
        private final TraktIds ids;
        
        private OffsetDateTime collected_at;
        
        private String media_type;
        private String resolution;
        private String hdr;
        private String audio;
        private String audio_channels;
        @SerializedName("3d")
        private boolean is3d;
        
        public MovieData(TraktMovie movie) {
            this.title = movie.getTitle();
            this.year = movie.getYear();
            this.ids = movie.getIds();
        }
        
        public MovieData(TraktMovie movie, OffsetDateTime collected_at) {
            this(movie);
            this.collected_at = collected_at;
        }
        
        public MovieData(TraktMovie movie, OffsetDateTime collected_at, TraktItemMetadata metadata) {
            this(movie, collected_at);
            
            if (metadata != null) {
                this.media_type = metadata.getMediaType();
                this.resolution = metadata.getResolution();
                this.hdr = metadata.getHdr();
                this.audio = metadata.getAudio();
                this.audio_channels = metadata.getAudioChannels();
                this.is3d = metadata.is3d();
            }
        }
    }
    
    public static class ShowData {
        private final String title;
        private final int year;
        private final TraktIds ids;
        
        private OffsetDateTime collected_at;
        
        private String media_type;
        private String resolution;
        private String hdr;
        private String audio;
        private String audio_channels;
        @SerializedName("3d")
        private boolean is3d;
        
        private List<Season> seasons;
        
        public ShowData(TraktShow show) {
            this.title = show.getTitle();
            this.year = show.getYear();
            this.ids = show.getIds();
        }
        
        public ShowData(TraktShow show, OffsetDateTime collected_at) {
            this(show);
            this.collected_at = collected_at;
        }
        
        public ShowData(TraktShow show, OffsetDateTime collected_at, TraktItemMetadata metadata) {
            this(show, collected_at);
            
            if (metadata != null) {
                this.media_type = metadata.getMediaType();
                this.resolution = metadata.getResolution();
                this.hdr = metadata.getHdr();
                this.audio = metadata.getAudio();
                this.audio_channels = metadata.getAudioChannels();
                this.is3d = metadata.is3d();
            }
        }
        
        public Season addSeason(int number) {
            if (seasons == null) {
                seasons = new ArrayList<>();
            }
            Season season = new Season(number);
            seasons.add(season);
            return season;
        }
        
        public static class Season {
            private final int number;
            private List<Episode> episodes;
            
            public Season(int number) {
                this.number = number;
            }
            
            public void addEpisode(int number) {
                if (episodes == null) {
                    episodes = new ArrayList<>();
                }
                episodes.add(new Episode(number));
            }
            
            public static class Episode {
                private final int number;
                
                public Episode(int number) {
                    this.number = number;
                }
            }
        }
        
    }
    
    public static class SeasonData {
        private final TraktIds ids;
        
        private OffsetDateTime collected_at;
        
        private String media_type;
        private String resolution;
        private String hdr;
        private String audio;
        private String audio_channels;
        @SerializedName("3d")
        private boolean is3d;
        
        public SeasonData(TraktSeason episode) {
            this.ids = episode.getIds();
        }
        
        public SeasonData(TraktSeason episode, OffsetDateTime collected_at) {
            this(episode);
            this.collected_at = collected_at;
        }
        
        public SeasonData(TraktSeason episode, OffsetDateTime collected_at, TraktItemMetadata metadata) {
            this(episode, collected_at);
            
            if (metadata != null) {
                this.media_type = metadata.getMediaType();
                this.resolution = metadata.getResolution();
                this.hdr = metadata.getHdr();
                this.audio = metadata.getAudio();
                this.audio_channels = metadata.getAudioChannels();
                this.is3d = metadata.is3d();
            }
        }
    }
    
    public static class EpisodeData {
        private final TraktIds ids;
        
        private OffsetDateTime collected_at;
        
        private String media_type;
        private String resolution;
        private String hdr;
        private String audio;
        private String audio_channels;
        @SerializedName("3d")
        private boolean is3d;
        
        public EpisodeData(TraktEpisode episode) {
            this.ids = episode.getIds();
        }
        
        public EpisodeData(TraktEpisode episode, OffsetDateTime collected_at) {
            this(episode);
            this.collected_at = collected_at;
        }
        
        public EpisodeData(TraktEpisode episode, OffsetDateTime collected_at, TraktItemMetadata metadata) {
            this(episode, collected_at);
            
            if (metadata != null) {
                this.media_type = metadata.getMediaType();
                this.resolution = metadata.getResolution();
                this.hdr = metadata.getHdr();
                this.audio = metadata.getAudio();
                this.audio_channels = metadata.getAudioChannels();
                this.is3d = metadata.is3d();
            }
        }
    }
}
