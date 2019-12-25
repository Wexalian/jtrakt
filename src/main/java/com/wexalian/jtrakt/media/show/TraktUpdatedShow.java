package com.wexalian.jtrakt.media.show;

import com.wexalian.jtrakt.media.TraktShow;

import java.time.OffsetDateTime;

public class TraktUpdatedShow
{
    private OffsetDateTime updated_at;
    private TraktShow show;
    
    public OffsetDateTime getUpdatedAt()
    {
        return updated_at;
    }
    
    public TraktShow getShow()
    {
        return show;
    }
}
