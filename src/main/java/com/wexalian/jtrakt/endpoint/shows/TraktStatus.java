package com.wexalian.jtrakt.endpoint.shows;

import java.util.HashMap;
import java.util.Map;

public enum TraktStatus
{
    ENDED("ended"),
    RETURNING("returning series"),
    CANCELED("canceled"),
    IN_PRODUCTION("in production");
    
    private static final Map<String, TraktStatus> STRING_MAPPING = new HashMap<>();
    
    static
    {
        for (TraktStatus status : values())
        {
            STRING_MAPPING.put(status.toString(), status);
        }
    }
    
    private final String value;
    
    TraktStatus(String value)
    {
        this.value = value;
    }
    
    @Override
    public String toString()
    {
        return value;
    }
    
    public static TraktStatus fromValue(String value)
    {
        return STRING_MAPPING.get(value);
    }
}
