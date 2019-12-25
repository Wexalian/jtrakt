package com.wexalian.jtrakt.endpoint.certifications;

import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.jtrakt.media.certification.TraktCertifications;

public class TraktCertificationsEndpoint
{
    private final TraktHTTP http;
    
    public TraktCertificationsEndpoint(TraktHTTP http)
    {
        this.http = http;
    }
    
    public TraktCertifications getShowCertifications()
    {
        TraktQuery query = TraktQuery.create("certifications/shows");
        
        return http.getAndParse(query, TraktTypeTokens.CERTIFICATIONS);
    }
    
    public TraktCertifications getMovieCertifications()
    {
        TraktQuery query = TraktQuery.create("certifications/movies");
        
        return http.getAndParse(query, TraktTypeTokens.CERTIFICATIONS);
    }
}