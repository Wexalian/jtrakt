package com.wexalian.jtrakt.endpoint.users;

import com.wexalian.jtrakt.endpoint.*;

import java.time.OffsetDateTime;

public class TraktListItem
{
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
