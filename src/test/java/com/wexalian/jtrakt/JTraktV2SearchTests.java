package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.endpoint.search.TraktIdType;
import com.wexalian.jtrakt.endpoint.search.TraktSearchItem;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

@Tag("search")
public class JTraktV2SearchTests extends JTraktV2Tests {
    
    @Test
    public void testTextQuery() {
        List<TraktSearchItem> items = TRAKT.getSearchEndpoint().textQuery(TraktItemType.SHOW, "arrow", null, null);
        
        notNull(items, "text query results are null");
    }
    
    @Test
    public void testIdLookup() {
        List<TraktSearchItem> items = TRAKT.getSearchEndpoint()
                                           .idLookup(TraktIdType.IMDB, "tt2193021", TraktItemType.SHOW, null, null);
        
        notNull(items, "id lookup results are null");
    }
    
}