package com.wexalian.jtrakt.endpoint.shows;

import java.time.OffsetDateTime;

public class TraktUpdatedShow {
    private OffsetDateTime updated_at;
    private TraktShow show;
    
    public OffsetDateTime getUpdatedAt() {
        return updated_at;
    }
    
    public TraktShow getShow() {
        return show;
    }
}
