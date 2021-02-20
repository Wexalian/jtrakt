package com.wexalian.jtrakt.endpoint.networks;

import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import java.util.List;

public class TraktNetworksEndpoint {
    private final TraktHTTP http;
    
    public TraktNetworksEndpoint(TraktHTTP http) {
        this.http = http;
    }
    
    public List<TraktNetwork> getNetworks() {
        TraktQuery query = TraktQuery.create("networks");
        
        return http.getAndParse(query, TraktTypeTokens.NETWORKS);
    }
}
