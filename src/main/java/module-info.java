module com.wexalian.jtrakt {
    
    requires java.net.http;
    requires com.google.gson;
    requires com.google.common;
    requires jsr305;
    
    exports com.wexalian.jtrakt;
    
    exports com.wexalian.jtrakt.media;
    exports com.wexalian.jtrakt.media.calender;
    exports com.wexalian.jtrakt.media.info;
    exports com.wexalian.jtrakt.media.show;
    
    exports com.wexalian.jtrakt.http;
    exports com.wexalian.jtrakt.http.query;
    
    exports com.wexalian.jtrakt.endpoint.auth;
    exports com.wexalian.jtrakt.endpoint.calendars;
    exports com.wexalian.jtrakt.endpoint.checkin;
    exports com.wexalian.jtrakt.endpoint.comments;
    exports com.wexalian.jtrakt.endpoint.episodes;
    exports com.wexalian.jtrakt.endpoint.genres;
    exports com.wexalian.jtrakt.endpoint.movies;
    exports com.wexalian.jtrakt.endpoint.people;
    exports com.wexalian.jtrakt.endpoint.recommendations;
    exports com.wexalian.jtrakt.endpoint.scrobble;
    exports com.wexalian.jtrakt.endpoint.search;
    exports com.wexalian.jtrakt.endpoint.seasons;
    exports com.wexalian.jtrakt.endpoint.shows;
    exports com.wexalian.jtrakt.endpoint.sync;
    exports com.wexalian.jtrakt.endpoint.users;
    
    opens com.wexalian.jtrakt.json to com.google.gson;
}