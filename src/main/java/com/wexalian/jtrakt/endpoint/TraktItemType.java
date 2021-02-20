package com.wexalian.jtrakt.endpoint;

import java.util.HashMap;
import java.util.Map;

public enum TraktItemType {
    ALL("all"),
    MOVIE("movie"),
    SHOW("show"),
    SEASON("season"),
    EPISODE("episode"),
    LIST("list"),
    PERSON("person"),
    COMMENT("comment");
    
    private static final Map<String, TraktItemType> STRING_MAPPING = new HashMap<>();
    
    static {
        for (TraktItemType type : values()) {
            STRING_MAPPING.put(type.toString(), type);
        }
    }
    
    private final String type;
    
    TraktItemType(String type) {
        this.type = type;
    }
    
    public static TraktItemType fromValue(String value) {
        return STRING_MAPPING.get(value);
    }
    
    @Override
    public String toString() {
        return type;
    }
}
