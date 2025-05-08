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
import com.wexalian.jtrakt.endpoint.lists.TraktListsEndpoint;
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

public final class JTraktV2 {
    //api
    private final String clientId;
    private final String secretId;
    private final boolean staging;
    
    //api endpoints
    private final TraktAuthenticationEndpoint authentication;
    private final TraktCalendarsEndpoint calenders;
    private final TraktCertificationsEndpoint certifications;
    private final TraktCheckinEndpoint checkin;
    private final TraktCommentsEndpoint comments;
    private final TraktCountriesEndpoint countries;
    private final TraktEpisodesEndpoint episodes;
    private final TraktGenresEndpoint genres;
    private final TraktLanguagesEndpoint languages;
    private final TraktListsEndpoint lists;
    private final TraktMoviesEndpoint movies;
    private final TraktNetworksEndpoint networks;
    private final TraktPeopleEndpoint people;
    private final TraktRecommendationsEndpoint recommendations;
    private final TraktScrobbleEndpoint scrobble;
    private final TraktSearchEndpoint search;
    private final TraktSeasonsEndpoint seasons;
    private final TraktShowsEndpoint shows;
    private final TraktSyncEndpoint sync;
    private final TraktUsersEndpoint users;
    
    public JTraktV2(String clientId, String secretId) {
        this(clientId, secretId, false);
    }
    
    public JTraktV2(String clientId, String secretId, boolean staging) {
        this.clientId = clientId;
        this.secretId = secretId;
        this.staging = staging;
        
        TraktHTTP http = new TraktHTTP(this.clientId, staging);
        
        authentication = new TraktAuthenticationEndpoint(this, http);
        calenders = new TraktCalendarsEndpoint(http);
        certifications = new TraktCertificationsEndpoint(http);
        checkin = new TraktCheckinEndpoint(http);
        comments = new TraktCommentsEndpoint(http);
        countries = new TraktCountriesEndpoint(http);
        episodes = new TraktEpisodesEndpoint(http);
        genres = new TraktGenresEndpoint(http);
        languages = new TraktLanguagesEndpoint(http);
        lists = new TraktListsEndpoint(http);
        movies = new TraktMoviesEndpoint(http);
        networks = new TraktNetworksEndpoint(http);
        people = new TraktPeopleEndpoint(http);
        recommendations = new TraktRecommendationsEndpoint(http);
        scrobble = new TraktScrobbleEndpoint(http);
        search = new TraktSearchEndpoint(http);
        seasons = new TraktSeasonsEndpoint(http);
        shows = new TraktShowsEndpoint(http);
        sync = new TraktSyncEndpoint(http);
        users = new TraktUsersEndpoint(http);
    }
    
    public String getClientId() {
        return clientId;
    }
    
    public String getSecretId() {
        return secretId;
    }
    
    public boolean isStaging() {
        return staging;
    }
    
    public TraktAuthenticationEndpoint getAuthenticationEndpoint() {
        return authentication;
    }
    
    public TraktCalendarsEndpoint getCalendersEndpoint() {
        return calenders;
    }
    
    public TraktCertificationsEndpoint getCertificationsEndpoint() {
        return certifications;
    }
    
    public TraktCheckinEndpoint getCheckinEndpoint() {
        return checkin;
    }
    
    public TraktCommentsEndpoint getCommentsEndpoint() {
        return comments;
    }
    
    public TraktCountriesEndpoint getCountriesEndpoint() {
        return countries;
    }
    
    public TraktEpisodesEndpoint getEpisodesEndpoint() {
        return episodes;
    }
    
    public TraktGenresEndpoint getGenresEndpoint() {
        return genres;
    }
    
    public TraktLanguagesEndpoint getLanguagesEndpoint() {
        return languages;
    }
    
    public TraktListsEndpoint getListsEndpoint() {
        return lists;
    }
    
    public TraktMoviesEndpoint getMoviesEndpoint() {
        return movies;
    }
    
    public TraktNetworksEndpoint getNetworksEndpoint() {
        return networks;
    }
    
    public TraktPeopleEndpoint getPeopleEndpoint() {
        return people;
    }
    
    public TraktRecommendationsEndpoint getRecommendationsEndpoint() {
        return recommendations;
    }
    
    public TraktScrobbleEndpoint getScrobbleEndpoint() {
        return scrobble;
    }
    
    public TraktSearchEndpoint getSearchEndpoint() {
        return search;
    }
    
    public TraktSeasonsEndpoint getSeasonsEndpoint() {
        return seasons;
    }
    
    public TraktShowsEndpoint getShowsEndpoint() {
        return shows;
    }
    
    public TraktSyncEndpoint getSyncEndpoint() {
        return sync;
    }
    
    public TraktUsersEndpoint getUsersEndpoint() {
        return users;
    }
    
    public static final class Data {
        private String client_id;
        private String secret_id;
        
        public String clientId() {
            return client_id;
        }
        
        public String secretId() {
            return secret_id;
        }
    }
}
