module jtrakt {
    exports com.wexalian.jtrakt;
    // exports com.wexalian.jtrakt2.auth;
    exports com.wexalian.jtrakt.calendars;
    exports com.wexalian.jtrakt.checkin;
    exports com.wexalian.jtrakt.comments;
    exports com.wexalian.jtrakt.episodes;
    exports com.wexalian.jtrakt.genres;
    exports com.wexalian.jtrakt.movies;
    exports com.wexalian.jtrakt.people;
    exports com.wexalian.jtrakt.recommendations;
    exports com.wexalian.jtrakt.scrobble;
    exports com.wexalian.jtrakt.search;
    exports com.wexalian.jtrakt.seasons;
    exports com.wexalian.jtrakt.shows;
    exports com.wexalian.jtrakt.sync;
    exports com.wexalian.jtrakt.users;
    
    requires java.net.http;
    requires gson;
}