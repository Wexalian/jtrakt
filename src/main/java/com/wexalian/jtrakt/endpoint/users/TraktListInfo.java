package com.wexalian.jtrakt.endpoint.users;

import com.wexalian.jtrakt.endpoint.lists.TraktList;

public class TraktListInfo {
    private final String name;
    private String description = "No description.";
    private TraktList.Privacy privacy = TraktList.Privacy.PRIVATE;
    private boolean display_numbers = false;
    private boolean allow_comments = false;
    private TraktList.SortBy sort_by = TraktList.SortBy.RANK;
    private TraktList.SortHow sort_how = TraktList.SortHow.ASC;
    
    public TraktListInfo(String name) {
        this.name = name;
    }
    
    public TraktListInfo(String name, String description, TraktList.Privacy privacy, boolean display_numbers, boolean allow_comments, TraktList.SortBy sort_by, TraktList.SortHow sort_how) {
        this.name = name;
        this.description = description;
        this.privacy = privacy;
        this.display_numbers = display_numbers;
        this.allow_comments = allow_comments;
        this.sort_by = sort_by;
        this.sort_how = sort_how;
    }
}
