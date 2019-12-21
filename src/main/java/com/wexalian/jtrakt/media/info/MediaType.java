package com.wexalian.jtrakt.media.info;

import java.util.HashMap;
import java.util.Map;

public enum MediaType
{
    ALL("all"),
    MOVIE("movie"),
    SHOW("show"),
    SEASON("season"),
    EPISODE("episode"),
    LIST("list");
    
    private static final Map<String, MediaType> STRING_MAPPING = new HashMap<>();
    
    static
    {
        for (MediaType type : values())
        {
            STRING_MAPPING.put(type.toString(), type);
        }
    }
    
    private final String type;
    
    MediaType(String type)
    {
        this.type = type;
    }
    
    @Override
    public String toString()
    {
        return type;
    }
    
    public static MediaType fromValue(String value)
    {
        return STRING_MAPPING.get(value);
    }
}
