package com.wexalian.jtrakt.http.query;

import java.util.HashMap;
import java.util.Map;

public enum IdType
{
    TRAKT("trakt"),
    IMDB("imdb"),
    TMDB("tmdb"),
    TVDB("tvdb");
    
    private static final Map<String, IdType> STRING_MAPPING = new HashMap<>();
    
    static
    {
        for (IdType type : values())
        {
            STRING_MAPPING.put(type.toString(), type);
        }
    }
    
    private final String type;
    
    IdType(String type)
    {
        this.type = type;
    }
    
    @Override
    public String toString()
    {
        return type;
    }
    
    public static IdType get(String value)
    {
        return STRING_MAPPING.get(value);
    }
}
