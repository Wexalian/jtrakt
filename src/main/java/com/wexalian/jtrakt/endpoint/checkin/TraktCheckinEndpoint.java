package com.wexalian.jtrakt.endpoint.checkin;

import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nonnull;

public class TraktCheckinEndpoint {
    private final TraktHTTP http;
    
    public TraktCheckinEndpoint(@Nonnull TraktHTTP http) {
        this.http = http;
    }
    
    public TraktCheckinItem checkin(@Nonnull TraktCheckinData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("checkin");
        
        return http.postAndParse(query, data, TraktTypeTokens.CHECKIN, token);
    }
    
    public void deleteAllCheckins(@Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("checkin");
        
        http.delete(query, token);
    }
}
