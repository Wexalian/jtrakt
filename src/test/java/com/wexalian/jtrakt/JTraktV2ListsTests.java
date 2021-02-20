package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktLike;
import com.wexalian.jtrakt.endpoint.comments.TraktComment;
import com.wexalian.jtrakt.endpoint.lists.TraktLikedList;
import com.wexalian.jtrakt.endpoint.lists.TraktList;
import com.wexalian.jtrakt.endpoint.users.TraktListItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

@Tag("lists")
public class JTraktV2ListsTests extends JTraktV2Tests {
    
    @Test
    public void testTrendingLists() {
        List<TraktLikedList> trendingLists = TEST_TRAKT.getListsEndpoint().getTrendingLists(null);
        
        Assertions.assertNotNull(trendingLists, "trending lists are null");
    }
    
    @Test
    public void testPopularLists() {
        List<TraktLikedList> popularLists = TEST_TRAKT.getListsEndpoint().getPopularLists(null);
        
        Assertions.assertNotNull(popularLists, "popular lists are null");
    }
    
    @Test
    public void testList() {
        TraktList list = TEST_TRAKT.getListsEndpoint().getList(TEST_LIST_ID);
        
        Assertions.assertNotNull(list, "list is null");
    }
    
    @Test
    public void testListLikes() {
        List<TraktLike> likes = TEST_TRAKT.getListsEndpoint().getListLikes(TEST_LIST_ID, null);
        
        Assertions.assertNotNull(likes, "likes are null");
    }
    
    @Test
    public void testListItems() {
        List<TraktListItem> items = TEST_TRAKT.getListsEndpoint().getListItems(TEST_LIST_ID, null, null, null);
        
        Assertions.assertNotNull(items, "items are null");
    }
    
    @Test
    public void testListComments() {
        List<TraktComment> comments = TEST_TRAKT.getListsEndpoint().getListComments(TEST_LIST_ID, null, null);
        
        Assertions.assertNotNull(comments, "comments are null");
    }
    
}
