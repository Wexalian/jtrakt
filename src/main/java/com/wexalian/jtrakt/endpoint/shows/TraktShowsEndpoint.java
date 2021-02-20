package com.wexalian.jtrakt.endpoint.shows;

import com.wexalian.jtrakt.endpoint.*;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.endpoint.comments.TraktComment;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
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

public class TraktShowsEndpoint {
    private final TraktHTTP http;
    
    public TraktShowsEndpoint(@Nonnull TraktHTTP http) {
        this.http = http;
    }
    
    public List<TraktTrendingShow> getTrending(@Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("shows/trending").query(pagination).query(extended).query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.TRENDING_SHOWS);
    }
    
    public List<TraktShow> getPopular(@Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("shows/popular").query(pagination).query(extended).query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.SHOWS);
    }
    
    public List<TraktWatchedShow> getMostPlayed(@Nonnull TraktTimePeriod period, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("shows/played/{period}")
                                     .path("period", period)
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHED_SHOWS);
    }
    
    public List<TraktWatchedShow> getMostWatched(@Nonnull TraktTimePeriod period, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("shows/watched/{period}")
                                     .path("period", period)
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHED_SHOWS);
    }
    
    public List<TraktWatchedShow> getMostCollected(@Nonnull TraktTimePeriod period, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("shows/collected/{period}")
                                     .path("period", period)
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHED_SHOWS);
    }
    
    public List<TraktListedShow> getMostAnticipated(@Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("shows/anticipated").query(pagination).query(extended).query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.LISTED_SHOWS);
    }
    
    public List<TraktUpdatedShow> getUpdates(@Nonnull OffsetDateTime date, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry<?>... filters) {
        TraktQuery query = TraktQuery.create("shows/updates/{date}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.UPDATED_SHOWS);
    }
    
    public TraktShow getSummary(@Nonnull String id, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("shows/{id}").path("id", id).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SHOW);
    }
    
    public List<TraktAlias> getAliases(@Nonnull String id, @Nullable TraktLanguage lang) {
        TraktQuery query = TraktQuery.create("shows/{id}/aliases/{lang}").path("id", id).path("lang", lang);
        
        return http.getAndParse(query, TraktTypeTokens.ALIASES);
    }
    
    public List<TraktTranslation> getTranslations(@Nonnull String id, @Nullable TraktLanguage lang) {
        TraktQuery query = TraktQuery.create("shows/{id}/translations/{lang}").path("id", id).path("lang", lang);
        
        return http.getAndParse(query, TraktTypeTokens.TRANSLATIONS);
    }
    
    public List<TraktComment> getComments(@Nonnull String id, @Nullable TraktComment.Sort sort, @Nullable Pagination pagination) {
        TraktQuery query = TraktQuery.create("shows/{id}/comments/{sort}")
                                     .path("id", id)
                                     .path("sort", sort)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.COMMENTS);
    }
    
    public List<TraktList> getLists(@Nonnull String id, @Nullable String type, @Nullable String sort, @Nullable Pagination pagination) {
        TraktQuery query = TraktQuery.create("shows/{id}/lists/{type}/{sort}")
                                     .path("id", id)
                                     .path("type", type)
                                     .path("sort", sort)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.LISTS);
    }
    
    public TraktCollectionProgress.Show getCollectionProgress(@Nonnull String id, boolean hidden, boolean specials, boolean count_specials, @Nullable TraktAccessToken accessToken) {
        TraktQuery query = TraktQuery.create("shows/{id}/progress/collection")
                                     .path("id", id)
                                     .query("hidden", hidden)
                                     .query("specials", specials)
                                     .query("count_specials", count_specials);
        
        return http.getAndParse(query, TraktTypeTokens.COLLECTED_PROGRESS, accessToken);
    }
    
    public TraktWatchedProgress.Show getWatchedProgress(@Nonnull String id, boolean hidden, boolean specials, boolean count_specials, @Nullable TraktAccessToken accessToken) {
        TraktQuery query = TraktQuery.create("shows/{id}/progress/watched")
                                     .path("id", id)
                                     .query("hidden", hidden)
                                     .query("specials", specials)
                                     .query("count_specials", count_specials);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHED_PROGRESS, accessToken);
    }
    
    public TraktShowCast getPeople(@Nonnull String id, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("shows/{id}/people").path("id", id).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SHOW_CAST);
    }
    
    public TraktRatings getRatings(@Nonnull String id) {
        TraktQuery query = TraktQuery.create("shows/{id}/ratings").path("id", id);
        
        return http.getAndParse(query, TraktTypeTokens.RATINGS);
    }
    
    public List<TraktShow> getRelated(@Nonnull String id, @Nullable Pagination pagination, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("shows/{id}/related").path("id", id).query(pagination).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SHOWS);
    }
    
    public TraktStats getStats(@Nonnull String id) {
        TraktQuery query = TraktQuery.create("shows/{id}/stats").path("id", id);
        
        return http.getAndParse(query, TraktTypeTokens.STATS);
    }
    
    public List<TraktUser> getWatchingUsers(@Nonnull String id, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("shows/{id}/watching").path("id", id).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.USERS);
    }
    
    public TraktEpisode getNextEpisode(@Nonnull String id, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("shows/{id}/next_episode").path("id", id).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.EPISODE);
    }
    
    public TraktEpisode getLastEpisode(@Nonnull String id, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("shows/{id}/last_episode").path("id", id).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.EPISODE);
    }
}
