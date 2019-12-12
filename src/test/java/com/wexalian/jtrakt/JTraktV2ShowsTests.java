package com.wexalian.jtrakt;

import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.TimePeriod;
import com.wexalian.jtrakt.media.TraktCast;
import com.wexalian.jtrakt.media.TraktEpisode;
import com.wexalian.jtrakt.media.TraktUser;
import com.wexalian.jtrakt.media.info.*;
import com.wexalian.jtrakt.media.show.TraktCollectionProgress;
import com.wexalian.jtrakt.media.show.TraktList;
import com.wexalian.jtrakt.media.show.TraktShow;
import com.wexalian.jtrakt.media.show.TraktWatchedProgress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.Period;
import java.util.List;

class JTraktV2ShowsTests extends JTraktV2Tests
{
    
    @Test
    void testTrending()
    {
        List<TraktShow.Trending> trendingShows = TRAKT.getShows()
                                                      .getTrending(null, null);
        
        Assertions.assertNotNull(trendingShows, "trending shows is null");
    }
    
    @Test
    void testPopular()
    {
        List<TraktShow> popularShows = TRAKT.getShows()
                                            .getPopular(null, null);
        
        Assertions.assertNotNull(popularShows, "popular shows is null");
    }
    
    @Test
    void testMostPlayed()
    {
        List<TraktShow.Watched> mostPlayed = TRAKT.getShows()
                                                  .getMostPlayed(TimePeriod.WEEKLY, null, null);
        
        Assertions.assertNotNull(mostPlayed, "most played is null");
    }
    
    @Test
    void testMostWatched()
    {
        List<TraktShow.Watched> mostWatched = TRAKT.getShows()
                                                   .getMostWatched(TimePeriod.WEEKLY, null, null);
        
        Assertions.assertNotNull(mostWatched, "most watched is null");
    }
    
    @Test
    void testMostCollected()
    {
        List<TraktShow.Watched> mostCollected = TRAKT.getShows()
                                                     .getMostCollected(TimePeriod.WEEKLY, null, null);
        
        Assertions.assertNotNull(mostCollected, "most collected is null");
    }
    
    @Test
    void testMostAnticipated()
    {
        List<TraktShow.Listed> mostAnticipated = TRAKT.getShows()
                                                      .getMostAnticipated(null, null);
        
        Assertions.assertNotNull(mostAnticipated, "most anticipated is null");
    }
    
    @Test
    void testRecentlyUpdated()
    {
        List<TraktShow.Updated> recentlyUpdated = TRAKT.getShows()
                                                       .getUpdates(OffsetDateTime.now()
                                                                                 .minus(Period.ofWeeks(1)), null, null);
        
        Assertions.assertNotNull(recentlyUpdated, "recently updated is null");
    }
    
    @Test
    void testSummary()
    {
        TraktShow show = TRAKT.getShows()
                              .getSummary("tt2193021", Extended.FULL);
        
        Assertions.assertNotNull(show, "summary for show is null");
    }
    
    @Test
    void testAliases()
    {
    
        List<Alias> aliases = TRAKT.getShows()
                                   .getAliases("tt2193021", null);
        
        Assertions.assertNotNull(aliases, "aliases are null");
    }
    
    @Test
    void testTranslations()
    {
        List<Translation> translations = TRAKT.getShows()
                                              .getTranslations("tt2193021", null);
        
        Assertions.assertNotNull(translations, "translations are null");
    }
    
    @Test
    void testComments()
    {
        List<Comment> comments = TRAKT.getShows()
                                      .getComments("tt2193021", Comment.Sort.NEWEST, null);
        
        Assertions.assertNotNull(comments, "comments are null");
    }
    
    @Test
    void testLists()
    {
        List<TraktList> lists = TRAKT.getShows()
                                     .getLists("tt2193021", null, null, null);
        
        Assertions.assertNotNull(lists, "lists are null");
    }
    
    @Test
    void testCollectionProgress()
    {
        TraktCollectionProgress.Show show = TRAKT.getShows()
                                                 .getCollectionProgress("tt2193021", false, false, false, ACCESS_TOKEN);
        
        Assertions.assertNotNull(show, "show collection is null");
    }
    
    @Test
    void testWatchedProgress()
    {
    
        TraktWatchedProgress.Show show = TRAKT.getShows()
                                              .getWatchedProgress("tt2193021", false, false, false, ACCESS_TOKEN);
        
        Assertions.assertNotNull(show, "show watched is null");
    }
    
    @Test
    void testPeople()
    {
        TraktCast cast = TRAKT.getShows()
                              .getPeople("tt2193021", null);
        
        Assertions.assertNotNull(cast, "cast is null");
    }
    
    @Test
    void testRatings()
    {
        Ratings ratings = TRAKT.getShows()
                               .getRatings("tt2193021");
        
        Assertions.assertNotNull(ratings, "ratings are null");
    }
    
    @Test
    void testRelated()
    {
        List<TraktShow> related = TRAKT.getShows()
                                       .getRelated("tt2193021", null, null);
        
        Assertions.assertNotNull(related, "related are null");
    }
    
    @Test
    void testStats()
    {
        Stats ratings = TRAKT.getShows()
                             .getStats("tt2193021");
        
        Assertions.assertNotNull(ratings, "stats are null");
    }
    
    @Test
    void testWatching()
    {
        List<TraktUser> users = TRAKT.getShows()
                                     .getWatchingUsers("tt2193021", null);
        
        Assertions.assertNotNull(users, "users are null");
    }
    
    @Test
    void testNextEpisode()
    {
        TraktEpisode nextEpisode = TRAKT.getShows()
                                        .getNextEpisode("tt2193021", null);
        
        Assertions.assertNotNull(nextEpisode, "next episode is null");
    }
    
    @Test
    void testLastEpisode()
    {
    
        TraktEpisode lastEpisode = TRAKT.getShows()
                                        .getLastEpisode("tt2193021", null);
        
        Assertions.assertNotNull(lastEpisode, "last episode is null");
    }
}
