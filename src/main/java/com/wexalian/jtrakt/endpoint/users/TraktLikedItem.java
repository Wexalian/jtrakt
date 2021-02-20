package com.wexalian.jtrakt.endpoint.users;

import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.endpoint.comments.TraktComment;
import com.wexalian.jtrakt.endpoint.lists.TraktList;

import java.time.OffsetDateTime;

public class TraktLikedItem {
    private OffsetDateTime liked_at;
    private TraktItemType type;
    
    private TraktComment comment;
    private TraktList list;
}
