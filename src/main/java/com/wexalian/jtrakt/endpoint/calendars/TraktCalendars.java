package com.wexalian.jtrakt.endpoint.calendars;

import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.jtrakt.media.calender.TraktCalenderEpisode;

import javax.annotation.Nonnull;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TraktCalendars
{
    /*
    TODO my shows
    TODO my new shows
    TODO my season premieres
    TODO my movies
    TODO my dvd
    TODO all shows
    TODO all new shows
    TODO all season premieres
    TODO all movies
    TODO all dvd
     */
    
    private final TraktHTTP http;
    
    public TraktCalendars(TraktHTTP http)
    {
        this.http = http;
    }
    
    public List<TraktCalenderEpisode> getMyShows(@Nonnull OffsetDateTime date, int days, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("calendars/my/shows/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_DATE))
                                     .path("days", 7);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDER_EPISODE, token);
    }
}
