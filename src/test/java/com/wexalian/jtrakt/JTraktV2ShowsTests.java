package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.*;
import com.wexalian.jtrakt.endpoint.comments.TraktComment;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.lists.TraktList;
import com.wexalian.jtrakt.endpoint.shows.*;
import com.wexalian.jtrakt.endpoint.users.TraktUser;
import com.wexalian.jtrakt.http.query.Extended;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.Period;
import java.util.List;

@Tag("shows")
public class JTraktV2ShowsTests extends JTraktV2Tests {
    
    @Test
    void testTrending() {
        List<TraktTrendingShow> trendingShows = TEST_TRAKT.getShowsEndpoint().getTrending(null, null);
        
        Assertions.assertNotNull(trendingShows, "trending shows are null");
    }
    
    @Test
    void testPopular() {
        List<TraktShow> popularShows = TEST_TRAKT.getShowsEndpoint().getPopular(null, Extended.FULL);
        
        Assertions.assertNotNull(popularShows, "popular shows is null");
    }
    
    @Test
    void testMostPlayed() {
        List<TraktWatchedShow> mostPlayed = TEST_TRAKT.getShowsEndpoint()
                                                      .getMostPlayed(TraktTimePeriod.WEEKLY, null, null);
        
        Assertions.assertNotNull(mostPlayed, "most played is null");
    }
    
    @Test
    void testMostWatched() {
        List<TraktWatchedShow> mostWatched = TEST_TRAKT.getShowsEndpoint()
                                                       .getMostWatched(TraktTimePeriod.WEEKLY, null, null);
        
        Assertions.assertNotNull(mostWatched, "most watched is null");
    }
    
    @Test
    void testMostCollected() {
        List<TraktWatchedShow> mostCollected = TEST_TRAKT.getShowsEndpoint()
                                                         .getMostCollected(TraktTimePeriod.WEEKLY, null, null);
        
        Assertions.assertNotNull(mostCollected, "most collected is null");
    }
    
    @Test
    void testMostAnticipated() {
        List<TraktListedShow> mostAnticipated = TEST_TRAKT.getShowsEndpoint().getMostAnticipated(null, null);
        
        Assertions.assertNotNull(mostAnticipated, "most anticipated is null");
    }
    
    @Test
    void testRecentlyUpdated() {
        List<TraktUpdatedShow> recentlyUpdated = TEST_TRAKT.getShowsEndpoint()
                                                           .getUpdates(OffsetDateTime.now()
                                                                                     .minus(Period.ofWeeks(1)), null, null);
        
        Assertions.assertNotNull(recentlyUpdated, "recently updated is null");
    }
    
    @Test
    void testSummary() {
        TraktShow show = TEST_TRAKT.getShowsEndpoint().getSummary(TEST_SHOW.getIds().getImdbId(), Extended.FULL);
        
        Assertions.assertNotNull(show, "summary for show is null");
    }
    
    @Test
    void testAliases() {
        
        List<TraktAlias> aliases = TEST_TRAKT.getShowsEndpoint().getAliases(TEST_SHOW.getIds().getImdbId(), null);
        
        Assertions.assertNotNull(aliases, "aliases are null");
    }
    
    @Test
    void testTranslations() {
        List<TraktTranslation> translations = TEST_TRAKT.getShowsEndpoint()
                                                        .getTranslations(TEST_SHOW.getIds().getImdbId(), null);
        
        Assertions.assertNotNull(translations, "translations are null");
    }
    
    @Test
    void testComments() {
        List<TraktComment> comments = TEST_TRAKT.getShowsEndpoint()
                                                .getComments(TEST_SHOW.getIds()
                                                                      .getImdbId(), TraktComment.Sort.NEWEST, null);
        
        Assertions.assertNotNull(comments, "comments are null");
    }
    
    @Test
    void testLists() {
        List<TraktList> lists = TEST_TRAKT.getShowsEndpoint()
                                          .getLists(TEST_SHOW.getIds().getImdbId(), null, null, null);
        
        Assertions.assertNotNull(lists, "lists are null");
    }
    
    @Test
    void testCollectionProgress() {
        TraktCollectionProgress.Show show = TEST_TRAKT.getShowsEndpoint()
                                                      .getCollectionProgress(TEST_SHOW.getIds()
                                                                                      .getImdbId(), false, false, false, TEST_ACCESS_TOKEN);
        
        Assertions.assertNotNull(show, "show collection is null");
    }
    
    @Test
    void testWatchedProgress() {
        
        TraktWatchedProgress.Show show = TEST_TRAKT.getShowsEndpoint()
                                                   .getWatchedProgress(TEST_SHOW.getIds()
                                                                                .getImdbId(), false, false, false, TEST_ACCESS_TOKEN);
        
        Assertions.assertNotNull(show, "show watched is null");
    }
    
    @Test
    void testPeople() {
        TraktShowCast cast = TEST_TRAKT.getShowsEndpoint().getPeople(TEST_SHOW.getIds().getImdbId(), null);
        
        Assertions.assertNotNull(cast, "cast is null");
    }
    
    @Test
    void testRatings() {
        TraktRatings ratings = TEST_TRAKT.getShowsEndpoint().getRatings(TEST_SHOW.getIds().getImdbId());
        
        Assertions.assertNotNull(ratings, "ratings are null");
    }
    
    @Test
    void testRelated() {
        List<TraktShow> related = TEST_TRAKT.getShowsEndpoint().getRelated(TEST_SHOW.getIds().getImdbId(), null, null);
        
        Assertions.assertNotNull(related, "related are null");
    }
    
    @Test
    void testStats() {
        TraktStats ratings = TEST_TRAKT.getShowsEndpoint().getStats(TEST_SHOW.getIds().getImdbId());
        
        Assertions.assertNotNull(ratings, "stats are null");
    }
    
    @Test
    void testWatching() {
        List<TraktUser> users = TEST_TRAKT.getShowsEndpoint().getWatchingUsers(TEST_SHOW.getIds().getImdbId(), null);
        
        Assertions.assertNotNull(users, "users are null");
    }
    
    @Test
    void testNextEpisode() {
        TraktEpisode nextEpisode = TEST_TRAKT.getShowsEndpoint().getNextEpisode(TEST_SHOW.getIds().getImdbId(), null);
        
        Assertions.assertNotNull(nextEpisode, "next episode is null, but the show is still returning (16/02/2021)");
    }
    
    @Test
    void testLastEpisode() {
        TraktEpisode lastEpisode = TEST_TRAKT.getShowsEndpoint().getLastEpisode(TEST_SHOW.getIds().getImdbId(), null);
        
        Assertions.assertNotNull(lastEpisode, "last episode is null");
    }
}
