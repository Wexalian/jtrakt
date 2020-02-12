package com.wexalian.jtrakt.endpoint.users;

import com.wexalian.jtrakt.endpoint.TraktUser;

import java.time.OffsetDateTime;

public class TraktFriend
{
    private OffsetDateTime friends_at;
    private TraktUser user;
    
    public OffsetDateTime getFriendsAt()
    {
        return friends_at;
    }
    
    public TraktUser getUser()
    {
        return user;
    }
}
