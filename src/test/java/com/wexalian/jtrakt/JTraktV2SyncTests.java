package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktItemsType;
import com.wexalian.jtrakt.endpoint.TraktWatchedItem;
import com.wexalian.jtrakt.endpoint.scrobble.TraktScrobbleData;
import com.wexalian.jtrakt.endpoint.scrobble.TraktScrobbleItem;
import com.wexalian.jtrakt.endpoint.sync.TraktPlayback;
import com.wexalian.jtrakt.endpoint.sync.TraktSyncUpdate;
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
import com.wexalian.jtrakt.http.query.Extended;
import org.junit.jupiter.api.*;

import java.time.OffsetDateTime;
import java.util.List;

@Tag("sync")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JTraktV2SyncTests extends JTraktV2Tests {
    
    private TraktPlayback playback = null;
    
    @Test
    void testLastActivity() {
        TraktActivity lastActivity = TRAKT.getSyncEndpoint().getLastActivity(ACCESS_TOKEN);
        
        notNull(lastActivity, "last activity is null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(1)
    void testPlayback() {
        TraktScrobbleData data = new TraktScrobbleData(EPISODE, 25);
        TraktScrobbleItem item = TRAKT.getScrobbleEndpoint().pause(data, ACCESS_TOKEN);
        
        notNull(item, "playback scrobble start item is null");
        
        List<TraktPlayback> playbacks = TRAKT.getSyncEndpoint().getPlaybacks(null, null, null, ACCESS_TOKEN);
        
        notNull(playbacks, "playbacks are null");
        Assertions.assertFalse(playbacks.isEmpty(), "playbacks are empty");
        playback = playbacks.get(0);
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(2)
    void testRemovePlayback() {
        if (playback != null) {
            TRAKT.getSyncEndpoint().removePlayback(playback.getId(), ACCESS_TOKEN);
            return;
        }
        Assertions.fail("No playback to delete");
    }
    
    @Test
    void testMovieCollection() {
        List<TraktCollectionMovie> movieCollection = TRAKT.getSyncEndpoint()
                                                          .getMovieCollection(Extended.METADATA, ACCESS_TOKEN);
        
        notNull(movieCollection, "movie collection is null");
    }
    
    @Test
    void testShowCollection() {
        List<TraktCollectionShow> showCollection = TRAKT.getSyncEndpoint()
                                                        .getShowCollection(Extended.METADATA, ACCESS_TOKEN);
        
        notNull(showCollection, "show collection is null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    void testAddToCollection() {
        TraktCollectionData data = new TraktCollectionData();
        data.addShow(SHOW, OffsetDateTime.now(), null);
        
        TraktSyncUpdate traktSyncUpdate = TRAKT.getSyncEndpoint().addToCollection(data, ACCESS_TOKEN);
        
        notNull(traktSyncUpdate, "trakt sync add update is null");
        Assertions.assertTrue(traktSyncUpdate.getAdded().getEpisodes() > 0 || traktSyncUpdate.getUpdated()
                                                                                             .getEpisodes() > 0, "no episodes added/updated");
    }
    
    @Test
    @Tag(STAGING_TAG)
    void testRemoveFromCollection() {
        TraktCollectionData data = new TraktCollectionData();
        data.addShow(SHOW, OffsetDateTime.now(), null);
        
        TraktSyncUpdate traktSyncUpdate = TRAKT.getSyncEndpoint().removeFromCollection(data, ACCESS_TOKEN);
        
        notNull(traktSyncUpdate, "trakt sync remove update is null");
    }
    
    @Test
    void testWatchedItems() {
        List<TraktWatchedItem> watchedItems = TRAKT.getSyncEndpoint()
                                                   .getWatchedItems(TraktItemsType.SHOWS, Extended.FULL, ACCESS_TOKEN);
        
        notNull(watchedItems, "watched items are null");
    }
    
    @Test
    void testHistory() {
        List<TraktHistoryItem> historyItems = TRAKT.getSyncEndpoint()
                                                   .getHistory(TraktItemsType.EPISODES,
                                                               -1,
                                                               null,
                                                               null,
                                                               null,
                                                               Extended.FULL,
                                                               ACCESS_TOKEN);
        
        notNull(historyItems, "history items are null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(3)
    void testAddToHistory() {
        TraktHistoryData data = new TraktHistoryData();
        TraktHistoryData.ShowData showData = data.addShow(SHOW, OffsetDateTime.now());
        TraktHistoryData.ShowData.Season season = showData.addSeason(4, OffsetDateTime.now());
        season.addEpisode(9, OffsetDateTime.now());
        TraktSyncUpdate update = TRAKT.getSyncEndpoint().addToHistory(data, ACCESS_TOKEN);
        
        notNull(update, "add history update is null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(4)
    void testRemoveFromHistory() {
        TraktHistoryData data = new TraktHistoryData();
        data.addShow(SHOW);
        TraktSyncUpdate update = TRAKT.getSyncEndpoint().removeFromHistory(data, ACCESS_TOKEN);
        
        notNull(update, "remove history update is null");
    }
    
    @Test
    void testRatings() {
        List<TraktRatedItem> ratings = TRAKT.getSyncEndpoint()
                                            .getRatings(TraktItemsType.SHOWS, -1, null, Extended.FULL, ACCESS_TOKEN);
        
        notNull(ratings, "ratings are null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(5)
    void testAddToRatings() {
        TraktRatingData data = new TraktRatingData();
        data.addShow(SHOW, 10, OffsetDateTime.now());
        TraktSyncUpdate traktSyncUpdate = TRAKT.getSyncEndpoint().addToRatings(data, ACCESS_TOKEN);
        
        notNull(traktSyncUpdate, "add ratings update is null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(6)
    void testRemoveFromRatings() {
        TraktRatingData data = new TraktRatingData();
        data.addShow(SHOW);
        TraktSyncUpdate traktSyncUpdate = TRAKT.getSyncEndpoint().removeFromRatings(data, ACCESS_TOKEN);
        
        notNull(traktSyncUpdate, "remove rating update is null");
    }
    
    @Test
    void testWatchlist() {
        List<TraktWatchlistItem> watchlist = TRAKT.getSyncEndpoint()
                                                  .getWatchlist(TraktItemsType.SHOWS,
                                                                null,
                                                                null,
                                                                Extended.FULL,
                                                                ACCESS_TOKEN);
        
        notNull(watchlist, "watchlist is null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(7)
    void testAddToWatchlist() {
        TraktWatchlistData data = new TraktWatchlistData();
        data.addShow(SHOW);
        TraktSyncUpdate traktSyncUpdate = TRAKT.getSyncEndpoint().addToWatchlist(data, ACCESS_TOKEN);
        
        notNull(traktSyncUpdate, "add watchlist update is null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(8)
    void testRemoveFromWatchlist() {
        TraktWatchlistData data = new TraktWatchlistData();
        data.addShow(SHOW);
        TraktSyncUpdate traktSyncUpdate = TRAKT.getSyncEndpoint().removeFromWatchlist(data, ACCESS_TOKEN);
        
        notNull(traktSyncUpdate, "remove watchlist update is null");
    }
    
    @Test
    void testRecommendation() {
        List<TraktRecommendationItem> recommendation = TRAKT.getSyncEndpoint()
                                                            .getRecommendations(TraktItemsType.SHOWS,
                                                                                null,
                                                                                null,
                                                                                Extended.FULL,
                                                                                ACCESS_TOKEN);
        
        notNull(recommendation, "recommendation is null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(9)
    void testAddToRecommendation() {
        TraktRecommendationData data = new TraktRecommendationData();
        data.addShow(SHOW, "Best Show Ever!");
        TraktSyncUpdate traktSyncUpdate = TRAKT.getSyncEndpoint().addToRecommendation(data, ACCESS_TOKEN);
        
        notNull(traktSyncUpdate, "add recommendation update is null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(10)
    void testRemoveFromRecommendation() {
        TraktRecommendationData data = new TraktRecommendationData();
        data.addShow(SHOW, "");
        TraktSyncUpdate traktSyncUpdate = TRAKT.getSyncEndpoint().removeFromRecommendation(data, ACCESS_TOKEN);
        
        notNull(traktSyncUpdate, "remove recommendation update is null");
    }
}
