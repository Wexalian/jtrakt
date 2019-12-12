package com.wexalian.jtrakt;

import com.wexalian.jtrakt.media.calender.TraktCalenderEpisode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.List;

class JTraktV2CalendarTests extends JTraktV2Tests
{
    
    @Test
    void testCalenderEpisodes()
    {
        List<TraktCalenderEpisode> calenderEpisodes = TRAKT.getCalenders()
                                                           .getMyShows(OffsetDateTime.now(), 7, ACCESS_TOKEN);
        
        Assertions.assertNotNull(calenderEpisodes, "calender episodes are null");
        Assertions.assertFalse(calenderEpisodes.isEmpty(), "calender episodes are empty");
    }
}