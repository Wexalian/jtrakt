package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktItemFilterType;
import com.wexalian.jtrakt.endpoint.TraktLike;
import com.wexalian.jtrakt.endpoint.comments.*;
import org.junit.jupiter.api.*;

import java.util.List;

@Tag("comments")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JTraktV2CommentsTests extends JTraktV2Tests {
    
    private int commentId;
    
    @Test
    public void testGetComment() {
        TraktComment comment = TRAKT.getCommentsEndpoint().getComment(1);
        
        Assertions.assertNotNull(comment, "get comment is null");
    }
    
    @Test
    public void testGetReplies() {
        List<TraktComment> commentReplies = TRAKT.getCommentsEndpoint().getReplies(1, null);
        
        Assertions.assertNotNull(commentReplies, "comment replies are null");
    }
    
    @Test
    public void testAttachedMedia() {
        TraktAttachedMediaItem media = TRAKT.getCommentsEndpoint().getAttachedMedia(1, null);
        
        Assertions.assertNotNull(media, "attached comment media item is null");
    }
    
    @Test
    public void testCommentLikes() {
        List<TraktLike> likes = TRAKT.getCommentsEndpoint().getCommentLikes(1, null);
        
        Assertions.assertNotNull(likes, "comment likes are null");
    }
    
    @Test
    public void testTrendingComments() {
        List<TraktItemComment> trendingComments = TRAKT.getCommentsEndpoint()
                                                       .getTrendingComments(TraktComment.Type.ALL, TraktItemFilterType.SHOWS, false, null, null);
    
        Assertions.assertNotNull(trendingComments, "trending comments are null");
        Assertions.assertTrue(trendingComments.size() > 0, "trending comments are empty");
    }
    
    @Test
    public void testRecentComments() {
        List<TraktItemComment> recentComments = TRAKT.getCommentsEndpoint()
                                                     .getRecentComments(TraktComment.Type.ALL, TraktItemFilterType.SHOWS, false, null, null);
    
        Assertions.assertNotNull(recentComments, "recent comments are null");
        Assertions.assertTrue(recentComments.size() > 0, "recent comments are empty");
    }
    
    @Test
    public void testCommentUpdates() {
        List<TraktItemComment> commentUpdates = TRAKT.getCommentsEndpoint()
                                                     .getCommentUpdates(TraktComment.Type.ALL, TraktItemFilterType.SHOWS, false, null, null);
    
        Assertions.assertNotNull(commentUpdates, "comment updates are null");
        Assertions.assertTrue(commentUpdates.size() > 0, "comment updates are empty");
    }
    
    @Tag(STAGING_TAG)
    @Order(1)
    @Test
    public void testPostComment() {
        TraktNewCommentData data = new TraktNewCommentData(EPISODE, "This is a test comment, because the staging API has been down for quite a while now and I need to test my code :/", false, null);
        TraktComment comment = TRAKT.getCommentsEndpoint().postComment(data, ACCESS_TOKEN);
        commentId = comment.getId();
        
        Assertions.assertNotNull(comment, "post comment is null");
        
    }
    
    @Tag(STAGING_TAG)
    @Order(2)
    @Test
    public void testUpdateComment() {
        TraktCommentData data = new TraktCommentData("This is an updated test comment, because the staging API has been down for quite a while now!...", false);
        TraktComment comment = TRAKT.getCommentsEndpoint().updateComment(commentId, data, ACCESS_TOKEN);
        
        Assertions.assertNotNull(comment, "updated comment is null");
    }
    
    @Tag(STAGING_TAG)
    @Order(3)
    @Test
    public void testPostReply() {
        TraktCommentData data = new TraktCommentData("This is a test reply, because the staging API has been down for a really long time!...", false);
        TraktComment reply = TRAKT.getCommentsEndpoint().postReply(commentId, data, ACCESS_TOKEN);
        
        Assertions.assertNotNull(reply, "reply is null");
    }
    
    @Tag(STAGING_TAG)
    @Order(4)
    @Test
    public void testLikeComment() {
        TRAKT.getCommentsEndpoint().likeComment(commentId, ACCESS_TOKEN);
    }
    
    @Tag(STAGING_TAG)
    @Order(5)
    @Test
    public void testDeleteCommentLike() {
        TRAKT.getCommentsEndpoint().deleteCommentLike(commentId, ACCESS_TOKEN);
    }
    
    @Tag(STAGING_TAG)
    @Order(6)
    @Test
    public void testDeleteComment() {
        TRAKT.getCommentsEndpoint().deleteComment(commentId, ACCESS_TOKEN);
    }
    
}
