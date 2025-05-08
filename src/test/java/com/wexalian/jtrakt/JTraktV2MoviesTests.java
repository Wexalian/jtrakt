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
import java.util.List;

@Tag("movies")
public class JTraktV2MoviesTests extends JTraktV2Tests {
    
    @Test
    public void testTrending() {
        List<TraktTrendingMovie> trendingMovies = TRAKT.getMoviesEndpoint().getTrending(null, Extended.FULL);
        
        notNull(trendingMovies, "trending movies are null");
    }
    
    @Test
    public void testPopular() {
        List<TraktMovie> popularMovies = TRAKT.getMoviesEndpoint().getPopular(null, Extended.FULL);
        
        notNull(popularMovies, "popular movies are null");
    }
    
    @Test
    public void testMostFavorited() {
        List<TraktFavoritedMovie> popularMovies = TRAKT.getMoviesEndpoint()
                                                       .getMostFavorited(TraktPeriod.ALL, null, Extended.FULL);
        
        notNull(popularMovies, "most favorited movies are null");
    }
    
    @Test
    public void testMostPlayed() {
        List<TraktWatchedMovie> mostPlayedMovies = TRAKT.getMoviesEndpoint()
                                                        .getMostPlayed(TraktPeriod.ALL, null, Extended.FULL);
        
        notNull(mostPlayedMovies, "most played movies are null");
    }
    
    @Test
    public void testMostWatched() {
        List<TraktWatchedMovie> mostWatchedMovies = TRAKT.getMoviesEndpoint()
                                                         .getMostWatched(TraktPeriod.ALL, null, Extended.FULL);
        
        notNull(mostWatchedMovies, "most watched movies are null");
    }
    
    @Test
    public void testMostCollected() {
        List<TraktWatchedMovie> mostCollectedMovies = TRAKT.getMoviesEndpoint()
                                                           .getMostCollected(TraktPeriod.ALL, null, Extended.FULL);
        
        notNull(mostCollectedMovies, "most collected movies are null");
    }
    
    @Test
    public void testMostAnticipated() {
        List<TraktListedMovie> mostAnticipatedMovies = TRAKT.getMoviesEndpoint()
                                                            .getMostAnticipated(null, Extended.FULL);
        
        notNull(mostAnticipatedMovies, "most anticipated movies are null");
    }
    
    @Test
    public void testBoxOffice() {
        List<TraktBoxOfficeMovie> boxOfficeMovies = TRAKT.getMoviesEndpoint().getBoxOffice(null);
        
        notNull(boxOfficeMovies, "box office movies are null");
    }
    
    @Test
    public void testUpdates() {
        List<TraktUpdatedMovie> movieUpdates = TRAKT.getMoviesEndpoint()
                                                    .getUpdates(OffsetDateTime.now().minusDays(7), null, null);
        
        notNull(movieUpdates, "box office movies are null");
    }
    
    @Test
    public void testSummary() {
        TraktMovie movie = TRAKT.getMoviesEndpoint().getSummary(MOVIE.getIds().getSlug(), Extended.FULL);
        
        notNull(movie, "movie is null");
    }
    
    @Test
    public void testAliases() {
        List<TraktAlias> aliases = TRAKT.getMoviesEndpoint().getAliases(MOVIE.getIds().getSlug(), null);
        
        notNull(aliases, "aliases are null");
    }
    
    @Test
    public void testReleases() {
        List<TraktMovieRelease> releases = TRAKT.getMoviesEndpoint().getReleases(MOVIE.getIds().getSlug(), null);
        
        notNull(releases, "movie releases are null");
    }
    
    @Test
    public void testTranslations() {
        List<TraktTranslation> translations = TRAKT.getMoviesEndpoint().getTranslations(MOVIE.getIds().getSlug(), null);
        
        notNull(translations, "movie translations are null");
    }
    
    @Test
    public void testComments() {
        List<TraktComment> comments = TRAKT.getMoviesEndpoint().getComments(MOVIE.getIds().getSlug(), null, null);
        
        Assertions.assertTrue(true, "Testing comments is disabled, 521 origin down error");
        // notNull(comments, "movie comments are null");
    }
    
    @Test
    public void testLists() {
        List<TraktList> lists = TRAKT.getMoviesEndpoint()
                                     .getLists(MOVIE.getIds().getSlug(), TraktList.Type.ALL, null, null);
        
        notNull(lists, "lists are null");
    }
    
    @Test
    public void testPeople() {
        TraktMovieCast movieCast = TRAKT.getMoviesEndpoint().getPeople(MOVIE.getIds().getSlug(), null);
        
        notNull(movieCast, "movie cast is null");
    }
    
    @Test
    public void testRatings() {
        TraktRatings ratings = TRAKT.getMoviesEndpoint().getRatings(MOVIE.getIds().getSlug());
        
        notNull(ratings, "ratings are null");
    }
    
    @Test
    public void testRelated() {
        List<TraktMovie> related = TRAKT.getMoviesEndpoint().getRelated(MOVIE.getIds().getSlug(), null, null);
        
        notNull(related, "related movies are null");
    }
    
    @Test
    public void testStats() {
        TraktStats stats = TRAKT.getMoviesEndpoint().getStats(MOVIE.getIds().getSlug());
        
        notNull(stats, "stats are null");
    }
    
    @Test
    public void testStudios() {
        List<TraktStudio> studios = TRAKT.getMoviesEndpoint().getStudios(MOVIE.getIds().getSlug());
        
        notNull(studios, "studios are null");
    }
    
    @Test
    public void testWatchingUsers() {
        List<TraktUser> watchingUsers = TRAKT.getMoviesEndpoint().getWatchingUsers(MOVIE.getIds().getSlug(), null);
        
        notNull(watchingUsers, "watching users are null");
    }
    
    @Test
    public void testVideos() {
        List<TraktVideo> studios = TRAKT.getMoviesEndpoint().getVideos(MOVIE.getIds().getSlug(), null);
        
        notNull(studios, "videos are null");
    }
}
