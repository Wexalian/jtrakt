package com.wexalian.jtrakt.endpoint.comments;

public class TraktCommentData {
    private final String comment;
    private final boolean spoiler;
    
    public TraktCommentData(String comment, boolean spoiler) {
        this.comment = comment;
        this.spoiler = spoiler;
    }
}
