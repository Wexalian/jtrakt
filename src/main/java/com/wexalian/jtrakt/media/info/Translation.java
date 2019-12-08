package com.wexalian.jtrakt.media.info;

import com.wexalian.jtrakt.http.query.Language;

public class Translation
{
    private String title;
    private String overview;
    private Language language;
    
    public String getTitle()
    {
        return title;
    }
    
    public String getOverview()
    {
        return overview;
    }
    
    public Language getLanguage()
    {
        return language;
    }
}
