package com.wexalian.jtrakt.endpoint.scrobble;

import com.wexalian.jtrakt.endpoint.TraktMovie;
import com.wexalian.jtrakt.endpoint.TraktShow;

public class TraktScrobbleData
{
    private TraktMovie movie;
    private TraktShow show;
    private float progress;
    private String app_version;
    private String app_date;
    
    public TraktScrobbleData(TraktMovie movie, float progress)
    {
        this.movie = movie;
        this.progress = progress;
    }
    
    public TraktScrobbleData(TraktMovie movie, float progress, String app_version, String app_date)
    {
        this.movie = movie;
        this.progress = progress;
        this.app_version = app_version;
        this.app_date = app_date;
    }
    
    public TraktScrobbleData(TraktShow show, float progress)
    {
        this.show = show;
        this.progress = progress;
    }
    
    public TraktScrobbleData(TraktShow show, float progress, String app_version, String app_date)
    {
        this.show = show;
        this.progress = progress;
        this.app_version = app_version;
        this.app_date = app_date;
    }
}