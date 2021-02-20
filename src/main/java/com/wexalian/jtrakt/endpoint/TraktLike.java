package com.wexalian.jtrakt.endpoint;

import com.wexalian.jtrakt.endpoint.users.TraktUser;

import java.time.OffsetDateTime;

public class TraktLike {
    private OffsetDateTime liked_at;
    private TraktUser user;
    
    public OffsetDateTime getLikedAt() {
        return liked_at;
    }
    
    public TraktUser getUser() {
        return user;
    }
}
