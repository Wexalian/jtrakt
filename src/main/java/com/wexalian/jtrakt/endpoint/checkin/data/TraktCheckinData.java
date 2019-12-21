package com.wexalian.jtrakt.endpoint.checkin.data;

import com.wexalian.jtrakt.media.TraktEpisode;
import com.wexalian.jtrakt.media.TraktMovie;
import com.wexalian.jtrakt.media.checkin.TraktSharing;

public class TraktCheckinData
{
    private TraktMovie movie;
    private TraktEpisode episode;
    private TraktSharing sharing;
    private String venue_id;
    private String venue_name;
    private String app_version;
    private String app_date;
    
    public TraktCheckinData(TraktMovie movie, TraktSharing sharing, String venue_id, String venue_name, String app_version, String app_date)
    {
        this.movie = movie;
        this.sharing = sharing;
        this.venue_id = venue_id;
        this.venue_name = venue_name;
        this.app_version = app_version;
        this.app_date = app_date;
    }
    
    public TraktCheckinData(TraktEpisode episode, TraktSharing sharing, String venue_id, String venue_name, String app_version, String app_date)
    {
        this.episode = episode;
        this.sharing = sharing;
        this.venue_id = venue_id;
        this.venue_name = venue_name;
        this.app_version = app_version;
        this.app_date = app_date;
    }
}
