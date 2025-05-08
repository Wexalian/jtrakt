package com.wexalian.jtrakt.endpoint.calendars;

import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Filter;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.nullability.annotations.Nonnull;
import com.wexalian.nullability.annotations.Nullable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TraktCalendarsEndpoint {
    private final TraktHTTP http;
    
    public TraktCalendarsEndpoint(TraktHTTP http) {
        this.http = http;
    }
    
    public List<TraktCalendarEpisode> getMyShows(@Nonnull LocalDate date, int days, @Nonnull TraktAccessToken token, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("calendars/my/shows/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES, token);
    }
    
    public List<TraktCalendarEpisode> getMyNewShows(@Nonnull LocalDate date, int days, @Nonnull TraktAccessToken token, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("calendars/my/shows/new/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES, token);
    }
    
    public List<TraktCalendarEpisode> getMySeasonPremieres(@Nonnull LocalDate date, int days, @Nonnull TraktAccessToken token, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("calendars/my/shows/premieres/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES, token);
    }
    
    public List<TraktCalendarEpisode> getMyFinales(@Nonnull LocalDate date, int days, @Nonnull TraktAccessToken token, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("calendars/my/shows/finales/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES, token);
    }
    
    public List<TraktCalendarMovie> getMyMovies(@Nonnull LocalDate date, int days, @Nonnull TraktAccessToken token, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("calendars/my/movies/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_MOVIES, token);
    }
    
    public List<TraktCalendarMovie> getMyDvd(@Nonnull LocalDate date, int days, @Nonnull TraktAccessToken token, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("calendars/my/dvd/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_MOVIES, token);
    }
    
    public List<TraktCalendarEpisode> getAllShows(@Nonnull LocalDate date, int days, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("calendars/all/shows/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES);
    }
    
    public List<TraktCalendarEpisode> getAllNewShows(@Nonnull LocalDate date, int days, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("calendars/all/shows/new/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES);
    }
    
    public List<TraktCalendarEpisode> getAllSeasonPremieres(@Nonnull LocalDate date, int days, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("calendars/all/shows/premieres/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES);
    }
    
    public List<TraktCalendarEpisode> getAllFinales(@Nonnull LocalDate date, int days, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("calendars/all/shows/finales/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_EPISODES);
    }
    
    public List<TraktCalendarMovie> getAllMovies(@Nonnull LocalDate date, int days, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("calendars/all/movies/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_MOVIES);
    }
    
    public List<TraktCalendarMovie> getAllDvd(@Nonnull LocalDate date, int days, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("calendars/all/dvd/{date}/{days}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .path("days", days)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.CALENDAR_MOVIES);
    }
}
