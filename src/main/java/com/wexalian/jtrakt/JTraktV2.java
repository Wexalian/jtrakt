package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.auth.TraktAuthentication;
import com.wexalian.jtrakt.endpoint.calendars.TraktCalenders;
import com.wexalian.jtrakt.endpoint.checkin.TraktCheckin;
import com.wexalian.jtrakt.endpoint.comments.TraktComments;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisodes;
import com.wexalian.jtrakt.endpoint.genres.TraktGenres;
import com.wexalian.jtrakt.endpoint.movies.TraktMovies;
import com.wexalian.jtrakt.endpoint.people.TraktPeople;
import com.wexalian.jtrakt.endpoint.recommendations.TraktRecommendations;
import com.wexalian.jtrakt.endpoint.scrobble.TraktScrobble;
import com.wexalian.jtrakt.endpoint.search.TraktSearch;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeasons;
import com.wexalian.jtrakt.endpoint.shows.TraktShows;
import com.wexalian.jtrakt.endpoint.sync.TraktSync;
import com.wexalian.jtrakt.endpoint.users.TraktUsers;
import com.wexalian.jtrakt.http.TraktHTTP;

public final class JTraktV2
{
    //api
    private final String clientId;
    private final String secretId;
    
    //api endpoints
    private TraktAuthentication authentication;
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
    
    //http
    private TraktHTTP http;
    
    public JTraktV2(String clientId)
    {
        this(clientId, "");
    }
    
    public JTraktV2(String clientId, String secretId)
    {
        this.clientId = clientId;
        this.secretId = secretId;
        this.http = new TraktHTTP(this);
    }
    
    public String getClientId()
    {
        return clientId;
    }
    
    public String getSecretId()
    {
        return secretId;
    }
    
    public TraktAuthentication getAuthentication()
    {
        return authentication == null ? authentication = new TraktAuthentication(this, http) : authentication;
    }
    
    public TraktCalenders getCalenders()
    {
        return calenders == null ? calenders = new TraktCalenders(http) : calenders;
    }
    
    public TraktCheckin getCheckin()
    {
        return checkin == null ? checkin = new TraktCheckin(http) : checkin;
    }
    
    public TraktComments getComments()
    {
        return comments == null ? comments = new TraktComments(http) : comments;
    }
    
    public TraktEpisodes getEpisodes()
    {
        return episodes == null ? episodes = new TraktEpisodes(http) : episodes;
    }
    
    public TraktGenres getGenres()
    {
        return genres == null ? genres = new TraktGenres(http) : genres;
    }
    
    public TraktMovies getMovies()
    {
        return movies == null ? movies = new TraktMovies(http) : movies;
    }
    
    public TraktPeople getPeople()
    {
        return people == null ? people = new TraktPeople(http) : people;
    }
    
    public TraktRecommendations getRecommendations()
    {
        return recommendations == null ? recommendations = new TraktRecommendations(http) : recommendations;
    }
    
    public TraktScrobble getScrobble()
    {
        return scrobble == null ? scrobble = new TraktScrobble(http) : scrobble;
    }
    
    public TraktSearch getSearch()
    {
        return search == null ? search = new TraktSearch(http) : search;
    }
    
    public TraktSeasons getSeasons()
    {
        return seasons == null ? seasons = new TraktSeasons(http) : seasons;
    }
    
    public TraktShows getShows()
    {
        return shows == null ? shows = new TraktShows(http) : shows;
    }
    
    public TraktSync getSync()
    {
        return sync == null ? sync = new TraktSync(http) : sync;
    }
    
    public TraktUsers getUsers()
    {
        return users == null ? users = new TraktUsers(http) : users;
    }
    
}
