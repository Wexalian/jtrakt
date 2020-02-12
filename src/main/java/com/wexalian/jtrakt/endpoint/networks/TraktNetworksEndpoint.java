package com.wexalian.jtrakt.endpoint.networks;

import com.wexalian.jtrakt.endpoint.TraktType;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nonnull;
import java.util.List;

public class TraktNetworksEndpoint
{
    private final TraktHTTP http;
    
    public TraktNetworksEndpoint(TraktHTTP http)
    {
        this.http = http;
    }
    
    public List<TraktNetwork> getShowNetworks(@Nonnull TraktType type)
    {
        TraktQuery query = TraktQuery.create("networks/{type}")
                                     .path("type", type);
        
        return http.getAndParse(query, TraktTypeTokens.NETWORKS);
    }
}
