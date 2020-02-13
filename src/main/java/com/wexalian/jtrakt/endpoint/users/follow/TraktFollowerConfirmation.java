package com.wexalian.jtrakt.endpoint.users.follow;

import com.wexalian.jtrakt.endpoint.users.TraktUser;

import java.time.OffsetDateTime;

public class TraktFollowerConfirmation
{
    private OffsetDateTime followed_at;
    private TraktUser user;
    
    public OffsetDateTime getFollowedAt()
    {
        return followed_at;
    }
    
    public TraktUser getUser()
    {
        return user;
    }
}
