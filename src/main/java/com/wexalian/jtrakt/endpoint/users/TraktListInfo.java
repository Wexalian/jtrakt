package com.wexalian.jtrakt.endpoint.users;

public class TraktListInfo {
    private final String name;
    private String description;
    private String privacy = "private";
    private boolean display_numbers = false;
    private boolean allow_comments = true;
    private String sort_by = "rank";
    private String sort_how = "asc";
    
    public TraktListInfo(String name) {
        this.name = name;
    }
    
    public TraktListInfo(String name, String description, String privacy, boolean display_numbers, boolean allow_comments, String sort_by, String sort_how) {
        this.name = name;
        this.description = description;
        this.privacy = privacy;
        this.display_numbers = display_numbers;
        this.allow_comments = allow_comments;
        this.sort_by = sort_by;
        this.sort_how = sort_how;
    }
}
