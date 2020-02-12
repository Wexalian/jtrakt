package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.auth.TraktAuthenticationEndpoint;
import com.wexalian.jtrakt.endpoint.calendars.TraktCalendarsEndpoint;
import com.wexalian.jtrakt.endpoint.certifications.TraktCertificationsEndpoint;
import com.wexalian.jtrakt.endpoint.checkin.TraktCheckinEndpoint;
import com.wexalian.jtrakt.endpoint.comments.TraktCommentsEndpoint;
import com.wexalian.jtrakt.endpoint.countries.TraktCountriesEndpoint;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisodesEndpoint;
import com.wexalian.jtrakt.endpoint.genres.TraktGenresEndpoint;
import com.wexalian.jtrakt.endpoint.languages.TraktLanguagesEndpoint;
import com.wexalian.jtrakt.endpoint.movies.TraktMoviesEndpoint;
import com.wexalian.jtrakt.endpoint.networks.TraktNetworksEndpoint;
import com.wexalian.jtrakt.endpoint.people.TraktPeopleEndpoint;
import com.wexalian.jtrakt.endpoint.recommendations.TraktRecommendationsEndpoint;
import com.wexalian.jtrakt.endpoint.scrobble.TraktScrobbleEndpoint;
import com.wexalian.jtrakt.endpoint.search.TraktSearchEndpoint;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeasonsEndpoint;
import com.wexalian.jtrakt.endpoint.shows.TraktShowsEndpoint;
import com.wexalian.jtrakt.endpoint.sync.TraktSyncEndpoint;
import com.wexalian.jtrakt.endpoint.users.TraktUsersEndpoint;
import com.wexalian.jtrakt.http.TraktHTTP;

public final class JTraktV2
{
    //api
    private final String clientId;
    private final String secretId;
    
    //api endpoints
    private TraktAuthenticationEndpoint authentication;
    private TraktCalendarsEndpoint calenders;
    private TraktCertificationsEndpoint certifications;
    private TraktCheckinEndpoint checkin;
    private TraktCommentsEndpoint comments;
    private TraktCountriesEndpoint countries;
    private TraktEpisodesEndpoint episodes;
    private TraktGenresEndpoint genres;
    private TraktLanguagesEndpoint languages;
    private TraktMoviesEndpoint movies;
    private TraktNetworksEndpoint networks;
    private TraktPeopleEndpoint people;
    private TraktRecommendationsEndpoint recommendations;
    private TraktScrobbleEndpoint scrobble;
    private TraktSearchEndpoint search;
    private TraktSeasonsEndpoint seasons;
    private TraktShowsEndpoint shows;
    private TraktSyncEndpoint sync;
    private TraktUsersEndpoint users;
    
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
    
    public TraktAuthenticationEndpoint getAuthenticationEndpoint()
    {
        return authentication == null ? authentication = new TraktAuthenticationEndpoint(this, http) : authentication;
    }
    
    public TraktCalendarsEndpoint getCalendersEndpoint()
    {
        return calenders == null ? calenders = new TraktCalendarsEndpoint(http) : calenders;
    }
    
    public TraktCertificationsEndpoint getCertificationsEndpoint()
    {
        return certifications == null ? certifications = new TraktCertificationsEndpoint(http) : certifications;
    }
    
    public TraktCheckinEndpoint getCheckinEndpoint()
    {
        return checkin == null ? checkin = new TraktCheckinEndpoint(http) : checkin;
    }
    
    public TraktCommentsEndpoint getCommentsEndpoint()
    {
        return comments == null ? comments = new TraktCommentsEndpoint(http) : comments;
    }
    
    public TraktCountriesEndpoint getCountriesEndpoint()
    {
        return countries == null ? countries = new TraktCountriesEndpoint(http) : countries;
    }
    
    public TraktEpisodesEndpoint getEpisodesEndpoint()
    {
        return episodes == null ? episodes = new TraktEpisodesEndpoint(http) : episodes;
    }
    
    public TraktGenresEndpoint getGenresEndpoint()
    {
        return genres == null ? genres = new TraktGenresEndpoint(http) : genres;
    }
    
    public TraktLanguagesEndpoint getLanguagesEndpoint()
    {
        return languages == null ? languages = new TraktLanguagesEndpoint(http) : languages;
    }
    
    public TraktMoviesEndpoint getMoviesEndpoint()
    {
        return movies == null ? movies = new TraktMoviesEndpoint(http) : movies;
    }
    
    public TraktNetworksEndpoint getNetworksEndpoint()
    {
        return networks == null ? networks = new TraktNetworksEndpoint(http) : networks;
    }
    
    public TraktPeopleEndpoint getPeopleEndpoint()
    {
        return people == null ? people = new TraktPeopleEndpoint(http) : people;
    }
    
    public TraktRecommendationsEndpoint getRecommendationsEndpoint()
    {
        return recommendations == null ? recommendations = new TraktRecommendationsEndpoint(http) : recommendations;
    }
    
    public TraktScrobbleEndpoint getScrobbleEndpoint()
    {
        return scrobble == null ? scrobble = new TraktScrobbleEndpoint(http) : scrobble;
    }
    
    public TraktSearchEndpoint getSearchEndpoint()
    {
        return search == null ? search = new TraktSearchEndpoint(http) : search;
    }
    
    public TraktSeasonsEndpoint getSeasonsEndpoint()
    {
        return seasons == null ? seasons = new TraktSeasonsEndpoint(http) : seasons;
    }
    
    public TraktShowsEndpoint getShowsEndpoint()
    {
        return shows == null ? shows = new TraktShowsEndpoint(http) : shows;
    }
    
    public TraktSyncEndpoint getSyncEndpoint()
    {
        return sync == null ? sync = new TraktSyncEndpoint(http) : sync;
    }
    
    public TraktUsersEndpoint getUsersEndpoint()
    {
        return users == null ? users = new TraktUsersEndpoint(http) : users;
    }
    
}
