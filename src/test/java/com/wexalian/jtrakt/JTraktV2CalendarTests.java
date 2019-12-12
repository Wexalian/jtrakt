package com.wexalian.jtrakt;

import com.wexalian.jtrakt.media.calender.TraktCalendarEpisode;
import com.wexalian.jtrakt.media.calender.TraktCalendarMovie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.List;

class JTraktV2CalendarTests extends JTraktV2Tests
{
    
    @Test
    void testMyShows()
    {
        List<TraktCalendarEpisode> myShows = TRAKT.getCalenders()
                                                  .getMyShows(OffsetDateTime.now(), 7, ACCESS_TOKEN, null);
    
        Assertions.assertNotNull(myShows, "my shows are null");
    }
    
    @Test
    void testMyNewShows()
    {
        List<TraktCalendarEpisode> myNewShows = TRAKT.getCalenders()
                                                     .getMyNewShows(OffsetDateTime.now(), 7, ACCESS_TOKEN, null);
        
        Assertions.assertNotNull(myNewShows, "my new shows are null");
    }
    
    @Test
    void testMySeasonPremieres()
    {
        List<TraktCalendarEpisode> mySeasonPremieres = TRAKT.getCalenders()
                                                            .getMySeasonPremieres(OffsetDateTime.now(), 7, ACCESS_TOKEN, null);
        
        Assertions.assertNotNull(mySeasonPremieres, "season premieres are null");
    }
    
    @Test
    void testMyMovies()
    {
        List<TraktCalendarMovie> myMovies = TRAKT.getCalenders()
                                                 .getMyMovies(OffsetDateTime.now(), 7, ACCESS_TOKEN, null);
        
        Assertions.assertNotNull(myMovies, "my movies are null");
    }
    
    @Test
    void testMyDvd()
    {
        List<TraktCalendarEpisode> calenderEpisodes = TRAKT.getCalenders()
                                                           .getMyDvd(OffsetDateTime.now(), 7, ACCESS_TOKEN, null);
        
        Assertions.assertNotNull(calenderEpisodes, "my dvds are null");
    }
    
    @Test
    void testAllShows()
    {
        List<TraktCalendarEpisode> allShows = TRAKT.getCalenders()
                                                   .getAllShows(OffsetDateTime.now(), 7, null);
        
        Assertions.assertNotNull(allShows, "all shows are null");
    }
    
    @Test
    void testAllNewShows()
    {
        List<TraktCalendarEpisode> allNewShows = TRAKT.getCalenders()
                                                      .getAllNewShows(OffsetDateTime.now(), 7, null);
        
        Assertions.assertNotNull(allNewShows, "all new shows are null");
    }
    
    @Test
    void testAllSeasonPremieres()
    {
        List<TraktCalendarEpisode> allSeasonPremieres = TRAKT.getCalenders()
                                                             .getAllSeasonPremieres(OffsetDateTime.now(), 7, null);
        
        Assertions.assertNotNull(allSeasonPremieres, "season premieres are null");
    }
    
    @Test
    void testAllMovies()
    {
        List<TraktCalendarMovie> allMovies = TRAKT.getCalenders()
                                                  .getAllMovies(OffsetDateTime.now(), 7, null);
        
        Assertions.assertNotNull(allMovies, "all movies are null");
    }
    
    @Test
    void testAllDvd()
    {
        List<TraktCalendarEpisode> calenderEpisodes = TRAKT.getCalenders()
                                                           .getAllDvd(OffsetDateTime.now(), 7, null);
        
        Assertions.assertNotNull(calenderEpisodes, "all dvds are null");
    }
}