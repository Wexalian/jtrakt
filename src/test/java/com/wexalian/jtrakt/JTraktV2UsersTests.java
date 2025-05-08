package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.endpoint.TraktItemsType;
import com.wexalian.jtrakt.endpoint.comments.TraktItemComment;
import com.wexalian.jtrakt.endpoint.lists.TraktList;
import com.wexalian.jtrakt.endpoint.sync.TraktSyncUpdate;
import com.wexalian.jtrakt.endpoint.sync.collection.TraktCollectionMovie;
import com.wexalian.jtrakt.endpoint.sync.collection.TraktCollectionShow;
import com.wexalian.jtrakt.endpoint.sync.watchlist.TraktWatchlistItem;
import com.wexalian.jtrakt.endpoint.users.*;
import com.wexalian.jtrakt.endpoint.users.follow.TraktFollowerConfirmation;
import com.wexalian.jtrakt.endpoint.users.follow.TraktFollowerRequest;
import com.wexalian.jtrakt.endpoint.users.hidden.TraktHiddenData;
import com.wexalian.jtrakt.endpoint.users.hidden.TraktHiddenItem;
import com.wexalian.jtrakt.http.query.Extended;
import org.junit.jupiter.api.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Tag("users")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JTraktV2UsersTests extends JTraktV2Tests {
    
    private List<Integer> listIds;
    private TraktList list;
    private int followerRequestId = -1;
    
    @Test
    void testSettings() {
        TraktSettings settings = TRAKT.getUsersEndpoint().getSettings(ACCESS_TOKEN);
        
        notNull(settings, "settings are null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(1)
    void testFollowerRequests() {
        List<TraktFollowerRequest> followerRequests = TRAKT.getUsersEndpoint().getFollowerRequests(ACCESS_TOKEN);
        
        notNull(followerRequests, "follower requests are null");
        
        if (followerRequests.size() > 0) {
            followerRequestId = followerRequests.get(0).getId();
        }
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(2)
    void testApproveFollowerRequest() {
        if (followerRequestId >= 0) {
            TraktFollowerConfirmation traktFollowerConfirmation = TRAKT.getUsersEndpoint()
                                                                       .approveFollowerRequest(followerRequestId,
                                                                                               ACCESS_TOKEN);
            notNull(traktFollowerConfirmation, "follower confirmation is null");
            
            followerRequestId = -1;
        }
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(3)
    void testDenyFollowerRequest() {
        if (followerRequestId >= 0) {
            TRAKT.getUsersEndpoint().denyFollowerRequest(followerRequestId, ACCESS_TOKEN);
        }
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(4)
    void testHideItems() {
        TraktHiddenData data = new TraktHiddenData();
        data.addShow(SHOW);
        
        TraktSyncUpdate traktSyncUpdate = TRAKT.getUsersEndpoint()
                                               .hideItems(TraktHiddenItem.Section.PROGRESS_WATCHED, data, ACCESS_TOKEN);
        
        notNull(traktSyncUpdate, "sync update is null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(5)
    void testHiddenItems() {
        List<TraktHiddenItem> hiddenItems = TRAKT.getUsersEndpoint()
                                                 .getHiddenItems(TraktHiddenItem.Section.PROGRESS_WATCHED,
                                                                 TraktItemType.SHOW,
                                                                 null,
                                                                 Extended.FULL,
                                                                 ACCESS_TOKEN);
        
        notNull(hiddenItems, "hidden items are null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(6)
    void testRemoveHiddenItems() {
        TraktHiddenData data = new TraktHiddenData();
        data.addShow(SHOW);
        
        TraktSyncUpdate traktSyncUpdate = TRAKT.getUsersEndpoint()
                                               .unhideItems(TraktHiddenItem.Section.PROGRESS_WATCHED,
                                                            data,
                                                            ACCESS_TOKEN);
        
        notNull(traktSyncUpdate, "sync update is null");
    }
    
    @Test
    void testLikes() {
        List<TraktLikedItem> likes = TRAKT.getUsersEndpoint().getLikes(TraktItemsType.COMMENTS, null, ACCESS_TOKEN);
        
        notNull(likes, "likes are null");
    }
    
    @Test
    void testProfile() {
        TraktUser myProfile = TRAKT.getUsersEndpoint().getProfile("me", Extended.VIP, ACCESS_TOKEN);
        
        notNull(myProfile, "my profile is null");
    }
    
    @Test
    void testMovieCollection() {
        List<TraktCollectionMovie> myMovieCollection = TRAKT.getUsersEndpoint()
                                                            .getMovieCollection("me", Extended.FULL, ACCESS_TOKEN);
        
        notNull(myMovieCollection, "my movie collection is null");
    }
    
    @Test
    void testShowCollection() {
        List<TraktCollectionShow> myShowCollection = TRAKT.getUsersEndpoint()
                                                          .getShowCollection("me", Extended.FULL, ACCESS_TOKEN);
        
        notNull(myShowCollection, "my show collection is null");
    }
    
    @Test
    void testComments() {
        List<TraktItemComment> myComments = TRAKT.getUsersEndpoint()
                                                 .getComments("me",
                                                              null,
                                                              TraktItemsType.SHOWS,
                                                              null,
                                                              null,
                                                              Extended.FULL,
                                                              ACCESS_TOKEN);
        
        notNull(myComments, "my comments are null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(7)
    void testCreateList() {
        TraktListInfo data = new TraktListInfo("Test List " + new Date().getTime(),
                                               "This is a test list",
                                               TraktList.Privacy.FRIENDS,
                                               false,
                                               true,
                                               TraktList.SortBy.ADDED,
                                               TraktList.SortHow.ASC);
        
        list = TRAKT.getUsersEndpoint().createList("me", data, ACCESS_TOKEN);
        
        notNull(list, "my new list is null");
    }
    
    @Test
    @Order(8)
    void testLists() {
        List<TraktList> myLists = TRAKT.getUsersEndpoint().getLists("me", ACCESS_TOKEN);
        
        notNull(myLists, "my lists are null");
        if (myLists.size() > 1) {
            listIds = myLists.stream().map(list -> list.getIds().getTraktId()).collect(Collectors.toList());
        }
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(9)
    void testReorderLists() {
        if (listIds != null && !listIds.isEmpty()) {
            Collections.shuffle(listIds);
            TraktListReorderUpdate update = TRAKT.getUsersEndpoint()
                                                 .reorderLists("me", listIds.toArray(Integer[]::new), ACCESS_TOKEN);
            
            notNull(update, "list reorder update is null");
        }
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(10)
    void testList() {
        if (list != null) {
            TraktList list = TRAKT.getUsersEndpoint()
                                  .getList("me", String.valueOf(this.list.getIds().getTraktId()), ACCESS_TOKEN);
            
            notNull(list, "copy of my list is null");
        }
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(11)
    void testUpdateList() {
        if (list != null) {
            
            TraktListInfo data = new TraktListInfo(null,
                                                   "This is an UPDATED test list",
                                                   TraktList.Privacy.PRIVATE,
                                                   true,
                                                   true,
                                                   TraktList.SortBy.RANK,
                                                   TraktList.SortHow.DESC);
            
            TraktList updatedList = TRAKT.getUsersEndpoint()
                                         .updateList("me",
                                                     String.valueOf(this.list.getIds().getTraktId()),
                                                     data,
                                                     ACCESS_TOKEN);
            
            notNull(updatedList, "updated list is null");
            list = updatedList;
        }
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(12)
    void testDeleteList() {
        if (list != null) {
            
            TRAKT.getUsersEndpoint().deleteList("me", String.valueOf(this.list.getIds().getTraktId()), ACCESS_TOKEN);
            list = null;
        }
    }
    
    @Test
    void testLikeList() {Assertions.fail();}
    
    @Test
    void testUnlikeList() {Assertions.fail();}
    
    @Test
    void testListItems() {Assertions.fail();}
    
    @Test
    void testAddListItems() {Assertions.fail();}
    
    @Test
    void testRemoveListItems() {Assertions.fail();}
    
    @Test
    void testReorderListItems() {Assertions.fail();}
    
    @Test
    void testListComments() {Assertions.fail();}
    
    @Test
    void testFollowUser() {Assertions.fail();}
    
    @Test
    void testUnfollowUser() {Assertions.fail();}
    
    @Test
    void testFollowers() {Assertions.fail();}
    
    @Test
    void testFollowing() {Assertions.fail();}
    
    @Test
    void testFriends() {Assertions.fail();}
    
    @Test
    void testHistory() {Assertions.fail();}
    
    @Test
    void testRatings() {Assertions.fail();}
    
    @Test
    void testWatchlist() {
        List<TraktWatchlistItem> watchlist = TRAKT.getUsersEndpoint()
                                                  .getWatchlist("me",
                                                                TraktItemsType.SHOWS,
                                                                "rank",
                                                                null,
                                                                Extended.FULL,
                                                                ACCESS_TOKEN);
        
        notNull(watchlist, "watchlist is null");
    }
    
    @Test
    void testCurrentlyWatching() {Assertions.fail();}
    
    @Test
    void testWatchedItems() {Assertions.fail();}
    
    @Test
    void testStats() {Assertions.fail();}
}
