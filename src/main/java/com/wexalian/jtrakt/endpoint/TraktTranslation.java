package com.wexalian.jtrakt.endpoint;

import com.wexalian.jtrakt.endpoint.languages.TraktLanguage;

public class TraktTranslation
{
    private String title;
    private String overview;
    private TraktLanguage language;
    
    public String getTitle()
    {
        return title;
    }
    
    public String getOverview()
    {
        return overview;
    }
    
    public TraktLanguage getLanguage()
    {
        return language;
    }
}
