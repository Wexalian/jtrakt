package com.wexalian.jtrakt.endpoint.movies;

import java.util.HashMap;
import java.util.Map;

public enum TraktMovieStatus {
    RELEASED("released"),
    IN_PRODUCTION("in production"),
    POST_PRODUCTION("post production"),
    PLANNED("planned"),
    RUMORED("rumored"),
    CANCELED("canceled");
    
    private static final Map<String, TraktMovieStatus> STRING_MAPPING = new HashMap<>();
    
    static {
        for (TraktMovieStatus status : values()) {
            STRING_MAPPING.put(status.toString(), status);
        }
    }
    
    private final String value;
    
    TraktMovieStatus(String value) {
        this.value = value;
    }
    
    public static TraktMovieStatus fromValue(String value) {
        return STRING_MAPPING.get(value);
    }
    
    @Override
    public String toString() {
        return value;
    }
}
