package com.wexalian.jtrakt.endpoint.search;

import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Filter;
import com.wexalian.jtrakt.http.query.Pagination;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class TraktSearchEndpoint {
    private final TraktHTTP http;
    
    public TraktSearchEndpoint(TraktHTTP http) {
        this.http = http;
    }
    
    public List<TraktSearchItem> textQuery(@Nonnull TraktItemType type, @Nonnull String queryString, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("search/{type}")
                                     .path("type", type)
                                     .query("query", queryString)
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.SEARCH_ITEM);
    }
    
    public List<TraktSearchItem> idLookup(@Nonnull TraktIdType idType, @Nonnull String id, @Nonnull TraktItemType type, @Nullable Pagination pagination, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("search/{id_type}/{id}")
                                     .path("id_type", idType)
                                     .path("id", id)
                                     .query("type", type)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SEARCH_ITEM);
    }
}
