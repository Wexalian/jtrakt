package com.wexalian.jtrakt.endpoint.users;

import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.endpoint.TraktItemsType;
import com.wexalian.jtrakt.endpoint.TraktWatchedItem;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.endpoint.comments.TraktComment;
import com.wexalian.jtrakt.endpoint.comments.TraktItemComment;
import com.wexalian.jtrakt.endpoint.lists.TraktList;
import com.wexalian.jtrakt.endpoint.sync.TraktSyncItems;
import com.wexalian.jtrakt.endpoint.sync.TraktSyncUpdate;
import com.wexalian.jtrakt.endpoint.sync.collection.TraktCollectionMovie;
import com.wexalian.jtrakt.endpoint.sync.collection.TraktCollectionShow;
import com.wexalian.jtrakt.endpoint.sync.history.TraktHistoryItem;
import com.wexalian.jtrakt.endpoint.sync.rating.TraktRatedItem;
import com.wexalian.jtrakt.endpoint.sync.watchlist.TraktWatchlistItem;
import com.wexalian.jtrakt.endpoint.users.data.ListReorder;
import com.wexalian.jtrakt.endpoint.users.follow.TraktFollowRequest;
import com.wexalian.jtrakt.endpoint.users.follow.TraktFollower;
import com.wexalian.jtrakt.endpoint.users.follow.TraktFollowerConfirmation;
import com.wexalian.jtrakt.endpoint.users.follow.TraktFollowerRequest;
import com.wexalian.jtrakt.endpoint.users.hidden.TraktHiddenData;
import com.wexalian.jtrakt.endpoint.users.hidden.TraktHiddenItem;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Pagination;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.nullability.annotations.Nonnull;
import com.wexalian.nullability.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.List;

public class TraktUsersEndpoint {
    private final TraktHTTP http;
    
    public TraktUsersEndpoint(TraktHTTP http) {
        this.http = http;
    }
    
    public TraktSettings getSettings(@Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/settings");
        
        return http.getAndParse(query, TraktTypeTokens.SETTINGS, token);
    }
    
    public List<TraktFollowerRequest> getFollowerRequests(@Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/requests");
        
        return http.getAndParse(query, TraktTypeTokens.FOLLOWER_REQUESTS, token);
    }
    
    public TraktFollowerConfirmation approveFollowerRequest(int slug, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/requests/{slug}").path("slug", slug);
        
        return http.getAndParse(query, TraktTypeTokens.FOLLOWER_CONFIRMATION, token);
    }
    
    public boolean denyFollowerRequest(int slug, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/requests/{slug}").path("slug", slug);
        
        return http.delete(query, token);
    }
    
    public List<TraktHiddenItem> getHiddenItems(@Nonnull TraktHiddenItem.Section section, @Nullable TraktItemType type, @Nullable Pagination pagination, @Nullable Extended extended, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/hidden/{section}").path("section", section).query("type", type)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.HIDDEN_ITEMS, token);
    }
    
    public TraktSyncUpdate hideItems(@Nonnull TraktHiddenItem.Section section, @Nonnull TraktHiddenData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/hidden/{section}").path("section", section);
        
        return http.postAndParse(query, data, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public TraktSyncUpdate unhideItems(@Nonnull TraktHiddenItem.Section section, @Nonnull TraktHiddenData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/hidden/{section}/remove").path("section", section);
        
        return http.postAndParse(query, data, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public List<TraktLikedItem> getLikes(@Nullable TraktItemsType type, @Nullable Pagination pagination, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/likes/{type}").path("type", type).query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.LIKED_ITEMS, token);
    }
    
    public TraktUser getProfile(@Nonnull String slug, @Nullable Extended extended, @Nullable TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}").path("slug", slug).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.USER, token);
    }
    
    public List<TraktCollectionMovie> getMovieCollection(@Nonnull String slug, @Nullable Extended extended, @Nullable TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/collection/movies").path("slug", slug).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.MOVIE_COLLECTION, token);
    }
    
    public List<TraktCollectionShow> getShowCollection(@Nonnull String slug, @Nullable Extended extended, @Nullable TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/collection/shows").path("slug", slug).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SHOW_COLLECTION, token);
    }
    
    public List<TraktItemComment> getComments(@Nonnull String slug, @Nullable TraktComment.Type comment_type, @Nullable TraktItemsType type, @Nullable String include_replies, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/comments/{comment_type}/{type}").path("slug", slug)
                                     .path("comment_type", comment_type)
                                     .path("type", type)
                                     .query("include_replies", include_replies)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.ITEM_COMMENTS, token);
    }
    
    public List<TraktList> getLists(@Nonnull String slug, @Nullable TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/lists").path("slug", slug);
        
        return http.getAndParse(query, TraktTypeTokens.LISTS, token);
    }
    
    public TraktList createList(@Nonnull String slug, @Nonnull TraktListInfo listInfo, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/lists").path("slug", slug);
        
        return http.postAndParse(query, listInfo, TraktTypeTokens.LIST, token);
    }
    
    public TraktListReorderUpdate reorderLists(@Nonnull String slug, Integer[] listIds, @Nonnull TraktAccessToken token) {
        ListReorder reorder = new ListReorder(listIds);
        
        TraktQuery query = TraktQuery.create("users/{slug}/lists/reorder").path("slug", slug);
        
        return http.postAndParse(query, reorder, TraktTypeTokens.LIST_REORDER_UPDATE, token);
    }
    
    public TraktList getList(@Nonnull String slug, @Nonnull String list_id, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/lists/{list_id}")
                                     .path("slug", slug)
                                     .path("list_id", list_id);
        
        return http.getAndParse(query, TraktTypeTokens.LIST, token);
    }
    
    public TraktList updateList(@Nonnull String slug, @Nonnull String list_id, @Nonnull TraktListInfo listInfo, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/lists/{list_id}")
                                     .path("slug", slug)
                                     .path("list_id", list_id);
        
        return http.putAndParse(query, listInfo, TraktTypeTokens.LIST, token);
    }
    
    public boolean deleteList(@Nonnull String slug, @Nonnull String listId, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/lists/{list_id}").path("slug", slug).path("list_id", listId);
        return http.delete(query, token);
    }
    
    public void likeList(@Nonnull String slug, @Nonnull String list_id, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/lists/{list_id}/like")
                                     .path("slug", slug)
                                     .path("list_id", list_id);
        
        http.post(query, null, token);
    }
    
    public boolean unlikeList(@Nonnull String slug, @Nonnull String list_id, @Nonnull TraktAccessToken token) {
        
        TraktQuery query = TraktQuery.create("users/{slug}/lists/{list_id}/like")
                                     .path("slug", slug)
                                     .path("list_id", list_id);
        
        return http.delete(query, token);
    }
    
    public List<TraktListItem> getListItems(@Nonnull String slug, @Nonnull String list_id, @Nullable TraktItemType type, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/lists/{list_id}/items/{type}").path("slug", slug)
                                     .path("list_id", list_id)
                                     .path("type", type)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.LIST_ITEMS, token);
    }
    
    public TraktSyncUpdate addListItems(@Nonnull String slug, @Nonnull String list_id, @Nonnull TraktSyncItems<TraktListItem> items, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/list/{list_id}/items")
                                     .path("slug", slug)
                                     .path("list_id", list_id);
        
        return http.postAndParse(query, items, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public TraktSyncUpdate removeListItems(@Nonnull String slug, @Nonnull String list_id, @Nonnull TraktSyncItems<TraktListItem> items, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/list/{list_id}/items/remove").path("slug", slug)
                                     .path("list_id", list_id);
        
        return http.postAndParse(query, items, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public TraktListReorderUpdate reorderListItems(@Nonnull String slug, @Nonnull String list_id, Integer[] reorderedRanks, @Nonnull TraktAccessToken token) {
        ListReorder reorder = new ListReorder(reorderedRanks);
        
        TraktQuery query = TraktQuery.create("users/{slug}/lists/{list_id}/items/reorder").path("slug", slug)
                                     .path("list_id", list_id);
        
        return http.postAndParse(query, reorder, TraktTypeTokens.LIST_REORDER_UPDATE, token);
    }
    
    public List<TraktComment> getListComments(@Nonnull String slug, @Nonnull String list_id, @Nullable String sort, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/lists/{list_id}/comments/{sort}").path("slug", slug)
                                     .path("list_id", list_id)
                                     .path("sort", sort);
        
        return http.getAndParse(query, TraktTypeTokens.COMMENTS, token);
    }
    
    public TraktFollowRequest followUser(@Nonnull String slug, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/follow").path("slug", slug);
        
        return http.postAndParse(query, null, TraktTypeTokens.FOLLOW_REQUEST, token);
    }
    
    public boolean unfollowUser(@Nonnull String slug, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/follow").path("slug", slug);
        return http.delete(query, token);
    }
    
    public List<TraktFollower> getFollowers(@Nonnull String slug, @Nullable Extended extended, @Nullable TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/followers").path("slug", slug).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.USER_FOLLOWERS);
    }
    
    public List<TraktFollower> getFollowing(@Nonnull String slug, @Nullable Extended extended, @Nullable TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/following").path("slug", slug).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.USER_FOLLOWERS);
    }
    
    public List<TraktFriend> getFriends(@Nonnull String slug, @Nullable Extended extended, @Nullable TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/friends").path("slug", slug).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.USER_FRIENDS, token);
    }
    
    public List<TraktHistoryItem> getHistory(@Nonnull String slug, @Nullable TraktItemType type, int item_id, @Nullable OffsetDateTime start_at, @Nullable OffsetDateTime end_at, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/history/{type}/{item_id}").path("slug", slug)
                                     .path("type", type)
                                     .path("item_id", item_id)
                                     .query("start_at", start_at)
                                     .query("end_at", end_at)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.HISTORY_ITEMS, token);
    }
    
    public List<TraktRatedItem> getRatings(@Nonnull String slug, @Nullable TraktItemType type, @Nullable Integer rating, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/ratings/{type}/{rating}").path("slug", slug)
                                     .path("type", type)
                                     .path("rating", rating)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.RATED_ITEMS, token);
    }
    
    public List<TraktWatchlistItem> getWatchlist(@Nonnull String slug, @Nullable TraktItemsType type, @Nullable String sort, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/watchlist/{type}/{sort}").path("slug", slug)
                                     .path("type", type)
                                     .path("sort", sort)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHLIST_ITEMS, token);
    }
    
    public TraktWatchingItem getCurrentlyWatching(@Nonnull String slug, @Nullable Extended extended, @Nullable TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/watching").path("slug", slug).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHING_ITEM, token);
    }
    
    public List<TraktWatchedItem> getWatchedItems(@Nonnull String slug, @Nonnull TraktItemType type, @Nullable Extended extended, @Nullable TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/watched/{type}").path("slug", slug)
                                     .path("type", type)
                                     .query(extended);
    
        return http.getAndParse(query, TraktTypeTokens.WATCHED_ITEMS, token);
    }
    
    public TraktUserStats getStats(@Nonnull String slug, @Nullable TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("users/{slug}/stats").path("slug", slug);
        
        return http.getAndParse(query, TraktTypeTokens.USER_STATS, token);
    }
}
