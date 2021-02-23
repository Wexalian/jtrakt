package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.calendars.TraktCalendarEpisode;
import com.wexalian.jtrakt.endpoint.calendars.TraktCalendarMovie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.List;

@Tag("calendars")
public class JTraktV2CalendarTests extends JTraktV2Tests {
    
    @Test
    public void testMyShows() {
        List<TraktCalendarEpisode> myShows = TRAKT.getCalendersEndpoint()
                                                  .getMyShows(OffsetDateTime.now(), 7, ACCESS_TOKEN, null);
    
        Assertions.assertNotNull(myShows, "my calendar shows are null");
        if (myShows.size() > 0) {
            Assertions.assertNotNull(myShows.get(0).getEpisode(), "calendar show contains null episode");
            Assertions.assertNotNull(myShows.get(0).getShow(), "calendar show contains null show");
        }
    }
    
    @Test
    public void testMyNewShows() {
        List<TraktCalendarEpisode> myNewShows = TRAKT.getCalendersEndpoint()
                                                     .getMyNewShows(OffsetDateTime.now(), 7, ACCESS_TOKEN, null);
    
        Assertions.assertNotNull(myNewShows, "my new calendar shows are null");
        if (myNewShows.size() > 0) {
            Assertions.assertNotNull(myNewShows.get(0).getEpisode(), "new calendar show contains null episode");
            Assertions.assertNotNull(myNewShows.get(0).getShow(), "new calendar show contains null show");
        }
    }
    
    @Test
    public void testMySeasonPremieres() {
        List<TraktCalendarEpisode> mySeasonPremieres = TRAKT.getCalendersEndpoint()
                                                            .getMySeasonPremieres(OffsetDateTime.now(), 7, ACCESS_TOKEN, null);
    
        Assertions.assertNotNull(mySeasonPremieres, "my season premieres are null");
        if (mySeasonPremieres.size() > 0) {
            Assertions.assertNotNull(mySeasonPremieres.get(0).getEpisode(), "season premiere contains null episode");
            Assertions.assertNotNull(mySeasonPremieres.get(0).getShow(), "season premiere contains null show");
        }
    }
    
    @Test
    public void testMyMovies() {
        List<TraktCalendarMovie> myMovies = TRAKT.getCalendersEndpoint()
                                                 .getMyMovies(OffsetDateTime.now(), 7, ACCESS_TOKEN, null);
    
        Assertions.assertNotNull(myMovies, "my movies are null");
        if (myMovies.size() > 0) {
            Assertions.assertNotNull(myMovies.get(0).getMovie(), "calendar movie contains null movie");
        }
    }
    
    @Test
    public void testMyDvd() {
        List<TraktCalendarMovie> myDvds = TRAKT.getCalendersEndpoint()
                                               .getMyDvd(OffsetDateTime.now(), 7, ACCESS_TOKEN, null);
    
        Assertions.assertNotNull(myDvds, "my dvds are null");
        if (myDvds.size() > 0) {
            Assertions.assertNotNull(myDvds.get(0).getMovie(), "calendar movie contains null movie");
        }
    }
    
    @Test
    public void testAllShows() {
        List<TraktCalendarEpisode> allShows = TRAKT.getCalendersEndpoint().getAllShows(OffsetDateTime.now(), 7, null);
    
        Assertions.assertNotNull(allShows, "all calendar shows are null");
        if (allShows.size() > 0) {
            Assertions.assertNotNull(allShows.get(0).getEpisode(), "calendar show contains null episode");
            Assertions.assertNotNull(allShows.get(0).getShow(), "calendar show contains null show");
        }
    }
    
    @Test
    public void testAllNewShows() {
        List<TraktCalendarEpisode> allNewShows = TRAKT.getCalendersEndpoint()
                                                      .getAllNewShows(OffsetDateTime.now(), 7, null);
    
        Assertions.assertNotNull(allNewShows, "all new calendar shows are null");
        if (allNewShows.size() > 0) {
            Assertions.assertNotNull(allNewShows.get(0).getEpisode(), "new calendar show contains null episode");
            Assertions.assertNotNull(allNewShows.get(0).getShow(), "new calendar show contains null show");
        }
    }
    
    @Test
    public void testAllSeasonPremieres() {
        List<TraktCalendarEpisode> allSeasonPremieres = TRAKT.getCalendersEndpoint()
                                                             .getAllSeasonPremieres(OffsetDateTime.now(), 7, null);
    
        Assertions.assertNotNull(allSeasonPremieres, "all season premieres are null");
        if (allSeasonPremieres.size() > 0) {
            Assertions.assertNotNull(allSeasonPremieres.get(0).getEpisode(), "season premiere contains null episode");
            Assertions.assertNotNull(allSeasonPremieres.get(0).getShow(), "season premiere contains null show");
        }
    }
    
    @Test
    public void testAllMovies() {
        List<TraktCalendarMovie> allMovies = TRAKT.getCalendersEndpoint().getAllMovies(OffsetDateTime.now(), 7, null);
    
        Assertions.assertNotNull(allMovies, "all movies are null");
        if (allMovies.size() > 0) {
            Assertions.assertNotNull(allMovies.get(0).getMovie(), "calendar movie contains null movie");
        }
    }
    
    @Test
    public void testAllDvd() {
        List<TraktCalendarMovie> allDvds = TRAKT.getCalendersEndpoint().getAllDvd(OffsetDateTime.now(), 7, null);
        
        Assertions.assertNotNull(allDvds, "all dvds are null");
        if (allDvds.size() > 0) {
            Assertions.assertNotNull(allDvds.get(0).getMovie(), "calendar movie contains null movie");
        }
    }
    
}
