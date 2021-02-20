package com.wexalian.jtrakt.endpoint.sync;

import com.wexalian.jtrakt.endpoint.TraktItemFilterType;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.endpoint.sync.activity.TraktActivity;
import com.wexalian.jtrakt.endpoint.sync.collection.TraktCollectionMovie;
import com.wexalian.jtrakt.endpoint.sync.collection.TraktCollectionShow;
import com.wexalian.jtrakt.endpoint.sync.collection.TraktCollectionUpdate;
import com.wexalian.jtrakt.endpoint.sync.rating.TraktRatedItem;
import com.wexalian.jtrakt.endpoint.sync.watched.TraktWatchedItem;
import com.wexalian.jtrakt.endpoint.sync.watched.TraktWatchedUpdate;
import com.wexalian.jtrakt.endpoint.sync.watchlist.TraktWatchlistItem;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Pagination;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.OffsetDateTime;
import java.util.List;

public class TraktSyncEndpoint {
    private final TraktHTTP http;
    
    public TraktSyncEndpoint(TraktHTTP http) {
        this.http = http;
    }
    
    public TraktActivity getLastActivity(@Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("last_activities");
        
        return http.getAndParse(query, TraktTypeTokens.LAST_ACTIVITY, token);
    }
    
    public TraktPlayback getPlayback(@Nullable TraktItemFilterType type, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/playback/{type}").path("type", type);
        
        return http.getAndParse(query, TraktTypeTokens.PLAYBACK, token);
    }
    
    public void removePlayback(int id, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/playback/{id}").path("id", id);
        
        http.delete(query, token);
    }
    
    public List<TraktCollectionMovie> getMovieCollection(@Nonnull TraktAccessToken token, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("sync/collection/movies").query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.MOVIE_COLLECTION, token);
    }
    
    public List<TraktCollectionShow> getShowCollection(@Nonnull TraktAccessToken token, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("sync/collection/shows").query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SHOW_COLLECTION, token);
    }
    
    public TraktSyncUpdate addToCollection(@Nonnull TraktSyncItems<TraktCollectionUpdate> items, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/collection");
        
        return http.postAndParse(query, items, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public TraktSyncUpdate removeFromCollection(@Nonnull TraktSyncItems<TraktCollectionUpdate> items, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/collection/remove");
        
        return http.postAndParse(query, items, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public List<TraktWatchedItem> getWatchedItems(@Nullable TraktItemFilterType type, @Nullable Extended extended, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/watched/{type}").path("type", type).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SYNC_WATCHED_ITEMS, token);
    }
    
    public List<TraktHistoryItem> getHistory(@Nullable TraktItemFilterType type, @Nullable String id, @Nullable OffsetDateTime start_at, @Nullable OffsetDateTime end_at, @Nullable Pagination pagination, @Nullable Extended extended, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/history/{type}/{id}")
                                     .path("type", type)
                                     .path("id", id)
                                     .query("start_at", start_at)
                                     .query("end_at", end_at)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.HISTORY_ITEMS, token);
    }
    
    public TraktSyncUpdate addToHistory(@Nonnull TraktSyncItems<TraktWatchedUpdate> items, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/history");
        
        return http.postAndParse(query, items, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public TraktSyncUpdate removeFromHistory(@Nonnull TraktSyncItems<TraktWatchedUpdate> items, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/history/remove");
        
        return http.postAndParse(query, items, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public List<TraktRatedItem> getRatings(@Nullable TraktItemFilterType type, int rating, @Nullable Pagination pagination, @Nullable Extended extended, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/ratings/{type}/{rating}")
                                     .path("type", type)
                                     .path("rating", rating)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.RATED_ITEMS, token);
    }
    
    public TraktSyncUpdate addToRatings(@Nonnull TraktSyncItems<TraktRatedItem> items, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/ratings");
        
        return http.postAndParse(query, items, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public TraktSyncUpdate removeFromRatings(@Nonnull TraktSyncItems<TraktRatedItem> items, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/ratings/remove");
        
        return http.postAndParse(query, items, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public List<TraktWatchlistItem> getWatchlist(@Nullable TraktItemFilterType type, @Nullable String sort, @Nullable Pagination pagination, @Nullable Extended extended, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/watchlist/{type}/{sort}")
                                     .path("type", type)
                                     .path("sort", sort)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHLIST_ITEMS, token);
    }
    
    public TraktSyncUpdate addToWatchlist(@Nonnull TraktSyncItems<TraktWatchlistItem> items, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/watchlist");
        
        return http.postAndParse(query, items, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public TraktSyncUpdate removeFromWatchlist(@Nonnull TraktSyncItems<TraktWatchlistItem> items, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/watchlist/remove");
        
        return http.postAndParse(query, items, TraktTypeTokens.SYNC_UPDATE, token);
    }
}
