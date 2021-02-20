package com.wexalian.jtrakt.endpoint.sync.activity;

import java.time.OffsetDateTime;

public class ShowActivity {
    private OffsetDateTime rated_at;
    private OffsetDateTime watchlisted_at;
    private OffsetDateTime commented_at;
    private OffsetDateTime hidden_at;
    
    public OffsetDateTime getRatedAt() {
        return rated_at;
    }
    
    public OffsetDateTime getWatchlistedAt() {
        return watchlisted_at;
    }
    
    public OffsetDateTime getCommentedAt() {
        return commented_at;
    }
    
    public OffsetDateTime getHiddenAt() {
        return hidden_at;
    }
}
