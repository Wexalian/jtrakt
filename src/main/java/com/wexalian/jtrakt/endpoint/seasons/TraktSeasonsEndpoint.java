package com.wexalian.jtrakt.endpoint.seasons;

import com.wexalian.jtrakt.endpoint.TraktRatings;
import com.wexalian.jtrakt.endpoint.TraktStats;
import com.wexalian.jtrakt.endpoint.comments.TraktComment;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.languages.TraktLanguage;
import com.wexalian.jtrakt.endpoint.lists.TraktList;
import com.wexalian.jtrakt.endpoint.shows.TraktShowCast;
import com.wexalian.jtrakt.endpoint.users.TraktUser;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Pagination;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class TraktSeasonsEndpoint {
    private final TraktHTTP http;
    
    public TraktSeasonsEndpoint(TraktHTTP http) {
        this.http = http;
    }
    
    public List<TraktSeason> getSummary(@Nonnull String id, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons").path("id", id).query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SEASONS);
    }
    
    public List<TraktEpisode> getEpisodes(@Nonnull String id, int season, @Nullable TraktLanguage language, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons/{season}")
                                     .path("id", id)
                                     .path("season", season)
                                     .query("translations", language)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.EPISODES);
    }
    
    public List<TraktComment> getComments(@Nonnull String id, int season, @Nullable TraktComment.Sort sort, @Nullable Pagination pagination) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons/{season}/comments/{sort}")
                                     .path("id", id)
                                     .path("season", season)
                                     .path("sort", sort)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.COMMENTS);
    }
    
    public List<TraktList> getLists(@Nonnull String id, int season, @Nullable TraktList.Type type, @Nullable TraktList.Sort sort, @Nullable Pagination pagination) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons/{season}/lists/{type}/{sort}")
                                     .path("id", id)
                                     .path("season", season)
                                     .path("type", type)
                                     .path("sort", sort)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.LISTS);
    }
    
    public TraktShowCast getPeople(@Nonnull String id, int season, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons/{season}/people")
                                     .path("id", id)
                                     .path("season", season)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.SHOW_CAST);
    }
    
    public TraktRatings getRatings(@Nonnull String id, int season) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons/{season}/ratings")
                                     .path("id", id)
                                     .path("season", season);
        
        return http.getAndParse(query, TraktTypeTokens.RATINGS);
    }
    
    public TraktStats getStats(@Nonnull String id, int season) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons/{season}/stats").path("id", id).path("season", season);
        
        return http.getAndParse(query, TraktTypeTokens.STATS);
    }
    
    public List<TraktUser> getWatching(@Nonnull String id, int season) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons/{season}/watching")
                                     .path("id", id)
                                     .path("season", season);
        
        return http.getAndParse(query, TraktTypeTokens.USERS);
    }
}
