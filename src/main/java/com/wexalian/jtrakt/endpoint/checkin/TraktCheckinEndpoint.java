package com.wexalian.jtrakt.endpoint.checkin;

import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.endpoint.checkin.data.TraktCheckinData;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.jtrakt.media.TraktEpisode;
import com.wexalian.jtrakt.media.TraktMovie;
import com.wexalian.jtrakt.media.checkin.TraktCheckinEpisode;
import com.wexalian.jtrakt.media.checkin.TraktCheckinMovie;
import com.wexalian.jtrakt.media.checkin.TraktSharing;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TraktCheckinEndpoint
{
    private final TraktHTTP http;
    
    public TraktCheckinEndpoint(@Nonnull TraktHTTP http)
    {
        this.http = http;
    }
    
    public TraktCheckinMovie checkinMovie(@Nonnull TraktMovie movie, @Nonnull TraktAccessToken token)
    {
        return checkinMovie(movie, null, "", "", "", "", token);
    }
    
    public TraktCheckinMovie checkinMovie(@Nonnull TraktMovie movie, @Nullable TraktSharing sharing, @Nonnull String venue_id, @Nonnull String venue_name, @Nonnull String app_version, @Nonnull String app_data, @Nullable TraktAccessToken token)
    {
        TraktCheckinData data = new TraktCheckinData(movie, sharing, venue_id, venue_name, app_version, app_data);
        
        TraktQuery query = TraktQuery.create("checkin");
        
        return http.postAndParse(query, data, TraktTypeTokens.CHECKIN_MOVIE, token);
    }
    
    public TraktCheckinEpisode checkinEpisode(@Nonnull TraktEpisode episode, @Nonnull TraktAccessToken token)
    {
        return checkinEpisode(episode, null, "", "", "", "", token);
    }
    
    public TraktCheckinEpisode checkinEpisode(@Nonnull TraktEpisode episode, @Nullable TraktSharing sharing, @Nonnull String venue_id, @Nonnull String venue_name, @Nonnull String app_version, @Nonnull String app_data, @Nullable TraktAccessToken token)
    {
        TraktCheckinData data = new TraktCheckinData(episode, sharing, venue_id, venue_name, app_version, app_data);
        
        TraktQuery query = TraktQuery.create("checkin");
        
        return http.postAndParse(query, data, TraktTypeTokens.CHECKIN_EPISODE, token);
    }
    
    public void deleteCheckins(@Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("checkin");
        http.delete(query, token);
    }
}
