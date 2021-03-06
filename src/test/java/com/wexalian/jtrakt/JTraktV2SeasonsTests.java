package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktRatings;
import com.wexalian.jtrakt.endpoint.TraktStats;
import com.wexalian.jtrakt.endpoint.comments.TraktComment;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.lists.TraktList;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeason;
import com.wexalian.jtrakt.endpoint.shows.TraktShowCast;
import com.wexalian.jtrakt.endpoint.users.TraktUser;
import com.wexalian.jtrakt.http.query.Extended;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

@Tag("seasons")
public class JTraktV2SeasonsTests extends JTraktV2Tests {
    
    @Test
    public void testSummary() {
        List<TraktSeason> seasons = TRAKT.getSeasonsEndpoint().getSummary("arrow", Extended.FULL_EPISODES);
        
        Assertions.assertNotNull(seasons, "seasons are null");
        Assertions.assertTrue(seasons.size() > 0, "seasons size is 0");
    }
    
    @Test
    public void testEpisodes() {
        List<TraktEpisode> episodes = TRAKT.getSeasonsEndpoint().getEpisodes(SHOW.getIds().getImdbId(), 1, null, null);
        
        Assertions.assertNotNull(episodes, "episodes are null");
        Assertions.assertTrue(episodes.size() > 0, "episodes size is 0");
    }
    
    @Test
    public void testComments() {
        List<TraktComment> comments = TRAKT.getSeasonsEndpoint().getComments("arrow", 1, null, null);
        
        Assertions.assertNotNull(comments, "comments are null");
    }
    
    @Test
    public void testLists() {
        List<TraktList> lists = TRAKT.getSeasonsEndpoint().getLists("arrow", 1, null, null, null);
        
        Assertions.assertNotNull(lists, "lists are null");
    }
    
    @Test
    public void testPeople() {
        TraktShowCast cast = TRAKT.getSeasonsEndpoint().getPeople("arrow", 1, null);
        
        Assertions.assertNotNull(cast, "cast is null");
    }
    
    @Test
    public void testRatings() {
        TraktRatings ratings = TRAKT.getSeasonsEndpoint().getRatings("arrow", 1);
        
        Assertions.assertNotNull(ratings, "ratings are null");
    }
    
    @Test
    public void testStats() {
        TraktStats stats = TRAKT.getSeasonsEndpoint().getStats("arrow", 1);
        
        Assertions.assertNotNull(stats, "stats are null");
    }
    
    @Test
    public void testWatching() {
        List<TraktUser> users = TRAKT.getSeasonsEndpoint().getWatching("arrow", 1);
        
        Assertions.assertNotNull(users, "users are null");
    }
    
}