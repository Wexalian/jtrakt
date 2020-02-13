package com.wexalian.jtrakt.endpoint.users.follow;

import com.wexalian.jtrakt.endpoint.users.TraktUser;

import java.time.OffsetDateTime;

public class TraktFollowerRequest
{
    private int id;
    private OffsetDateTime requested_at;
    private TraktUser user;
    
    public int getId()
    {
        return id;
    }
    
    public OffsetDateTime getRequestedAt()
    {
        return requested_at;
    }
    
    public TraktUser getUser()
    {
        return user;
    }
}
