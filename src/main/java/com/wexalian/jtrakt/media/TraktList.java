package com.wexalian.jtrakt.media;

import com.wexalian.jtrakt.media.info.Ids;

import java.time.OffsetDateTime;

public class TraktList
{
    private String name;
    private String description;
    private String privacy;
    private boolean display_numbers;
    private boolean allow_comments;
    private String sort_by;
    private String sort_how;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;
    private int item_count;
    private int comment_count;
    private int likes;
    private Ids ids;
    private TraktUser user;
    
    public String getName()
    {
        return name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String getPrivacy()
    {
        return privacy;
    }
    
    public boolean isDisplayNumbers()
    {
        return display_numbers;
    }
    
    public boolean isAllowComments()
    {
        return allow_comments;
    }
    
    public String getSortBy()
    {
        return sort_by;
    }
    
    public String getSortHow()
    {
        return sort_how;
    }
    
    public OffsetDateTime getCreatedAt()
    {
        return created_at;
    }
    
    public OffsetDateTime getUpdatedAt()
    {
        return updated_at;
    }
    
    public int getItemCount()
    {
        return item_count;
    }
    
    public int getCommentCount()
    {
        return comment_count;
    }
    
    public int getLikes()
    {
        return likes;
    }
    
    public Ids getIds()
    {
        return ids;
    }
    
    public TraktUser getUser()
    {
        return user;
    }
}
