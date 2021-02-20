package com.wexalian.jtrakt.endpoint.users;

import java.util.List;

public class TraktListReorderUpdate {
    private int updated;
    private List<Integer> skipped_ids;
    
    public int getUpdated() {
        return updated;
    }
    
    public List<Integer> getSkippedIds() {
        return skipped_ids;
    }
}
