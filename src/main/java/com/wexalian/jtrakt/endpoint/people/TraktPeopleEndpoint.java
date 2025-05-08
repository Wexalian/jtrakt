package com.wexalian.jtrakt.endpoint.people;

import com.wexalian.jtrakt.endpoint.lists.TraktList;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Pagination;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.nullability.annotations.Nonnull;
import com.wexalian.nullability.annotations.Nullable;

import java.util.List;

public class TraktPeopleEndpoint {
    private final TraktHTTP http;
    
    public TraktPeopleEndpoint(TraktHTTP http) {this.http = http;}
    
    public TraktPerson getSummary(@Nonnull String id, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("people/{id}").path("id", id).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.PERSON);
    }
    
    public TraktMovieCredits getMovieCredits(@Nonnull String id, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("people/{id}/movies").path("id", id).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.MOVIE_CREDITS);
    }
    
    public TraktShowCredits getShowCredits(@Nonnull String id, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("people/{id}/shows").path("id", id).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SHOW_CREDITS);
    }
    
    public List<TraktList> getLists(@Nonnull String id, @Nullable TraktList.Type type, @Nullable TraktList.Sort sort, @Nullable Pagination pagination) {
        TraktQuery query = TraktQuery.create("people/{id}/lists/{type}/{sort}")
                                     .path("id", id)
                                     .path("type", type)
                                     .path("sort", sort)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.LISTS);
    }
}
