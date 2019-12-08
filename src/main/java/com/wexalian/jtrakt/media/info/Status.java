package com.wexalian.jtrakt.media.info;

import java.util.Arrays;
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
        Arrays.stream(Status.values()).forEach(s -> STRING_MAPPING.put(s.toString(), s));
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
