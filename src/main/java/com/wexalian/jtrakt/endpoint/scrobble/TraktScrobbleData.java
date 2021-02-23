package com.wexalian.jtrakt.endpoint.scrobble;

import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;

public class TraktScrobbleData {
    private final float progress;
    private TraktMovie movie;
    private TraktEpisode episode;
    private String app_version;
    private String app_date;
    
    public TraktScrobbleData(TraktMovie movie, float progress) {
        this.movie = movie;
        this.progress = progress;
    }
    
    public TraktScrobbleData(TraktMovie movie, float progress, String app_version, String app_date) {
        this.movie = movie;
        this.progress = progress;
        this.app_version = app_version;
        this.app_date = app_date;
    }
    
    public TraktScrobbleData(TraktEpisode episode, float progress) {
        this.episode = episode;
        this.progress = progress;
    }
    
    public TraktScrobbleData(TraktEpisode episode, float progress, String app_version, String app_date) {
        this.episode = episode;
        this.progress = progress;
        this.app_version = app_version;
        this.app_date = app_date;
    }
}
