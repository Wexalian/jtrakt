package com.wexalian.jtrakt.endpoint.users;

import com.wexalian.jtrakt.endpoint.TraktComment;
import com.wexalian.jtrakt.endpoint.TraktItemFilterType;
import com.wexalian.jtrakt.endpoint.TraktList;
import com.wexalian.jtrakt.endpoint.TraktUser;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.endpoint.comments.TraktItemComment;
import com.wexalian.jtrakt.endpoint.sync.TraktHistoryItem;
import com.wexalian.jtrakt.endpoint.sync.TraktSyncItems;
import com.wexalian.jtrakt.endpoint.sync.TraktSyncUpdate;
import com.wexalian.jtrakt.endpoint.sync.TraktWatchlistItem;
import com.wexalian.jtrakt.endpoint.sync.collection.TraktCollectionMovie;
import com.wexalian.jtrakt.endpoint.sync.collection.TraktCollectionShow;
import com.wexalian.jtrakt.endpoint.sync.rating.TraktRatedItem;
import com.wexalian.jtrakt.endpoint.sync.watched.TraktWatchedItem;
import com.wexalian.jtrakt.endpoint.users.data.ListReorder;
import com.wexalian.jtrakt.endpoint.users.follow.TraktFollowRequest;
import com.wexalian.jtrakt.endpoint.users.follow.TraktFollower;
import com.wexalian.jtrakt.endpoint.users.follow.TraktFollowerConfirmation;
import com.wexalian.jtrakt.endpoint.users.follow.TraktFollowerRequest;
import com.wexalian.jtrakt.endpoint.users.hidden.TraktHiddenItem;
import com.wexalian.jtrakt.endpoint.users.hidden.TraktHiddenUpdate;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Pagination;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.OffsetDateTime;
import java.util.List;

public class TraktUsersEndpoint
{
    private final TraktHTTP http;
    
    public TraktUsersEndpoint(TraktHTTP http)
    {
        this.http = http;
    }
    
    public TraktSettings getSettings(@Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/settings");
        
        return http.getAndParse(query, TraktTypeTokens.SETTINGS, token);
    }
    
    public List<TraktFollowerRequest> getFollowerRequests(@Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/requests");
        
        return http.getAndParse(query, TraktTypeTokens.FOLLOWER_REQUESTS, token);
    }
    
    public TraktFollowerConfirmation approveFollowerRequest(int id, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/requests/{id}")
                                     .path("id", id);
        
        return http.getAndParse(query, TraktTypeTokens.FOLLOWER_CONFIRMATION, token);
    }
    
    public void denyFollowerRequest(int id, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/requests/{id}")
                                     .path("id", id);
        
        http.delete(query, token);
    }
    
    public List<TraktHiddenItem> getHiddenItems(@Nonnull String section, @Nullable String type, @Nullable Pagination pagination, @Nullable Extended extended, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/hidden/{section}/{type}")
                                     .path("section", section)
                                     .path("type", type)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.HIDDEN_ITEMS, token);
    }
    
    public TraktSyncUpdate addHiddenItems(@Nonnull String section, @Nonnull TraktSyncItems<TraktHiddenUpdate> items, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/hidden/{section}")
                                     .path("section", section);
        
        return http.getAndParse(query, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public TraktSyncUpdate removeHiddenItems(@Nonnull String section, @Nonnull TraktSyncItems<TraktHiddenUpdate> items, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/hidden/{section}/remove")
                                     .path("section", section);
        
        return http.getAndParse(query, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public List<TraktLikedItem> getLikes(@Nullable String type, @Nullable Pagination pagination, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/likes/{type}")
                                     .path("type", type)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.LIKED_ITEMS, token);
    }
    
    public TraktUser getProfile(@Nonnull String id, @Nullable Extended extended, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}")
                                     .path("id", id)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.USER, token);
    }
    
    public List<TraktCollectionMovie> getMovieCollection(@Nonnull String id, @Nullable Extended extended, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/collection/movies")
                                     .path("id", id)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.MOVIE_COLLECTION, token);
    }
    
    public List<TraktCollectionShow> getShowCollection(@Nonnull String id, @Nullable Extended extended, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/collection/shows")
                                     .path("id", id)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SHOW_COLLECTION, token);
    }
    
    public List<TraktItemComment> getComments(@Nonnull String id, @Nullable TraktComment.Type commentType, @Nullable TraktItemFilterType type, @Nullable String include_replies, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/comments/{comment_type}/{type}")
                                     .path("id", id)
                                     .path("comment_type", commentType)
                                     .path("type", type)
                                     .query("include_replies", include_replies)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.ITEM_COMMENTS, token);
    }
    
    public List<TraktList> getLists(@Nonnull String id, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/lists")
                                     .path("id", id);
        
        return http.getAndParse(query, TraktTypeTokens.LISTS, token);
    }
    
    public TraktList createList(@Nonnull String id, @Nonnull TraktListInfo listInfo, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/lists")
                                     .path("id", id);
        
        return http.postAndParse(query, listInfo, TraktTypeTokens.LIST, token);
    }
    
    public TraktListReorderUpdate reorderLists(@Nonnull String id, int[] reorderedRanks, @Nonnull TraktAccessToken token)
    {
        ListReorder reorder = new ListReorder(reorderedRanks);
        
        TraktQuery query = TraktQuery.create("users/{id}/lists/reorder")
                                     .path("id", id);
        
        return http.postAndParse(query, reorder, TraktTypeTokens.LIST_REORDER_UPDATE, token);
    }
    
    public TraktList getList(@Nonnull String id, @Nonnull String listId, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/lists/{list_id}")
                                     .path("id", id)
                                     .path("list_id", listId);
        
        return http.getAndParse(query, TraktTypeTokens.LIST, token);
    }
    
    public TraktList updateList(@Nonnull String id, @Nonnull String listId, @Nonnull TraktListInfo listInfo, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/lists/{list_id}")
                                     .path("id", id)
                                     .path("list_id", listId);
        
        return http.postAndParse(query, listInfo, TraktTypeTokens.LIST, token);
    }
    
    public void deleteList(@Nonnull String id, @Nonnull String listId, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/lists/{list_id}")
                                     .path("id", id)
                                     .path("list_id", listId);
        http.delete(query, token);
    }
    
    public void likeList(@Nonnull String id, @Nonnull String list_id, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/lists/{list_id}/like")
                                     .path("id", id)
                                     .path("list_id", list_id);
        
        http.post(query, null, token);
    }
    
    public void removeLikeFromList(@Nonnull String id, @Nonnull String list_id, @Nonnull TraktAccessToken token)
    {
        
        TraktQuery query = TraktQuery.create("users/{id}/lists/{list_id}/like")
                                     .path("id", id)
                                     .path("list_id", list_id);
        
        http.delete(query, token);
    }
    
    public List<TraktListItem> getListItems(@Nonnull String id, @Nonnull String list_id, @Nullable String type, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/lists/{list_id}/items/{type}")
                                     .path("id", id)
                                     .path("list_id", list_id)
                                     .path("type", type)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.LIST_ITEMS, token);
    }
    
    public TraktSyncUpdate addListItems(@Nonnull String id, @Nonnull String list_id, @Nonnull TraktSyncItems<TraktListItem> items, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/list/{list_id}/items")
                                     .path("id", id)
                                     .path("list_id", list_id);
        
        return http.postAndParse(query, items, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public TraktSyncUpdate removeListItems(@Nonnull String id, @Nonnull String list_id, @Nonnull TraktSyncItems<TraktListItem> items, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/list/{list_id}/items/remove")
                                     .path("id", id)
                                     .path("list_id", list_id);
        
        return http.postAndParse(query, items, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public TraktListReorderUpdate reorderListItems(@Nonnull String id, @Nonnull String list_id, int[] reorderedRanks, @Nonnull TraktAccessToken token)
    {
        ListReorder reorder = new ListReorder(reorderedRanks);
        
        TraktQuery query = TraktQuery.create("users/{id}/lists/{list_id}/items/reorder")
                                     .path("id", id)
                                     .path("list_id", list_id);
        
        return http.postAndParse(query, reorder, TraktTypeTokens.LIST_REORDER_UPDATE, token);
    }
    
    public List<TraktComment> getListComments(@Nonnull String id, @Nonnull String list_id, @Nullable String sort, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/lists/{list_id}/comments/{sort}")
                                     .path("id", id)
                                     .path("list_id", list_id)
                                     .path("sort", sort);
        
        return http.getAndParse(query, TraktTypeTokens.COMMENTS, token);
    }
    
    public TraktFollowRequest followUser(@Nonnull String id, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/follow")
                                     .path("id", id);
        
        return http.postAndParse(query, null, TraktTypeTokens.FOLLOW_REQUEST, token);
    }
    
    public void unfollowUser(@Nonnull String id, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/follow")
                                     .path("id", id);
        http.delete(query, token);
    }
    
    public List<TraktFollower> getFollowers(@Nonnull String id, @Nullable Extended extended, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/followers")
                                     .path("id", id)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.USER_FOLLOWERS);
    }
    
    public List<TraktFollower> getFollowing(@Nonnull String id, @Nullable Extended extended, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/following")
                                     .path("id", id)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.USER_FOLLOWERS);
    }
    
    public List<TraktFriend> getFriends(@Nonnull String id, @Nullable Extended extended, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/friends")
                                     .path("id", id)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.USER_FRIENDS, token);
    }
    
    public List<TraktHistoryItem> getHistory(@Nonnull String id, @Nullable String type, int item_id, @Nullable OffsetDateTime start_at, @Nullable OffsetDateTime end_at, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/history/{type}/{item_id}")
                                     .path("id", id)
                                     .path("type", type)
                                     .path("item_id", item_id)
                                     .query("start_at", start_at)
                                     .query("end_at", end_at)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.HISTORY_ITEMS, token);
    }
    
    public List<TraktRatedItem> getRatings(@Nonnull String id, @Nullable String type, @Nullable Integer rating, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/ratings/{type}/{rating}")
                                     .path("id", id)
                                     .path("type", type)
                                     .path("rating", rating)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.RATED_ITEMS, token);
    }
    
    public List<TraktWatchlistItem> getWatchlist(@Nonnull String id, @Nullable String type, @Nullable String sort, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/watchlist/{type}/{sort}")
                                     .path("id", id)
                                     .path("type", type)
                                     .path("sort", sort)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHLIST_ITEMS, token);
    }
    
    public TraktWatchingItem getCurrentlyWatching(@Nonnull String id, @Nullable Extended extended, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/watching")
                                     .path("id", id)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHING_ITEM, token);
    }
    
    public List<TraktWatchedItem> getWatchedItems(@Nonnull String id, @Nonnull String type, @Nullable Extended extended, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/watched/{type}")
                                     .path("id", id)
                                     .path("type", type)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SYNC_WATCHED_ITEMS, token);
    }
    
    public TraktUserStats getStats(@Nonnull String id, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("users/{id}/stats")
                                     .path("id", id);
        
        return http.getAndParse(query, TraktTypeTokens.USER_STATS, token);
    }
}
