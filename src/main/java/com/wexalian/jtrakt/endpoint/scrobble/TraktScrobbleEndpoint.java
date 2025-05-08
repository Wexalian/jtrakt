package com.wexalian.jtrakt.endpoint.scrobble;

import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.nullability.annotations.Nonnull;

public class TraktScrobbleEndpoint {
    private final TraktHTTP http;
    
    public TraktScrobbleEndpoint(TraktHTTP http) {
        this.http = http;
    }
    
    public TraktScrobbleItem start(@Nonnull TraktScrobbleData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("scrobble/start");
        
        return http.postAndParse(query, data, TraktTypeTokens.SCROBBLE_ITEM, token);
    }
    
    public TraktScrobbleItem pause(@Nonnull TraktScrobbleData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("scrobble/pause");
        
        return http.postAndParse(query, data, TraktTypeTokens.SCROBBLE_ITEM, token);
    }
    
    public TraktScrobbleItem stop(@Nonnull TraktScrobbleData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("scrobble/stop");
        
        return http.postAndParse(query, data, TraktTypeTokens.SCROBBLE_ITEM, token);
    }
    
}
