package com.wexalian.jtrakt.endpoint.people;

import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Pagination;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.jtrakt.media.TraktList;
import com.wexalian.jtrakt.media.TraktPerson;
import com.wexalian.jtrakt.media.people.TraktPersonMovieCast;
import com.wexalian.jtrakt.media.people.TraktPersonShowCast;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class TraktPeopleEndpoint
{
    private final TraktHTTP http;
    
    public TraktPeopleEndpoint(TraktHTTP http) {this.http = http;}
    
    public TraktPerson get(@Nonnull String id, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("people/{id}")
                                     .path("id", id)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.PERSON);
    }
    
    public List<TraktPersonMovieCast> getMovies(@Nonnull String id, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("people/{id}/movies")
                                     .path("id", id)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.PERSON_MOVIE_CASTS);
    }
    
    public List<TraktPersonShowCast> getShows(@Nonnull String id, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("people/{id}/shows")
                                     .path("id", id)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.PERSON_SHOW_CASTS);
    }
    
    public List<TraktList> getLists(@Nonnull String id, @Nullable TraktList.Type type, @Nullable TraktList.Sort sort, @Nullable Pagination pagination)
    {
        TraktQuery query = TraktQuery.create("people/{id}/lists/{type}/{sort}")
                                     .path("id", id)
                                     .path("type", type)
                                     .path("sort", sort)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.LISTS);
    }
}