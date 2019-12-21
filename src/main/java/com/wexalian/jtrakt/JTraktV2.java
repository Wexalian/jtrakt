package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.auth.TraktAuthentication;
import com.wexalian.jtrakt.endpoint.calendars.TraktCalendars;
import com.wexalian.jtrakt.endpoint.certifications.TraktCertifications;
import com.wexalian.jtrakt.endpoint.checkin.TraktCheckin;
import com.wexalian.jtrakt.endpoint.comments.TraktComments;
import com.wexalian.jtrakt.endpoint.countries.TraktCountries;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisodes;
import com.wexalian.jtrakt.endpoint.genres.TraktGenres;
import com.wexalian.jtrakt.endpoint.languages.TraktLanguages;
import com.wexalian.jtrakt.endpoint.movies.TraktMovies;
import com.wexalian.jtrakt.endpoint.networks.TraktNetworks;
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
    private TraktCalendars calenders;
    private TraktCertifications certifications;
    private TraktCheckin checkin;
    private TraktComments comments;
    private TraktCountries countries;
    private TraktEpisodes episodes;
    private TraktGenres genres;
    private TraktLanguages languages;
    private TraktMovies movies;
    private TraktNetworks networks;
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
    
    public TraktCalendars getCalenders()
    {
        return calenders == null ? calenders = new TraktCalendars(http) : calenders;
    }
    
    public TraktCertifications getCertifications()
    {
        return certifications == null ? certifications = new TraktCertifications(http) : certifications;
    }
    
    public TraktCheckin getCheckin()
    {
        return checkin == null ? checkin = new TraktCheckin(http) : checkin;
    }
    
    public TraktComments getComments()
    {
        return comments == null ? comments = new TraktComments(http) : comments;
    }
    
    public TraktCountries getCountries()
    {
        return countries == null ? countries = new TraktCountries(http) : countries;
    }
    
    public TraktEpisodes getEpisodes()
    {
        return episodes == null ? episodes = new TraktEpisodes(http) : episodes;
    }
    
    public TraktGenres getGenres()
    {
        return genres == null ? genres = new TraktGenres(http) : genres;
    }
    
    public TraktLanguages getLanguages()
    {
        return languages == null ? languages = new TraktLanguages(http) : languages;
    }
    
    public TraktMovies getMovies()
    {
        return movies == null ? movies = new TraktMovies(http) : movies;
    }
    
    public TraktNetworks getNetworks()
    {
        return networks == null ? networks = new TraktNetworks(http) : networks;
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
