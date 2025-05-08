package com.wexalian.jtrakt.endpoint.episodes;

import com.wexalian.jtrakt.endpoint.TraktRatings;
import com.wexalian.jtrakt.endpoint.TraktStats;
import com.wexalian.jtrakt.endpoint.TraktTranslation;
import com.wexalian.jtrakt.endpoint.comments.TraktComment;
import com.wexalian.jtrakt.endpoint.languages.TraktLanguage;
import com.wexalian.jtrakt.endpoint.lists.TraktList;
import com.wexalian.jtrakt.endpoint.users.TraktUser;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Pagination;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.nullability.annotations.Nonnull;
import com.wexalian.nullability.annotations.Nullable;

import java.util.List;

public class TraktEpisodesEndpoint {
    
    private final TraktHTTP http;
    
    public TraktEpisodesEndpoint(TraktHTTP http) {
        this.http = http;
    }
    
    public TraktEpisode getEpisode(@Nonnull String id, int season, int episode, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons/{season}/episodes/{episode}")
                                     .path("id", id)
                                     .path("season", season)
                                     .path("episode", episode)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.EPISODE);
    }
    
    public List<TraktTranslation> getTranslations(@Nonnull String id, int season, int episode, @Nullable TraktLanguage language) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons/{season}/episodes/{episode}/translations/{language}")
                                     .path("id", id)
                                     .path("season", season)
                                     .path("episode", episode)
                                     .path("language", language);
        
        return http.getAndParse(query, TraktTypeTokens.TRANSLATIONS);
    }
    
    public List<TraktComment> getComments(@Nonnull String id, int season, int episode, @Nullable TraktComment.Sort sort, @Nullable Pagination pagination) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons/{season}/episodes/{episode}/comments/{sort}")
                                     .path("id", id)
                                     .path("season", season)
                                     .path("episode", episode)
                                     .path("sort", sort)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.COMMENTS);
    }
    
    public List<TraktList> getLists(@Nonnull String id, int season, int episode, @Nullable TraktList.Type type, @Nullable TraktList.Sort sort, @Nullable Pagination pagination) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons/{season}/episodes/{episode}/lists/{type}/{sort}")
                                     .path("id", id)
                                     .path("season", season)
                                     .path("episode", episode)
                                     .path("type", type)
                                     .path("sort", sort)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.LISTS);
    }
    
    public TraktEpisodeCast getPeople(@Nonnull String id, int season, int episode, @Nullable Extended extended) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons/{season}/episodes/{episode}/people")
                                     .path("id", id)
                                     .path("season", season)
                                     .path("episode", episode)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.EPISODE_CAST);
    }
    
    public TraktRatings getRatings(@Nonnull String id, int season, int episode) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons/{season}/episodes/{episode}/ratings")
                                     .path("id", id)
                                     .path("season", season)
                                     .path("episode", episode);
        
        return http.getAndParse(query, TraktTypeTokens.RATINGS);
    }
    
    public TraktStats getStats(@Nonnull String id, int season, int episode) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons/{season}/episodes/{episode}/stats")
                                     .path("id", id)
                                     .path("season", season)
                                     .path("episode", episode);
        
        return http.getAndParse(query, TraktTypeTokens.STATS);
    }
    
    public List<TraktUser> getWatching(@Nonnull String id, int season, int episode) {
        TraktQuery query = TraktQuery.create("shows/{id}/seasons/{season}/episodes/{episode}/watching")
                                     .path("id", id)
                                     .path("season", season)
                                     .path("episode", episode);
        
        return http.getAndParse(query, TraktTypeTokens.USERS);
    }
}
