package com.wexalian.jtrakt.endpoint;

import java.util.HashMap;
import java.util.Map;

public enum TraktItemFilterType
{
    ALL("all"),
    MOVIE("movies"),
    SHOW("shows"),
    SEASON("seasons"),
    EPISODE("episodes"),
    LIST("lists");
    
    private static final Map<String, TraktItemFilterType> STRING_MAPPING = new HashMap<>();
    
    static
    {
        for (TraktItemFilterType type : values())
        {
            STRING_MAPPING.put(type.toString(), type);
        }
    }
    
    private final String type;
    
    TraktItemFilterType(String type)
    {
        this.type = type;
    }
    
    @Override
    public String toString()
    {
        return type;
    }
    
    public static TraktItemFilterType fromValue(String value)
    {
        return STRING_MAPPING.get(value);
    }
}
