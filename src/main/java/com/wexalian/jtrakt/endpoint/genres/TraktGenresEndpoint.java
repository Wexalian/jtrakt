package com.wexalian.jtrakt.endpoint.genres;

import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.jtrakt.media.info.Genre;

import java.util.List;

public class TraktGenresEndpoint
{
    private final TraktHTTP http;
    
    public TraktGenresEndpoint(TraktHTTP http)
    {
        this.http = http;
    }
    
    public List<Genre> getShowGenres()
    {
        TraktQuery query = TraktQuery.create("genres/shows");
        
        return http.getAndParse(query, TraktTypeTokens.GENRES);
    }
    
    public List<Genre> getMovieGenres()
    {
        TraktQuery query = TraktQuery.create("genres/movies");
        
        return http.getAndParse(query, TraktTypeTokens.GENRES);
    }
}
