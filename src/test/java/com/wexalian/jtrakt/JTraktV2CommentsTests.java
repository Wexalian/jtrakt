package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktItemsType;
import com.wexalian.jtrakt.endpoint.TraktLike;
import com.wexalian.jtrakt.endpoint.comments.*;
import org.junit.jupiter.api.*;

import java.util.List;

@Tag("comments")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JTraktV2CommentsTests extends JTraktV2Tests {
    
    private int commentId = 731203;
    
    @Test
    public void testGetComment() {
        TraktComment comment = TRAKT.getCommentsEndpoint().getComment(1);
        
        notNull(comment, "get comment is null");
    }
    
    @Test
    public void testGetReplies() {
        List<TraktComment> commentReplies = TRAKT.getCommentsEndpoint().getReplies(1, null);
        
        notNull(commentReplies, "comment replies are null");
    }
    
    @Test
    public void testAttachedMedia() {
        TraktAttachedMediaItem media = TRAKT.getCommentsEndpoint().getAttachedMedia(1, null);
        
        notNull(media, "attached comment media item is null");
    }
    
    @Test
    public void testCommentLikes() {
        List<TraktLike> likes = TRAKT.getCommentsEndpoint().getCommentLikes(1, null);
        
        notNull(likes, "comment likes are null");
    }
    
    @Test
    public void testTrendingComments() {
        List<TraktItemComment> trendingComments = TRAKT.getCommentsEndpoint()
                                                       .getTrendingComments(TraktComment.Type.ALL,
                                                                            TraktItemsType.SHOWS,
                                                                            false,
                                                                            null,
                                                                            null);
        
        notNull(trendingComments, "trending comments are null");
        Assertions.assertFalse(trendingComments.isEmpty(), "trending comments are empty");
    }
    
    @Test
    public void testRecentComments() {
        List<TraktItemComment> recentComments = TRAKT.getCommentsEndpoint()
                                                     .getRecentComments(TraktComment.Type.ALL,
                                                                        TraktItemsType.SHOWS,
                                                                        false,
                                                                        null,
                                                                        null);
        
        notNull(recentComments, "recent comments are null");
        Assertions.assertFalse(recentComments.isEmpty(), "recent comments are empty");
    }
    
    @Test
    public void testCommentUpdates() {
        List<TraktItemComment> commentUpdates = TRAKT.getCommentsEndpoint()
                                                     .getCommentUpdates(TraktComment.Type.ALL,
                                                                        TraktItemsType.SHOWS,
                                                                        false,
                                                                        null,
                                                                        null);
        
        notNull(commentUpdates, "comment updates are null");
        Assertions.assertFalse(commentUpdates.isEmpty(), "comment updates are empty");
    }
    
    @Tag(STAGING_TAG)
    @Order(1)
    @Test
    public void testPostComment() {
        TraktNewCommentData data = new TraktNewCommentData(EPISODE, "This is a test comment for jtrakt", false, null);
        TraktComment comment = TRAKT.getCommentsEndpoint().postComment(data, ACCESS_TOKEN);
        commentId = comment.getId();
        
        notNull(comment, "post comment is null");
    }
    
    @Tag(STAGING_TAG)
    @Order(2)
    @Test
    public void testUpdateComment() {
        TraktCommentData data = new TraktCommentData("This is an updated test comment, because the staging API has been down for quite a while now!...", false);
        TraktComment comment = TRAKT.getCommentsEndpoint().updateComment(commentId, data, ACCESS_TOKEN);
        
        notNull(comment, "updated comment is null");
    }
    
    @Tag(STAGING_TAG)
    @Order(3)
    @Test
    public void testPostReply() {
        TraktCommentData data = new TraktCommentData("This is a test reply, because the staging API has been down for a really long time!...", false);
        TraktComment reply = TRAKT.getCommentsEndpoint().postReply(commentId, data, ACCESS_TOKEN);
        
        notNull(reply, "reply is null");
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
        TRAKT.getCommentsEndpoint().deleteComment(808763, ACCESS_TOKEN);
    }
    
}
