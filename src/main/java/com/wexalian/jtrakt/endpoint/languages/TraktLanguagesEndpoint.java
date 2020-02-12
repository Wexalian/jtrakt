package com.wexalian.jtrakt.endpoint.languages;

import com.wexalian.jtrakt.endpoint.TraktItemFilterType;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nonnull;
import java.util.List;

public class TraktLanguagesEndpoint
{
    private final TraktHTTP http;
    
    public TraktLanguagesEndpoint(TraktHTTP http)
    {
        this.http = http;
    }
    
    public List<TraktLanguage> getLanguages(@Nonnull TraktItemFilterType type)
    {
        TraktQuery query = TraktQuery.create("languages/{type}")
                                     .path("type", type);
        
        return http.getAndParse(query, TraktTypeTokens.LANGUAGES);
    }
}
