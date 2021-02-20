package com.wexalian.jtrakt.endpoint.users;

import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.people.TraktPerson;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeason;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

import java.time.OffsetDateTime;

public class TraktListItem {
    private int rank;
    private long id;
    private OffsetDateTime listed_at;
    
    private TraktItemType type;
    private TraktMovie movie;
    private TraktShow show;
    private TraktSeason season;
    private TraktEpisode episode;
    private TraktPerson person;
}
