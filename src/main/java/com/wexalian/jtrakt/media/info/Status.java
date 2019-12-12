package com.wexalian.jtrakt.media.info;

import java.util.HashMap;
import java.util.Map;

public enum Status
{
    ENDED("ended"),
    RETURNING("returning series"),
    CANCELED("canceled"),
    IN_PRODUCTION("in production");
    
    private static final Map<String, Status> STRING_MAPPING = new HashMap<>();
    
    static
    {
        for (Status status : values())
        {
            STRING_MAPPING.put(status.toString(), status);
        }
    }
    
    private final String value;
    
    Status(String value)
    {
        this.value = value;
    }
    
    @Override
    public String toString()
    {
        return value;
    }
    
    public static Status fromValue(String value)
    {
        return STRING_MAPPING.get(value);
    }
}
