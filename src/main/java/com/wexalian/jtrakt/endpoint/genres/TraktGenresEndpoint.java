package com.wexalian.jtrakt.endpoint.genres;

import com.wexalian.jtrakt.endpoint.TraktItemFilterType;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nonnull;
import java.util.List;

public class TraktGenresEndpoint {
    private final TraktHTTP http;
    
    public TraktGenresEndpoint(TraktHTTP http) {
        this.http = http;
    }
    
    public List<TraktGenre> getGenres(@Nonnull TraktItemFilterType type) {
        TraktQuery query = TraktQuery.create("genres/{type}").path("type", type);
        
        return http.getAndParse(query, TraktTypeTokens.GENRES);
    }
}
