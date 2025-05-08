package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.calendars.TraktCalendarEpisode;
import com.wexalian.jtrakt.endpoint.calendars.TraktCalendarMovie;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Tag("calendars")
public class JTraktV2CalendarTests extends JTraktV2Tests {
    
    @Test
    public void testMyShows() {
        List<TraktCalendarEpisode> myShows = TRAKT.getCalendersEndpoint()
                                                  .getMyShows(LocalDate.now(), 7, ACCESS_TOKEN, null);
        
        assertNotNull(myShows, "my calendar shows are null");
        if (!myShows.isEmpty()) {
            assertNotNull(myShows.get(0).getEpisode(), "calendar show contains null episode");
            assertNotNull(myShows.get(0).getShow(), "calendar show contains null show");
        }
    }
    
    @Test
    public void testMyNewShows() {
        List<TraktCalendarEpisode> myNewShows = TRAKT.getCalendersEndpoint()
                                                     .getMyNewShows(LocalDate.now(), 7, ACCESS_TOKEN, null);
        
        assertNotNull(myNewShows, "my new calendar shows are null");
        if (!myNewShows.isEmpty()) {
            assertNotNull(myNewShows.get(0).getEpisode(), "new calendar show contains null episode");
            assertNotNull(myNewShows.get(0).getShow(), "new calendar show contains null show");
        }
    }
    
    @Test
    public void testMySeasonPremieres() {
        List<TraktCalendarEpisode> mySeasonPremieres = TRAKT.getCalendersEndpoint()
                                                            .getMySeasonPremieres(LocalDate.now(),
                                                                                  7,
                                                                                  ACCESS_TOKEN,
                                                                                  null);
        
        assertNotNull(mySeasonPremieres, "my season premieres are null");
        if (!mySeasonPremieres.isEmpty()) {
            assertNotNull(mySeasonPremieres.get(0).getEpisode(), "season premiere contains null episode");
            assertNotNull(mySeasonPremieres.get(0).getShow(), "season premiere contains null show");
        }
    }
    
    @Test
    public void testMyFinales() {
        List<TraktCalendarEpisode> myShows = TRAKT.getCalendersEndpoint()
                                                  .getMyFinales(LocalDate.of(2013, 5, 12), 7, ACCESS_TOKEN, null);
        
        assertNotNull(myShows, "my calendar shows are null");
        if (!myShows.isEmpty()) {
            assertNotNull(myShows.get(0).getEpisode(), "calendar show contains null episode");
            assertNotNull(myShows.get(0).getShow(), "calendar show contains null show");
        }
    }
    
    @Test
    public void testMyMovies() {
        List<TraktCalendarMovie> myMovies = TRAKT.getCalendersEndpoint()
                                                 .getMyMovies(LocalDate.now(), 7, ACCESS_TOKEN, null);
        
        assertNotNull(myMovies, "my movies are null");
        if (!myMovies.isEmpty()) {
            assertNotNull(myMovies.get(0).getMovie(), "calendar movie contains null movie");
        }
    }
    
    @Test
    public void testMyDvd() {
        List<TraktCalendarMovie> myDvds = TRAKT.getCalendersEndpoint().getMyDvd(LocalDate.now(), 7, ACCESS_TOKEN, null);
        
        assertNotNull(myDvds, "my dvds are null");
        if (!myDvds.isEmpty()) {
            assertNotNull(myDvds.get(0).getMovie(), "calendar movie contains null movie");
        }
    }
    
    @Test
    public void testAllShows() {
        List<TraktCalendarEpisode> allShows = TRAKT.getCalendersEndpoint().getAllShows(LocalDate.now(), 7, null);
        
        assertNotNull(allShows, "all calendar shows are null");
        if (!allShows.isEmpty()) {
            assertNotNull(allShows.get(0).getEpisode(), "calendar show contains null episode");
            assertNotNull(allShows.get(0).getShow(), "calendar show contains null show");
        }
    }
    
    @Test
    public void testAllNewShows() {
        List<TraktCalendarEpisode> allNewShows = TRAKT.getCalendersEndpoint().getAllNewShows(LocalDate.now(), 7, null);
        
        assertNotNull(allNewShows, "all new calendar shows are null");
        if (!allNewShows.isEmpty()) {
            assertNotNull(allNewShows.get(0).getEpisode(), "new calendar show contains null episode");
            assertNotNull(allNewShows.get(0).getShow(), "new calendar show contains null show");
        }
    }
    
    @Test
    public void testAllSeasonPremieres() {
        List<TraktCalendarEpisode> allSeasonPremieres = TRAKT.getCalendersEndpoint()
                                                             .getAllSeasonPremieres(LocalDate.now(), 7, null);
        
        assertNotNull(allSeasonPremieres, "all season premieres are null");
        if (!allSeasonPremieres.isEmpty()) {
            assertNotNull(allSeasonPremieres.get(0).getEpisode(), "season premiere contains null episode");
            assertNotNull(allSeasonPremieres.get(0).getShow(), "season premiere contains null show");
        }
    }
    
    @Test
    public void testAlFinales() {
        List<TraktCalendarEpisode> allShows = TRAKT.getCalendersEndpoint().getAllFinales(LocalDate.now(), 7, null);
        
        assertNotNull(allShows, "all calendar shows are null");
        if (!allShows.isEmpty()) {
            assertNotNull(allShows.get(0).getEpisode(), "calendar show contains null episode");
            assertNotNull(allShows.get(0).getShow(), "calendar show contains null show");
        }
    }
    
    @Test
    public void testAllMovies() {
        List<TraktCalendarMovie> allMovies = TRAKT.getCalendersEndpoint().getAllMovies(LocalDate.now(), 7, null);
        
        assertNotNull(allMovies, "all movies are null");
        if (!allMovies.isEmpty()) {
            assertNotNull(allMovies.get(0).getMovie(), "calendar movie contains null movie");
        }
    }
    
    @Test
    public void testAllDvd() {
        List<TraktCalendarMovie> allDvds = TRAKT.getCalendersEndpoint().getAllDvd(LocalDate.now(), 7, null);
        
        assertNotNull(allDvds, "all dvds are null");
        if (!allDvds.isEmpty()) {
            assertNotNull(allDvds.get(0).getMovie(), "calendar movie contains null movie");
        }
    }
    
}
