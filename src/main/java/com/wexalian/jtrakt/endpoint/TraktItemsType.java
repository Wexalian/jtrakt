package com.wexalian.jtrakt.endpoint;

public enum TraktItemsType {
    ALL("all"),
    MOVIES("movies"),
    SHOWS("shows"),
    SEASONS("seasons"),
    EPISODES("episodes"),
    LISTS("lists"),
    COMMENTS("comments"),
    // PERSON("persons")
    ;
    
    // private static final Map<String, TraktItemsType> STRING_MAPPING = new HashMap<>();
    
    // static {
    //     for (TraktItemsType type : values()) {
    //         STRING_MAPPING.put(type.toString(), type);
    //     }
    // }
    
    private final String type;
    
    TraktItemsType(String type) {
        this.type = type;
    }
    
    // public static TraktItemsType fromValue(String value) {
    //     return STRING_MAPPING.get(value);
    // }
    
    @Override
    public String toString() {
        return type;
    }
}

