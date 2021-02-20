package com.wexalian.jtrakt.endpoint.countries;

import com.wexalian.jtrakt.endpoint.TraktItemFilterType;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nonnull;
import java.util.List;

public class TraktCountriesEndpoint {
    private final TraktHTTP http;
    
    public TraktCountriesEndpoint(TraktHTTP http) {
        this.http = http;
    }
    
    public List<TraktCountry> getCountries(@Nonnull TraktItemFilterType type) {
        TraktQuery query = TraktQuery.create("countries/{type}").path("type", type);
        
        return http.getAndParse(query, TraktTypeTokens.COUNTRIES);
    }
    
}
