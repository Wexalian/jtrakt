package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktItemsType;
import com.wexalian.jtrakt.endpoint.genres.TraktGenre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

@Tag("genres")
public class JTraktV2GenresTests extends JTraktV2Tests {
    
    @Test
    public void testShowGenres() {
        List<TraktGenre> genres = TRAKT.getGenresEndpoint().getGenres(TraktItemsType.SHOWS);
        
        notNull(genres, "genres are null");
        Assertions.assertFalse(genres.isEmpty(), "genres size is 0");
        
        checkForUnused(genres);
    }
    
    private void checkForUnused(List<TraktGenre> genres) {
        for (TraktGenre genre : TraktGenre.values()) {
            if (!genres.contains(genre)) {
                System.out.println("Unused genre: " + genre.getSlug());
            }
        }
    }
    
    @Test
    public void testMovieGenres() {
        List<TraktGenre> genres = TRAKT.getGenresEndpoint().getGenres(TraktItemsType.MOVIES);
        
        notNull(genres, "genres are null");
        Assertions.assertFalse(genres.isEmpty(), "genres size is 0");
        
        checkForUnused(genres);
    }
}
