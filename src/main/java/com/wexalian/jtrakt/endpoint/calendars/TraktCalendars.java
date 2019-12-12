package com.wexalian.jtrakt.endpoint.calendars;

import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Filter;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.jtrakt.media.calender.TraktCalendarEpisode;
import com.wexalian.jtrakt.media.calender.TraktCalendarMovie;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
    
    public List<TraktCalendarEpisode> getMyShows(@Nonnull OffsetDateTime date, int days, @Nonnull TraktAccessToken token, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("calendars/my/shows/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .extended(extended)
                                     .filter(filters);
    
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES, token);
    }
    
    public List<TraktCalendarEpisode> getMyNewShows(@Nonnull OffsetDateTime date, int days, @Nonnull TraktAccessToken token, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("calendars/my/shows/new/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .extended(extended)
                                     .filter(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES, token);
    }
    
    public List<TraktCalendarEpisode> getMySeasonPremieres(@Nonnull OffsetDateTime date, int days, @Nonnull TraktAccessToken token, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("calendars/my/shows/premieres/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .extended(extended)
                                     .filter(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES, token);
    }
    
    public List<TraktCalendarMovie> getMyMovies(@Nonnull OffsetDateTime date, int days, @Nonnull TraktAccessToken token, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("calendars/my/movies/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .extended(extended)
                                     .filter(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_MOVIES, token);
    }
    
    public List<TraktCalendarEpisode> getMyDvd(@Nonnull OffsetDateTime date, int days, @Nonnull TraktAccessToken token, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("calendars/my/dvd/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .extended(extended)
                                     .filter(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES, token);
    }
    
    public List<TraktCalendarEpisode> getAllShows(@Nonnull OffsetDateTime date, int days, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("calendars/all/shows/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .extended(extended)
                                     .filter(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES);
    }
    
    public List<TraktCalendarEpisode> getAllNewShows(@Nonnull OffsetDateTime date, int days, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("calendars/all/shows/new/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .extended(extended)
                                     .filter(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES);
    }
    
    public List<TraktCalendarEpisode> getAllSeasonPremieres(@Nonnull OffsetDateTime date, int days, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("calendars/all/shows/premieres/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .extended(extended)
                                     .filter(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES);
    }
    
    public List<TraktCalendarMovie> getAllMovies(@Nonnull OffsetDateTime date, int days, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("calendars/all/movies/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .extended(extended)
                                     .filter(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_MOVIES);
    }
    
    public List<TraktCalendarEpisode> getAllDvd(@Nonnull OffsetDateTime date, int days, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("calendars/all/dvd/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .extended(extended)
                                     .filter(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES);
    }
}
