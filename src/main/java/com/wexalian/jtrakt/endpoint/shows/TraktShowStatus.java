package com.wexalian.jtrakt.endpoint.shows;

import java.util.HashMap;
import java.util.Map;

public enum TraktShowStatus {
    ENDED("ended"),
    RETURNING("returning series"),
    CANCELED("canceled"),
    IN_PRODUCTION("in production");
    
    private static final Map<String, TraktShowStatus> STRING_MAPPING = new HashMap<>();
    
    static {
        for (TraktShowStatus status : values()) {
            STRING_MAPPING.put(status.toString(), status);
        }
    }
    
    private final String value;
    
    TraktShowStatus(String value) {
        this.value = value;
    }
    
    public static TraktShowStatus fromValue(String value) {
        return STRING_MAPPING.get(value);
    }
    
    @Override
    public String toString() {
        return value;
    }
}
