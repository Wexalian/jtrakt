module com.wexalian.jtrakt {
    requires java.desktop;
    requires java.net.http;
    requires com.google.gson;
    requires com.wexalian.nullability;
    
    exports com.wexalian.jtrakt;
    
    exports com.wexalian.jtrakt.http;
    exports com.wexalian.jtrakt.http.query;
    
    exports com.wexalian.jtrakt.endpoint;
    exports com.wexalian.jtrakt.endpoint.auth;
    exports com.wexalian.jtrakt.endpoint.calendars;
    exports com.wexalian.jtrakt.endpoint.checkin;
    exports com.wexalian.jtrakt.endpoint.certifications;
    exports com.wexalian.jtrakt.endpoint.comments;
    exports com.wexalian.jtrakt.endpoint.countries;
    exports com.wexalian.jtrakt.endpoint.episodes;
    exports com.wexalian.jtrakt.endpoint.genres;
    exports com.wexalian.jtrakt.endpoint.languages;
    exports com.wexalian.jtrakt.endpoint.lists;
    exports com.wexalian.jtrakt.endpoint.movies;
    exports com.wexalian.jtrakt.endpoint.networks;
    exports com.wexalian.jtrakt.endpoint.people;
    exports com.wexalian.jtrakt.endpoint.recommendations;
    exports com.wexalian.jtrakt.endpoint.scrobble;
    exports com.wexalian.jtrakt.endpoint.search;
    exports com.wexalian.jtrakt.endpoint.seasons;
    exports com.wexalian.jtrakt.endpoint.shows;
    exports com.wexalian.jtrakt.endpoint.sync;
    exports com.wexalian.jtrakt.endpoint.sync.activity;
    exports com.wexalian.jtrakt.endpoint.sync.collection;
    exports com.wexalian.jtrakt.endpoint.sync.history;
    exports com.wexalian.jtrakt.endpoint.sync.rating;
    exports com.wexalian.jtrakt.endpoint.sync.recommendations;
    exports com.wexalian.jtrakt.endpoint.sync.watchlist;
    exports com.wexalian.jtrakt.endpoint.users;
    exports com.wexalian.jtrakt.endpoint.users.follow;
    exports com.wexalian.jtrakt.endpoint.users.hidden;
    
    opens com.wexalian.jtrakt to com.google.gson;
    opens com.wexalian.jtrakt.json to com.google.gson;
    
    opens com.wexalian.jtrakt.endpoint to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.auth to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.auth.data to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.calendars to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.checkin to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.certifications to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.comments to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.countries to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.episodes to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.genres to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.languages to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.lists to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.movies to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.networks to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.people to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.recommendations to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.scrobble to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.search to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.seasons to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.shows to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.sync to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.sync.activity to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.sync.collection to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.sync.history to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.sync.rating to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.sync.recommendations to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.sync.watchlist to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.users to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.users.data to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.users.follow to com.google.gson;
    opens com.wexalian.jtrakt.endpoint.users.hidden to com.google.gson;
}