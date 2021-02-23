package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktRatings;
import com.wexalian.jtrakt.endpoint.TraktStats;
import com.wexalian.jtrakt.endpoint.TraktTranslation;
import com.wexalian.jtrakt.endpoint.comments.TraktComment;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisodeCast;
import com.wexalian.jtrakt.endpoint.lists.TraktList;
import com.wexalian.jtrakt.endpoint.users.TraktUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

@Tag("episodes")
public class JTraktV2EpisodesTests extends JTraktV2Tests {
    
    @Test
    public void testEpisode() {
        TraktEpisode episode = TRAKT.getEpisodesEndpoint().getEpisode("arrow", 1, 1, null);
        
        Assertions.assertNotNull(episode, "episode is null");
    }
    
    @Test
    public void testTranslations() {
        List<TraktTranslation> translations = TRAKT.getEpisodesEndpoint().getTranslations("arrow", 1, 1, null);
        
        Assertions.assertNotNull(translations, "translations are null");
    }
    
    @Test
    public void testComments() {
        List<TraktComment> comments = TRAKT.getEpisodesEndpoint().getComments("arrow", 1, 1, null, null);
        
        Assertions.assertNotNull(comments, "comments are null");
    }
    
    @Test
    public void testLists() {
        List<TraktList> lists = TRAKT.getEpisodesEndpoint().getLists("arrow", 1, 1, null, null, null);
        
        Assertions.assertNotNull(lists, "lists are null");
    }
    
    @Test
    public void testPeople() {
        TraktEpisodeCast cast = TRAKT.getEpisodesEndpoint().getPeople("arrow", 1, 1, null);
        
        Assertions.assertNotNull(cast, "cast is null");
    }
    
    @Test
    public void testRatings() {
        TraktRatings ratings = TRAKT.getEpisodesEndpoint().getRatings("arrow", 1, 1);
        
        Assertions.assertNotNull(ratings, "ratings are null");
    }
    
    @Test
    public void testStats() {
        TraktStats stats = TRAKT.getEpisodesEndpoint().getStats("arrow", 1, 1);
        
        Assertions.assertNotNull(stats, "stats are null");
    }
    
    @Test
    public void testWatching() {
        List<TraktUser> users = TRAKT.getEpisodesEndpoint().getWatching("arrow", 1, 1);
        
        Assertions.assertNotNull(users, "users are null");
    }
}
