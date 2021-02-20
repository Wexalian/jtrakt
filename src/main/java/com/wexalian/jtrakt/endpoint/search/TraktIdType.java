package com.wexalian.jtrakt.endpoint.search;

import java.util.HashMap;
import java.util.Map;

public enum TraktIdType {
    TRAKT("trakt"),
    IMDB("imdb"),
    TMDB("tmdb"),
    TVDB("tvdb");
    
    private static final Map<String, TraktIdType> STRING_MAPPING = new HashMap<>();
    
    static {
        for (TraktIdType type : values()) {
            STRING_MAPPING.put(type.toString(), type);
        }
    }
    
    private final String type;
    
    TraktIdType(String type) {
        this.type = type;
    }
    
    public static TraktIdType get(String value) {
        return STRING_MAPPING.get(value);
    }
    
    @Override
    public String toString() {
        return type;
    }
}
