package com.wexalian.jtrakt.endpoint.lists;

import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Pagination;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nullable;
import java.util.List;

public class TraktListsEndpoint
{
    private final TraktHTTP http;
    
    public TraktListsEndpoint(TraktHTTP http)
    {
        this.http = http;
    }
    
    public List<TraktLikedList> getTrendingLists(@Nullable Pagination pagination)
    {
        TraktQuery query = TraktQuery.create("lists/trending")
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.LIKED_LISTS);
    }
    
    public List<TraktLikedList> getPopularLists(@Nullable Pagination pagination)
    {
        TraktQuery query = TraktQuery.create("lists/popular")
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.LIKED_LISTS);
    }
}
