package com.wexalian.jtrakt.endpoint.movies;

import com.wexalian.jtrakt.endpoint.*;
import com.wexalian.jtrakt.endpoint.comments.TraktComment;
import com.wexalian.jtrakt.endpoint.languages.TraktLanguage;
import com.wexalian.jtrakt.endpoint.lists.TraktList;
import com.wexalian.jtrakt.endpoint.users.TraktUser;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Filter;
import com.wexalian.jtrakt.http.query.Pagination;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TraktMoviesEndpoint {
    private final TraktHTTP http;
    
    public TraktMoviesEndpoint(TraktHTTP http) {
        this.http = http;
    }
    
    public List<TraktTrendingMovie> getTrending(@Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("movies/trending").query(pagination).query(extended).query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.TRENDING_MOVIES);
    }
    
    public List<TraktMovie> getPopular(@Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("movies/popular").query(pagination).query(extended).query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.MOVIES);
    }
    
    public List<TraktWatchedMovie> getMostPlayed(@Nonnull TraktTimePeriod period, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("movies/played/{period}")
                                     .path("period", period)
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHED_MOVIES);
    }
    
    public List<TraktWatchedMovie> getMostWatched(@Nonnull TraktTimePeriod period, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("movies/watched/{period}")
                                     .path("period", period)
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHED_MOVIES);
    }
    
    public List<TraktWatchedMovie> getMostCollected(@Nonnull TraktTimePeriod period, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("movies/collected/{period}")
                                     .path("period", period)
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHED_MOVIES);
    }
    
    public List<TraktListedMovie> getMostAnticipated(@Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("movies/anticipated").query(pagination).query(extended).query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.LISTED_MOVIES);
    }
    
    public List<TraktBoxOfficeMovie> getBoxOffice(@Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("movies/boxoffice").query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.BOX_OFFICE_MOVIES);
    }
    
    public List<TraktUpdatedMovie> getUpdates(@Nonnull OffsetDateTime date, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("movies/updates/{date}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.UPDATED_MOVIES);
    }
    
    public TraktMovie getSummary(@Nonnull String id, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("movies/{id}").path("id", id).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.MOVIE);
    }
    
    public List<TraktAlias> getAliases(@Nonnull String id, @Nullable TraktLanguage lang) {
        TraktQuery query = TraktQuery.create("movies/{id}/aliases/{lang}").path("id", id).path("lang", lang);
        
        return http.getAndParse(query, TraktTypeTokens.ALIASES);
    }
    
    public List<TraktMovieRelease> getReleases(@Nonnull String id, @Nullable String country) {
        TraktQuery query = TraktQuery.create("movies/{id}/releases/{country}").path("id", id).path("country", country);
        
        return http.getAndParse(query, TraktTypeTokens.RELEASES);
    }
    
    public List<TraktTranslation> getTranslations(@Nonnull String id, @Nullable TraktLanguage lang) {
        TraktQuery query = TraktQuery.create("movies/{id}/translations/{lang}").path("id", id).path("lang", lang);
        
        return http.getAndParse(query, TraktTypeTokens.TRANSLATIONS);
    }
    
    public List<TraktComment> getComments(@Nonnull String id, @Nullable TraktComment.Sort sort, @Nullable Pagination pagination) {
        TraktQuery query = TraktQuery.create("movies/{id}/comments/{sort}")
                                     .path("id", id)
                                     .path("sort", sort)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.COMMENTS);
    }
    
    public List<TraktList> getLists(@Nonnull String id, @Nonnull TraktList.Type type, @Nullable TraktList.Sort sort, @Nullable Pagination pagination) {
        TraktQuery query = TraktQuery.create("movies/{id}/lists/{type}/{sort}")
                                     .path("id", id)
                                     .path("type", type)
                                     .path("sort", sort)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.LISTS);
    }
    
    public TraktMovieCast getPeople(@Nonnull String id, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("movies/{id}/people").path("id", id).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.MOVIE_CAST);
    }
    
    public TraktRatings getRatings(@Nonnull String id) {
        TraktQuery query = TraktQuery.create("movies/{id}/ratings").path("id", id);
        
        return http.getAndParse(query, TraktTypeTokens.RATINGS);
    }
    
    public List<TraktMovie> getRelated(@Nonnull String id, @Nullable Pagination pagination, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("movies/{id}/related").path("id", id).query(pagination).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.MOVIES);
    }
    
    public TraktStats getStats(@Nonnull String id) {
        TraktQuery query = TraktQuery.create("movies/{id}/stats").path("id", id);
        
        return http.getAndParse(query, TraktTypeTokens.STATS);
    }
    
    public List<TraktUser> getWatchingUsers(@Nonnull String id, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("movies/{id}/watching").path("id", id).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.USERS);
    }
}
