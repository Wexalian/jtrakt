package com.wexalian.jtrakt.endpoint.networks;

import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.jtrakt.media.info.Network;

import java.util.List;

public class TraktNetworksEndpoint
{
    private final TraktHTTP http;
    
    public TraktNetworksEndpoint(TraktHTTP http)
    {
        this.http = http;
    }
    
    public List<Network> getShowNetworks()
    {
        TraktQuery query = TraktQuery.create("networks/shows");
        
        return http.getAndParse(query, TraktTypeTokens.NETWORKS);
    }
    
    public List<Network> getMovieNetworks()
    {
        TraktQuery query = TraktQuery.create("networks/movies");
        
        return http.getAndParse(query, TraktTypeTokens.NETWORKS);
    }
}
