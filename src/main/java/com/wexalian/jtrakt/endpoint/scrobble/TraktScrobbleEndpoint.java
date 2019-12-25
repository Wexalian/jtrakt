package com.wexalian.jtrakt.endpoint.scrobble;

import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.endpoint.scrobble.data.TraktScrobbleData;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.jtrakt.media.TraktMovie;
import com.wexalian.jtrakt.media.TraktShow;
import com.wexalian.jtrakt.media.scrobble.TraktScrobbleMovie;
import com.wexalian.jtrakt.media.scrobble.TraktScrobbleShow;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TraktScrobbleEndpoint
{
    private final TraktHTTP http;
    
    public TraktScrobbleEndpoint(TraktHTTP http)
    {
        this.http = http;
    }
    
    public TraktScrobbleMovie start(@Nonnull TraktMovie movie, float progress, @Nullable String app_version, @Nullable String app_date, @Nonnull TraktAccessToken token)
    {
        TraktScrobbleData data = new TraktScrobbleData(movie, progress, app_version, app_date);
        
        TraktQuery query = TraktQuery.create("scrobble/start");
        
        return http.postAndParse(query, data, TraktTypeTokens.SCROBBLE_MOVIE, token);
    }
    
    public TraktScrobbleShow start(@Nonnull TraktShow show, float progress, @Nullable String app_version, @Nullable String app_date, @Nonnull TraktAccessToken token)
    {
        TraktScrobbleData data = new TraktScrobbleData(show, progress, app_version, app_date);
        
        TraktQuery query = TraktQuery.create("scrobble/start");
        
        return http.postAndParse(query, data, TraktTypeTokens.SCROBBLE_SHOW, token);
    }
    
    public TraktScrobbleMovie pause(@Nonnull TraktMovie movie, float progress, @Nullable String app_version, @Nullable String app_date, @Nonnull TraktAccessToken token)
    {
        TraktScrobbleData data = new TraktScrobbleData(movie, progress, app_version, app_date);
        
        TraktQuery query = TraktQuery.create("scrobble/pause");
        
        return http.postAndParse(query, data, TraktTypeTokens.SCROBBLE_MOVIE, token);
    }
    
    public TraktScrobbleShow pause(@Nonnull TraktShow show, float progress, @Nullable String app_version, @Nullable String app_date, @Nonnull TraktAccessToken token)
    {
        TraktScrobbleData data = new TraktScrobbleData(show, progress, app_version, app_date);
        
        TraktQuery query = TraktQuery.create("scrobble/pause");
        
        return http.postAndParse(query, data, TraktTypeTokens.SCROBBLE_SHOW, token);
    }
    
    public TraktScrobbleMovie stop(@Nonnull TraktMovie movie, float progress, @Nullable String app_version, @Nullable String app_date, @Nonnull TraktAccessToken token)
    {
        TraktScrobbleData data = new TraktScrobbleData(movie, progress, app_version, app_date);
        
        TraktQuery query = TraktQuery.create("scrobble/stop");
        
        return http.postAndParse(query, data, TraktTypeTokens.SCROBBLE_MOVIE, token);
    }
    
    public TraktScrobbleShow stop(@Nonnull TraktShow show, float progress, @Nullable String app_version, @Nullable String app_date, @Nonnull TraktAccessToken token)
    {
        TraktScrobbleData data = new TraktScrobbleData(show, progress, app_version, app_date);
        
        TraktQuery query = TraktQuery.create("scrobble/stop");
        
        return http.postAndParse(query, data, TraktTypeTokens.SCROBBLE_SHOW, token);
    }
    
}
