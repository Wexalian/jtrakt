package com.wexalian.jtrakt.endpoint.shows;

import com.google.common.base.Strings;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.*;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.jtrakt.media.*;
import com.wexalian.jtrakt.media.info.Alias;
import com.wexalian.jtrakt.media.info.Ratings;
import com.wexalian.jtrakt.media.info.Stats;
import com.wexalian.jtrakt.media.info.Translation;
import com.wexalian.jtrakt.media.show.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TraktShowsEndpoint
{
    private final TraktHTTP http;
    
    public TraktShowsEndpoint(@Nonnull TraktHTTP http)
    {
        this.http = http;
    }
    
    public List<TraktTrendingShow> getTrending(@Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("shows/trending")
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.TRENDING_SHOWS);
    }
    
    public List<TraktShow> getPopular(@Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("shows/popular")
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.SHOWS);
    }
    
    public List<TraktWatchedShow> getMostPlayed(@Nonnull TimePeriod period, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("shows/played/{period}")
                                     .path("period", period)
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHED_SHOWS);
    }
    
    public List<TraktWatchedShow> getMostWatched(@Nonnull TimePeriod period, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("shows/watched/{period}")
                                     .path("period", period)
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHED_SHOWS);
    }
    
    public List<TraktWatchedShow> getMostCollected(@Nonnull TimePeriod period, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("shows/collected/{period}")
                                     .path("period", period)
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHED_SHOWS);
    }
    
    public List<TraktListedShow> getMostAnticipated(@Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("shows/anticipated")
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.LISTED_SHOWS);
    }
    
    public List<TraktUpdatedShow> getUpdates(@Nonnull OffsetDateTime date, @Nullable Pagination pagination, @Nullable Extended extended, @Nullable Filter.FilterEntry... filters)
    {
        TraktQuery query = TraktQuery.create("shows/updates/{date}")
                                     .path("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE))
                                     .query(pagination)
                                     .query(extended)
                                     .query(filters);
        
        return http.getAndParse(query, TraktTypeTokens.UPDATED_SHOWS);
    }
    
    public TraktShow get(@Nonnull String showId, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("shows/{id}")
                                     .path("id", showId)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SHOW);
    }
    
    public List<Alias> getAliases(@Nonnull String showId, @Nullable Language lang)
    {
        TraktQuery query = TraktQuery.create("shows/{id}/aliases/{lang}")
                                     .path("id", showId)
                                     .path("lang", lang);
        
        return http.getAndParse(query, TraktTypeTokens.ALIASES);
    }
    
    public List<Translation> getTranslations(@Nonnull String showId, @Nullable Language lang)
    {
        TraktQuery query = TraktQuery.create("shows/{id}/translations/{lang}")
                                     .path("id", showId)
                                     .path("lang", lang);
        
        return http.getAndParse(query, TraktTypeTokens.TRANSLATIONS);
    }
    
    public List<TraktComment> getComments(@Nonnull String showId, @Nullable TraktComment.Sort sort, @Nullable Pagination pagination)
    {
        TraktQuery query = TraktQuery.create("shows/{id}/comments/{sort}")
                                     .path("id", showId)
                                     .path("sort", sort)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.COMMENTS);
    }
    
    public List<TraktList> getLists(@Nonnull String showId, @Nullable String type, @Nullable String sort, @Nullable Pagination pagination)
    {
        if (!Strings.isNullOrEmpty(sort) && Strings.isNullOrEmpty(sort))
        {
            throw new RuntimeException("If 'sort' isn't empty, 'type' can't be either");
        }
    
        TraktQuery query = TraktQuery.create("shows/{id}/lists/{type}/{sort}")
                                     .path("id", showId)
                                     .path("type", type)
                                     .path("sort", sort)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.LISTS);
    }
    
    public TraktCollectionProgress.Show getCollectionProgress(@Nonnull String showId, boolean hidden, boolean specials, boolean count_specials, @Nullable TraktAccessToken accessToken)
    {
        TraktQuery query = TraktQuery.create("shows/{id}/progress/collection")
                                     .path("id", showId)
                                     .query("hidden", hidden)
                                     .query("specials", specials)
                                     .query("count_specials", count_specials);
        
        return http.getAndParse(query, TraktTypeTokens.COLLECTED_PROGRESS, accessToken);
    }
    
    public TraktWatchedProgress.Show getWatchedProgress(@Nonnull String showId, boolean hidden, boolean specials, boolean count_specials, @Nullable TraktAccessToken accessToken)
    {
        TraktQuery query = TraktQuery.create("shows/{id}/progress/watched")
                                     .path("id", showId)
                                     .query("hidden", hidden)
                                     .query("specials", specials)
                                     .query("count_specials", count_specials);
        
        return http.getAndParse(query, TraktTypeTokens.WATCHED_PROGRESS, accessToken);
    }
    
    public TraktShowCast getPeople(@Nonnull String showId, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("shows/{id}/people")
                                     .path("id", showId)
                                     .query(extended);
    
        return http.getAndParse(query, TraktTypeTokens.SHOW_CAST);
    }
    
    public Ratings getRatings(@Nonnull String showId)
    {
        TraktQuery query = TraktQuery.create("shows/{id}/ratings")
                                     .path("id", showId);
        
        return http.getAndParse(query, TraktTypeTokens.RATINGS);
    }
    
    public List<TraktShow> getRelated(@Nonnull String showId, @Nullable Pagination pagination, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("shows/{id}/related")
                                     .path("id", showId)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SHOWS);
    }
    
    public Stats getStats(@Nonnull String showId)
    {
        TraktQuery query = TraktQuery.create("shows/{id}/stats")
                                     .path("id", showId);
        
        return http.getAndParse(query, TraktTypeTokens.STATS);
    }
    
    public List<TraktUser> getWatchingUsers(@Nonnull String showId, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("shows/{id}/watching")
                                     .path("id", showId)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.USERS);
    }
    
    public TraktEpisode getNextEpisode(@Nonnull String showId, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("shows/{id}/next_episode")
                                     .path("id", showId)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.EPISODE);
    }
    
    public TraktEpisode getLastEpisode(@Nonnull String showId, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("shows/{id}/last_episode")
                                     .path("id", showId)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.EPISODE);
    }
}