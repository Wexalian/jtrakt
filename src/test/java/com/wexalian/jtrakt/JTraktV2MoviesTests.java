package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.*;
import com.wexalian.jtrakt.endpoint.comments.TraktComment;
import com.wexalian.jtrakt.endpoint.lists.TraktList;
import com.wexalian.jtrakt.endpoint.movies.*;
import com.wexalian.jtrakt.endpoint.users.TraktUser;
import com.wexalian.jtrakt.http.query.Extended;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Tag("movies")
public class JTraktV2MoviesTests extends JTraktV2Tests {
    
    @Test
    public void testTrending() {
        List<TraktTrendingMovie> trendingMovies = TRAKT.getMoviesEndpoint().getTrending(null, Extended.FULL);
        
        Assertions.assertNotNull(trendingMovies, "trending movies are null");
    }
    
    @Test
    public void testPopular() {
        List<TraktMovie> popularMovies = TRAKT.getMoviesEndpoint().getPopular(null, Extended.FULL);
        
        Assertions.assertNotNull(popularMovies, "popular movies are null");
    }
    
    @Test
    public void testMostPlayed() {
        List<TraktWatchedMovie> mostPlayedMovies = TRAKT.getMoviesEndpoint()
                                                        .getMostPlayed(TraktTimePeriod.ALL, null, Extended.FULL);
    
        Assertions.assertNotNull(mostPlayedMovies, "most played movies are null");
    }
    
    @Test
    public void testMostWatched() {
        List<TraktWatchedMovie> mostWatchedMovies = TRAKT.getMoviesEndpoint()
                                                         .getMostWatched(TraktTimePeriod.ALL, null, Extended.FULL);
    
        Assertions.assertNotNull(mostWatchedMovies, "most watched movies are null");
    }
    
    @Test
    public void testMostCollected() {
        List<TraktWatchedMovie> mostCollectedMovies = TRAKT.getMoviesEndpoint()
                                                           .getMostCollected(TraktTimePeriod.ALL, null, Extended.FULL);
    
        Assertions.assertNotNull(mostCollectedMovies, "most collected movies are null");
    }
    
    @Test
    public void testMostAnticipated() {
        List<TraktListedMovie> mostAnticipatedMovies = TRAKT.getMoviesEndpoint()
                                                            .getMostAnticipated(null, Extended.FULL);
    
        Assertions.assertNotNull(mostAnticipatedMovies, "most anticipated movies are null");
    }
    
    @Test
    public void testBoxOffice() {
        List<TraktBoxOfficeMovie> boxOfficeMovies = TRAKT.getMoviesEndpoint().getBoxOffice(null);
        
        Assertions.assertNotNull(boxOfficeMovies, "box office movies are null");
    }
    
    @Test
    public void testUpdates() {
        List<TraktUpdatedMovie> movieUpdates = TRAKT.getMoviesEndpoint()
                                                    .getUpdates(OffsetDateTime.now()
                                                                              .minus(7, ChronoUnit.DAYS), null, null);
    
        Assertions.assertNotNull(movieUpdates, "box office movies are null");
    }
    
    @Test
    public void testSummary() {
        TraktMovie movie = TRAKT.getMoviesEndpoint().getSummary(MOVIE.getIds().getSlug(), Extended.FULL);
        
        Assertions.assertNotNull(movie, "movie is null");
    }
    
    @Test
    public void testAliases() {
        List<TraktAlias> aliases = TRAKT.getMoviesEndpoint().getAliases(MOVIE.getIds().getSlug(), null);
        
        Assertions.assertNotNull(aliases, "aliases are null");
    }
    
    @Test
    public void testReleases() {
        List<TraktMovieRelease> releases = TRAKT.getMoviesEndpoint().getReleases(MOVIE.getIds().getSlug(), null);
    
        Assertions.assertNotNull(releases, "movie releases are null");
    }
    
    @Test
    public void testTranslations() {
        List<TraktTranslation> translations = TRAKT.getMoviesEndpoint().getTranslations(MOVIE.getIds().getSlug(), null);
    
        Assertions.assertNotNull(translations, "movie translations are null");
    }
    
    @Test
    public void testComments() {
        List<TraktComment> comments = TRAKT.getMoviesEndpoint().getComments(MOVIE.getIds().getSlug(), null, null);
    
        Assertions.assertTrue(true, "Testing comments is disabled, 521 origin down error");
        // Assertions.assertNotNull(comments, "movie comments are null");
    }
    
    @Test
    public void testLists() {
        List<TraktList> lists = TRAKT.getMoviesEndpoint()
                                     .getLists(MOVIE.getIds().getSlug(), TraktList.Type.ALL, null, null);
    
        Assertions.assertNotNull(lists, "lists are null");
    }
    
    @Test
    public void testPeople() {
        TraktMovieCast movieCast = TRAKT.getMoviesEndpoint().getPeople(MOVIE.getIds().getSlug(), null);
        
        Assertions.assertNotNull(movieCast, "movie cast is null");
    }
    
    @Test
    public void testRatings() {
        TraktRatings ratings = TRAKT.getMoviesEndpoint().getRatings(MOVIE.getIds().getSlug());
        
        Assertions.assertNotNull(ratings, "ratings are null");
    }
    
    @Test
    public void testRelated() {
        List<TraktMovie> related = TRAKT.getMoviesEndpoint().getRelated(MOVIE.getIds().getSlug(), null, null);
        
        Assertions.assertNotNull(related, "related movies are null");
    }
    
    @Test
    public void testStats() {
        TraktStats stats = TRAKT.getMoviesEndpoint().getStats(MOVIE.getIds().getSlug());
        
        Assertions.assertNotNull(stats);
    }
    
    @Test
    public void testWatchingUsers() {
        List<TraktUser> watchingUsers = TRAKT.getMoviesEndpoint().getWatchingUsers(MOVIE.getIds().getSlug(), null);
    
        Assertions.assertNotNull(watchingUsers, "watching users are null");
    }
}
