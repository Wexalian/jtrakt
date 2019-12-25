package com.wexalian.jtrakt.endpoint.countries;

import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.jtrakt.media.info.Country;

import java.util.List;

public class TraktCountriesEndpoint
{
    private final TraktHTTP http;
    
    public TraktCountriesEndpoint(TraktHTTP http)
    {
        this.http = http;
    }
    
    public List<Country> getShowCountries()
    {
        TraktQuery query = TraktQuery.create("countries/shows");
        
        return http.getAndParse(query, TraktTypeTokens.COUNTRIES);
    }
    
    public List<Country> getMovieCountries()
    {
        TraktQuery query = TraktQuery.create("countries/movies");
        
        return http.getAndParse(query, TraktTypeTokens.COUNTRIES);
    }
}
