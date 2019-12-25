package com.wexalian.jtrakt.endpoint.languages;

import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Language;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import java.util.List;

public class TraktLanguagesEndpoint
{
    private final TraktHTTP http;
    
    public TraktLanguagesEndpoint(TraktHTTP http)
    {
        this.http = http;
    }
    
    public List<Language> getShowLanguages()
    {
        TraktQuery query = TraktQuery.create("languages/shows");
        
        return http.getAndParse(query, TraktTypeTokens.LANGUAGES);
    }
    
    public List<Language> getMovieLanguages()
    {
        TraktQuery query = TraktQuery.create("languages/movies");
        
        return http.getAndParse(query, TraktTypeTokens.LANGUAGES);
    }
}
