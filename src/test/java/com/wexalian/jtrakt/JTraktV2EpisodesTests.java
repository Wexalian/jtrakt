package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktRatings;
import com.wexalian.jtrakt.endpoint.TraktStats;
import com.wexalian.jtrakt.endpoint.TraktTranslation;
import com.wexalian.jtrakt.endpoint.comments.TraktComment;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisodeCast;
import com.wexalian.jtrakt.endpoint.lists.TraktList;
import com.wexalian.jtrakt.endpoint.users.TraktUser;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

@Tag("episodes")
public class JTraktV2EpisodesTests extends JTraktV2Tests {
    
    public static final String SHOW_ID = "arrow";
    public static final int SEASON_NUM = 1;
    public static final int EPISODE_NUM = 1;
    
    @Test
    public void testEpisode() {
        TraktEpisode episode = TRAKT.getEpisodesEndpoint().getEpisode(SHOW_ID, SEASON_NUM, EPISODE_NUM, null);
        
        notNull(episode, "episode is null");
    }
    
    @Test
    public void testTranslations() {
        List<TraktTranslation> translations = TRAKT.getEpisodesEndpoint()
                                                   .getTranslations(SHOW_ID, SEASON_NUM, EPISODE_NUM, null);
        
        notNull(translations, "translations are null");
    }
    
    @Test
    public void testComments() {
        List<TraktComment> comments = TRAKT.getEpisodesEndpoint()
                                           .getComments(SHOW_ID, SEASON_NUM, EPISODE_NUM, null, null);
        
        notNull(comments, "comments are null");
    }
    
    @Test
    public void testLists() {
        List<TraktList> lists = TRAKT.getEpisodesEndpoint()
                                     .getLists(SHOW_ID, SEASON_NUM, EPISODE_NUM, null, null, null);
        
        notNull(lists, "lists are null");
    }
    
    @Test
    public void testPeople() {
        TraktEpisodeCast cast = TRAKT.getEpisodesEndpoint().getPeople(SHOW_ID, SEASON_NUM, EPISODE_NUM, null);
        
        notNull(cast, "cast is null");
    }
    
    @Test
    public void testRatings() {
        TraktRatings ratings = TRAKT.getEpisodesEndpoint().getRatings(SHOW_ID, SEASON_NUM, EPISODE_NUM);
        
        notNull(ratings, "ratings are null");
    }
    
    @Test
    public void testStats() {
        TraktStats stats = TRAKT.getEpisodesEndpoint().getStats(SHOW_ID, SEASON_NUM, EPISODE_NUM);
        
        notNull(stats, "stats are null");
    }
    
    @Test
    public void testWatching() {
        List<TraktUser> users = TRAKT.getEpisodesEndpoint().getWatching(SHOW_ID, SEASON_NUM, EPISODE_NUM);
        
        notNull(users, "users are null");
    }
}
