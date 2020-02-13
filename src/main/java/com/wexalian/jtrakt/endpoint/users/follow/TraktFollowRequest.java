package com.wexalian.jtrakt.endpoint.users.follow;

import com.wexalian.jtrakt.endpoint.users.TraktUser;

import java.time.OffsetDateTime;

public class TraktFollowRequest
{
    private OffsetDateTime approved_at;
    private TraktUser user;
    
    public OffsetDateTime getApprovedAt()
    {
        return approved_at;
    }
    
    public TraktUser getUser()
    {
        return user;
    }
}
