package com.wexalian.jtrakt.http.query;

import java.util.HashMap;
import java.util.Map;

public enum SearchType
{
    MOVIE("movie"),
    SHOW("show"),
    EPISODE("episode"),
    PERSON("season"),
    LIST("list");
    
    private static final Map<String, SearchType> STRING_MAPPING = new HashMap<>();
    
    static
    {
        for (SearchType type : values())
        {
            STRING_MAPPING.put(type.toString(), type);
        }
    }
    
    private final String type;
    
    SearchType(String type)
    {
        this.type = type;
    }
    
    @Override
    public String toString()
    {
        return type;
    }
    
    public static SearchType fromValue(String value)
    {
        return STRING_MAPPING.get(value);
    }
}
