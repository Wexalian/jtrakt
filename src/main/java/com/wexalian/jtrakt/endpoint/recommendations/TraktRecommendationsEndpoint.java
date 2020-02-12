package com.wexalian.jtrakt.endpoint.recommendations;

import com.wexalian.jtrakt.endpoint.TraktMovie;
import com.wexalian.jtrakt.endpoint.TraktShow;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class TraktRecommendationsEndpoint
{
    private final TraktHTTP http;
    
    public TraktRecommendationsEndpoint(TraktHTTP http) {this.http = http;}
    
    public List<TraktMovie> getMovies(boolean ignoreCollected, int limit, @Nonnull TraktAccessToken token, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("recommendations/movies")
                                     .query("ignore_collected", ignoreCollected)
                                     .query("limit", limit)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.MOVIES, token);
    }
    
    public void hideMovie(@Nonnull String id, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("recommendations/movies/{id}")
                                     .path("id", id);
        
        http.delete(query, token);
    }
    
    public List<TraktShow> getShows(boolean ignoreCollected, int limit, @Nonnull TraktAccessToken token, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("recommendations/shows")
                                     .query("ignore_collected", ignoreCollected)
                                     .query("limit", limit)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SHOWS, token);
    }
    
    public void hideShow(@Nonnull String id, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("recommendations/show/{id}")
                                     .path("id", id);
        
        http.delete(query, token);
    }
}
