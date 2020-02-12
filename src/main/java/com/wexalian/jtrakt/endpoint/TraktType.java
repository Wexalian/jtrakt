package com.wexalian.jtrakt.endpoint;

import java.util.HashMap;
import java.util.Map;

public enum TraktType
{
    // ALL("all"),
    MOVIE("movies"),
    SHOW("shows"),
    // SEASON("seasons"),
    // EPISODE("episodes"),
    // LIST("lists"),
    // PERSON("persons"),
    // COMMENT("comment")
    ;
    
    private static final Map<String, TraktType> STRING_MAPPING = new HashMap<>();
    
    static
    {
        for (TraktType type : values())
        {
            STRING_MAPPING.put(type.toString(), type);
        }
    }
    
    private final String type;
    
    TraktType(String type)
    {
        this.type = type;
    }
    
    @Override
    public String toString()
    {
        return type;
    }
    
    public static TraktType fromValue(String value)
    {
        return STRING_MAPPING.get(value);
    }
}

