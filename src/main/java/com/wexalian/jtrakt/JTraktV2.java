package com.wexalian.jtrakt;

import com.wexalian.jtrakt.calendars.TraktCalenders;
import com.wexalian.jtrakt.checkin.TraktCheckin;
import com.wexalian.jtrakt.comments.TraktComments;
import com.wexalian.jtrakt.episodes.TraktEpisodes;
import com.wexalian.jtrakt.genres.TraktGenres;
import com.wexalian.jtrakt.movies.TraktMovies;
import com.wexalian.jtrakt.people.TraktPeople;
import com.wexalian.jtrakt.recommendations.TraktRecommendations;
import com.wexalian.jtrakt.scrobble.TraktScrobble;
import com.wexalian.jtrakt.search.TraktSearch;
import com.wexalian.jtrakt.seasons.TraktSeasons;
import com.wexalian.jtrakt.shows.TraktShows;
import com.wexalian.jtrakt.sync.TraktSync;
import com.wexalian.jtrakt.users.TraktUsers;

public final class JTraktV2
{
    public static final String API_HOST = "api.trakt.tv";
    public static final String API_URL = "https://" + API_HOST + "/";
    public static final String API_VERSION = "2";
    
    public static final String SITE_URL = "https://trakt.tv";
    public static final String OAUTH2_AUTHORIZATION_URL = SITE_URL + "/oauth/authorize";
    public static final String OAUTH2_TOKEN_URL = SITE_URL + "/oauth/token";
    
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String HEADER_TRAKT_API_VERSION = "trakt-api-version";
    public static final String HEADER_TRAKT_API_KEY = "trakt-api-key";
    
    private final String apiKey;
    private final String clientSecret;
    
    private TraktCalenders calenders;
    private TraktCheckin checkin;
    private TraktComments comments;
    private TraktEpisodes episodes;
    private TraktGenres genres;
    private TraktMovies movies;
    private TraktPeople people;
    private TraktRecommendations recommendations;
    private TraktScrobble scrobble;
    private TraktSearch search;
    private TraktSeasons seasons;
    private TraktShows shows;
    private TraktSync sync;
    private TraktUsers users;
    
    public JTraktV2(String apiKey)
    {
        this(apiKey, "");
    }
    
    public JTraktV2(String apiKey, String clientSecret)
    {
        this.apiKey = apiKey;
        this.clientSecret = clientSecret;
    }
    
    public String getApiKey()
    {
        return apiKey;
    }
    
    public String getClientSecret()
    {
        return clientSecret;
    }
    
    public TraktCalenders getCalenders()
    {
        return calenders == null ? calenders = new TraktCalenders() : calenders;
    }
    
    public TraktCheckin getCheckin()
    {
        return checkin == null ? checkin = new TraktCheckin() : checkin;
    }
    
    public TraktComments getComments()
    {
        return comments == null ? comments = new TraktComments() : comments;
    }
    
    public TraktEpisodes getEpisodes()
    {
        return episodes == null ? episodes = new TraktEpisodes() : episodes;
    }
    
    public TraktGenres getGenres()
    {
        return genres == null ? genres = new TraktGenres() : genres;
    }
    
    public TraktMovies getMovies()
    {
        return movies == null ? movies = new TraktMovies() : movies;
    }
    
    public TraktPeople getPeople()
    {
        return people == null ? people = new TraktPeople() : people;
    }
    
    public TraktRecommendations getRecommendations()
    {
        return recommendations == null ? recommendations = new TraktRecommendations() : recommendations;
    }
    
    public TraktScrobble getScrobble()
    {
        return scrobble == null ? scrobble = new TraktScrobble() : scrobble;
    }
    
    public TraktSearch getSearch()
    {
        return search == null ? search = new TraktSearch() : search;
    }
    
    public TraktSeasons getSeasons()
    {
        return seasons == null ? seasons = new TraktSeasons() : seasons;
    }
    
    public TraktShows getShows()
    {
        return shows == null ? shows = new TraktShows() : shows;
    }
    
    public TraktSync getSync()
    {
        return sync == null ? sync = new TraktSync() : sync;
    }
    
    public TraktUsers getUsers()
    {
        return users == null ? users = new TraktUsers() : users;
    }
}
