package com.wexalian.jtrakt.endpoint.certifications;

import com.wexalian.jtrakt.endpoint.TraktItemFilterType;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nonnull;

public class TraktCertificationsEndpoint {
    private final TraktHTTP http;
    
    public TraktCertificationsEndpoint(TraktHTTP http) {
        this.http = http;
    }
    
    public TraktCertifications getCertifications(@Nonnull TraktItemFilterType type) {
        TraktQuery query = TraktQuery.create("certifications/{type}").path("type", type);
        
        return http.getAndParse(query, TraktTypeTokens.CERTIFICATIONS);
    }
}