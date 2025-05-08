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
        List<TraktLikedList> trendingLists = TRAKT.getListsEndpoint().getTrendingLists(null);
        
        notNull(trendingLists, "trending lists are null");
    }
    
    @Test
    public void testPopularLists() {
        List<TraktLikedList> popularLists = TRAKT.getListsEndpoint().getPopularLists(null);
        
        notNull(popularLists, "popular lists are null");
    }
    
    @Test
    public void testList() {
        TraktList list = TRAKT.getListsEndpoint().getList(LIST_ID);
        
        notNull(list, "list is null");
    }
    
    @Test
    public void testListLikes() {
        List<TraktLike> likes = TRAKT.getListsEndpoint().getListLikes(LIST_ID, null);
        
        notNull(likes, "likes are null");
    }
    
    @Test
    public void testListLike() {
        boolean success = TRAKT.getListsEndpoint().listLike(LIST_ID, ACCESS_TOKEN);
        
        Assertions.assertTrue(success);
    }
    
    @Test
    public void testListDeleteLike() {
        boolean success = TRAKT.getListsEndpoint().listDeleteLike(LIST_ID, ACCESS_TOKEN);
        
        Assertions.assertTrue(success);
    }
    
    @Test
    public void testListItems() {
        List<TraktListItem> items = TRAKT.getListsEndpoint().getListItems(LIST_ID, null, null, null);
        
        notNull(items, "items are null");
    }
    
    @Test
    public void testListComments() {
        List<TraktComment> comments = TRAKT.getListsEndpoint().getListComments(LIST_ID, null, null);
        
        notNull(comments, "comments are null");
    }
    
}
