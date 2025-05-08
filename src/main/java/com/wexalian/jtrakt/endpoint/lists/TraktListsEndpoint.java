package com.wexalian.jtrakt.endpoint.lists;

import com.wexalian.jtrakt.endpoint.TraktItemsType;
import com.wexalian.jtrakt.endpoint.TraktLike;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.endpoint.comments.TraktComment;
import com.wexalian.jtrakt.endpoint.users.TraktListItem;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Pagination;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.nullability.annotations.Nonnull;
import com.wexalian.nullability.annotations.Nullable;

import java.util.List;

public class TraktListsEndpoint {
    private final TraktHTTP http;
    
    public TraktListsEndpoint(TraktHTTP http) {
        this.http = http;
    }
    
    public List<TraktLikedList> getTrendingLists(@Nullable Pagination pagination) {
        TraktQuery query = TraktQuery.create("lists/trending").query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.LIKED_LISTS);
    }
    
    public List<TraktLikedList> getPopularLists(@Nullable Pagination pagination) {
        TraktQuery query = TraktQuery.create("lists/popular").query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.LIKED_LISTS);
    }
    
    public TraktList getList(int id) {
        TraktQuery query = TraktQuery.create("lists/{id}").path("id", id);
        
        return http.getAndParse(query, TraktTypeTokens.LIST);
    }
    
    public List<TraktLike> getListLikes(int id, @Nullable Pagination pagination) {
        TraktQuery query = TraktQuery.create("lists/{id}/likes").path("id", id).query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.LIKES);
    }
    
    public boolean listLike(int id, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("lists/{id}/like").path("id", id);
        return http.post(query, null, token);
    }
    
    public boolean listDeleteLike(int id, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("lists/{id}/like").path("id", id);
        return http.delete(query, token);
    }
    
    public List<TraktListItem> getListItems(int id, @Nullable TraktItemsType type, @Nullable Pagination pagination, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("lists/{id}/items/{type}")
                                     .path("id", id)
                                     .path("type", type)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.LIST_ITEMS);
    }
    
    public List<TraktComment> getListComments(int id, @Nullable TraktComment.Sort sort, @Nullable Pagination pagination) {
        TraktQuery query = TraktQuery.create("lists/{id}/items/{sort}")
                                     .path("id", id)
                                     .path("sort", sort)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.COMMENTS);
    }
    
}
