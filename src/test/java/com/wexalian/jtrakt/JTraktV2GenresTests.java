package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktItemFilterType;
import com.wexalian.jtrakt.endpoint.genres.TraktGenre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

@Tag("genres")
public class JTraktV2GenresTests extends JTraktV2Tests {
    
    @Test
    public void testGenres() {
        List<TraktGenre> genres = TEST_TRAKT.getGenresEndpoint().getGenres(TraktItemFilterType.SHOWS);
        
        Assertions.assertNotNull(genres, "genres are null");
        Assertions.assertTrue(genres.size() > 0, "genres size is 0");
    }
}
