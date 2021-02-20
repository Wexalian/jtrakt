package com.wexalian.jtrakt.endpoint.sync.activity;

import java.time.OffsetDateTime;

public class CommentActivity {
    private OffsetDateTime liked_at;
    
    public OffsetDateTime getLikedAt() {
        return liked_at;
    }
}
