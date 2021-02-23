package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.lists.TraktList;
import com.wexalian.jtrakt.endpoint.people.TraktMovieCredits;
import com.wexalian.jtrakt.endpoint.people.TraktPerson;
import com.wexalian.jtrakt.endpoint.people.TraktShowCredits;
import com.wexalian.jtrakt.http.query.Extended;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

@Tag("people")
public class JTraktV2PeopleTests extends JTraktV2Tests {
    
    @Test
    public void testPerson() {
        TraktPerson person = TRAKT.getPeopleEndpoint().getSummary("stephen-amell", Extended.FULL);
        
        Assertions.assertNotNull(person, "person is null");
    }
    
    @Test
    public void testMovies() {
        TraktMovieCredits credits = TRAKT.getPeopleEndpoint().getMovieCredits("stephen-amell", null);
        
        Assertions.assertNotNull(credits, "movie credits are null");
    }
    
    @Test
    public void testShows() {
        TraktShowCredits credits = TRAKT.getPeopleEndpoint().getShowCredits("stephen-amell", null);
        
        Assertions.assertNotNull(credits, "show credits are null");
    }
    
    @Test
    public void testLists() {
        List<TraktList> lists = TRAKT.getPeopleEndpoint().getLists("stephen-amell", null, null, null);
        
        Assertions.assertNotNull(lists, "people lists are null");
    }
}