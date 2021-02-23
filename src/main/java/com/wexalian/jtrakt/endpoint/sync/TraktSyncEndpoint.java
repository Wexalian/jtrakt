package com.wexalian.jtrakt.endpoint.sync;

import com.wexalian.jtrakt.endpoint.TraktItemFilterType;
import com.wexalian.jtrakt.endpoint.TraktWatchedItem;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.endpoint.sync.activity.TraktActivity;
import com.wexalian.jtrakt.endpoint.sync.collection.TraktCollectionData;
import com.wexalian.jtrakt.endpoint.sync.collection.TraktCollectionMovie;
import com.wexalian.jtrakt.endpoint.sync.collection.TraktCollectionShow;
import com.wexalian.jtrakt.endpoint.sync.history.TraktHistoryData;
import com.wexalian.jtrakt.endpoint.sync.history.TraktHistoryItem;
import com.wexalian.jtrakt.endpoint.sync.rating.TraktRatedItem;
import com.wexalian.jtrakt.endpoint.sync.rating.TraktRatingData;
import com.wexalian.jtrakt.endpoint.sync.recommendations.TraktRecommendationData;
import com.wexalian.jtrakt.endpoint.sync.recommendations.TraktRecommendationItem;
import com.wexalian.jtrakt.endpoint.sync.watchlist.TraktWatchlistData;
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
        TraktQuery query = TraktQuery.create("sync/last_activities");
        
        return http.getAndParse(query, TraktTypeTokens.LAST_ACTIVITY, token);
    }
    
    public List<TraktPlayback> getPlaybacks(@Nullable TraktItemFilterType type, @Nullable OffsetDateTime start_at, @Nullable OffsetDateTime end_at, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/playback/{type}")
                                     .path("type", type)
                                     .query("start_at", start_at)
                                     .query("end_at", end_at);
        
        return http.getAndParse(query, TraktTypeTokens.PLAYBACKS, token);
    }
    
    public void removePlayback(int id, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/playback/{id}").path("id", id);
        
        http.delete(query, token);
    }
    
    public List<TraktCollectionMovie> getMovieCollection(@Nullable Extended extended, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/collection/movies").query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.MOVIE_COLLECTION, token);
    }
    
    public List<TraktCollectionShow> getShowCollection(@Nullable Extended extended, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/collection/shows").query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SHOW_COLLECTION, token);
    }
    
    public TraktSyncUpdate addToCollection(@Nonnull TraktCollectionData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/collection");
        
        return http.postAndParse(query, data, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public TraktSyncUpdate removeFromCollection(@Nonnull TraktCollectionData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/collection/remove");
        
        return http.postAndParse(query, data, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public List<TraktWatchedItem> getWatchedItems(@Nullable TraktItemFilterType type, @Nullable Extended extended, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/watched/{type}").path("type", type).query(extended);
    
        return http.getAndParse(query, TraktTypeTokens.WATCHED_ITEMS, token);
    }
    
    public List<TraktHistoryItem> getHistory(@Nullable TraktItemFilterType type, long id, @Nullable OffsetDateTime start_at, @Nullable OffsetDateTime end_at, @Nullable Pagination pagination, @Nullable Extended extended, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/history/{type}/{id}")
                                     .path("type", type)
                                     .path("id", id)
                                     .query("start_at", start_at)
                                     .query("end_at", end_at)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.HISTORY_ITEMS, token);
    }
    
    public TraktSyncUpdate addToHistory(@Nonnull TraktHistoryData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/history");
        
        return http.postAndParse(query, data, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public TraktSyncUpdate removeFromHistory(@Nonnull TraktHistoryData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/history/remove");
        
        return http.postAndParse(query, data, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public List<TraktRatedItem> getRatings(@Nullable TraktItemFilterType type, int rating, @Nullable Pagination pagination, @Nullable Extended extended, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/ratings/{type}/{rating}")
                                     .path("type", type)
                                     .path("rating", rating)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.RATED_ITEMS, token);
    }
    
    public TraktSyncUpdate addToRatings(@Nonnull TraktRatingData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/ratings");
        
        return http.postAndParse(query, data, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public TraktSyncUpdate removeFromRatings(@Nonnull TraktRatingData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/ratings/remove");
        
        return http.postAndParse(query, data, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public List<TraktWatchlistItem> getWatchlist(@Nullable TraktItemFilterType type, @Nullable String sort, @Nullable Pagination pagination, @Nullable Extended extended, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/watchlist/{type}/{sort}")
                                     .path("type", type)
                                     .path("sort", sort)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHLIST_ITEMS, token);
    }
    
    public TraktSyncUpdate addToWatchlist(@Nonnull TraktWatchlistData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/watchlist");
        
        return http.postAndParse(query, data, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public TraktSyncUpdate removeFromWatchlist(@Nonnull TraktWatchlistData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/watchlist/remove");
        
        return http.postAndParse(query, data, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public List<TraktRecommendationItem> getRecommendations(@Nullable TraktItemFilterType type, @Nullable String sort, @Nullable Pagination pagination, @Nullable Extended extended, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/recommendations/{type}/{sort}")
                                     .path("type", type)
                                     .path("sort", sort)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.RECOMMENDATION_ITEMS, token);
    }
    
    public TraktSyncUpdate addToRecommendation(@Nonnull TraktRecommendationData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/recommendations");
        
        return http.postAndParse(query, data, TraktTypeTokens.SYNC_UPDATE, token);
    }
    
    public TraktSyncUpdate removeFromRecommendation(@Nonnull TraktRecommendationData data, @Nonnull TraktAccessToken token) {
        TraktQuery query = TraktQuery.create("sync/recommendations/remove");
        
        return http.postAndParse(query, data, TraktTypeTokens.SYNC_UPDATE, token);
    }
}
