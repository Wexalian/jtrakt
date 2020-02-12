package com.wexalian.jtrakt.endpoint.comments;

import com.wexalian.jtrakt.endpoint.TraktComment;
import com.wexalian.jtrakt.endpoint.TraktItemFilterType;
import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Pagination;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class TraktCommentsEndpoint
{
    private final TraktHTTP http;
    
    public TraktCommentsEndpoint(TraktHTTP http)
    {
        this.http = http;
    }
    
    public TraktComment postComment(@Nonnull TraktPostCommentData data, @Nonnull TraktAccessToken accessToken)
    {
        TraktQuery query = TraktQuery.create("comments");
        
        return http.postAndParse(query, data, TraktTypeTokens.COMMENT, accessToken);
    }
    
    public TraktComment getComment(int commentId)
    {
        TraktQuery query = TraktQuery.create("comments/{id}")
                                     .path("id", commentId);
        
        return http.getAndParse(query, TraktTypeTokens.COMMENT);
    }
    
    public TraktComment updateComment(int commentId, @Nonnull TraktPostCommentData data, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("comments/{id}")
                                     .path("id", commentId);
        
        return http.postAndParse(query, data, TraktTypeTokens.COMMENT, token);
    }
    
    public void deleteComment(int commentId, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("comments/{id}")
                                     .path("id", commentId);
        
        http.delete(query, token);
    }
    
    public List<TraktComment> getReplies(int commentId, @Nullable Pagination pagination)
    {
        TraktQuery query = TraktQuery.create("comments/{id}/replies")
                                     .path("id", commentId)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.COMMENTS);
    }
    
    public TraktComment postReply(int commentId, @Nonnull TraktPostCommentData data, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("comments/{id}/replies")
                                     .path("id", commentId);
        
        return http.postAndParse(query, data, TraktTypeTokens.COMMENT, token);
    }
    
    public TraktAttachedMedia getAttachedMedia(int commentId, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("comments/{id}/item")
                                     .path("id", commentId)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.MEDIA);
    }
    
    public List<TraktCommentLike> getCommentLikes(int commentId, @Nullable Pagination pagination)
    {
        TraktQuery query = TraktQuery.create("comments/{id}/likes")
                                     .path("id", commentId)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.COMMENT_LIKES);
    }
    
    public void likeComment(int commentId, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("comments/{id}/like")
                                     .path("id", commentId);
        
        http.post(query, null, token);
    }
    
    public void deleteCommentLike(int commentId, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("comments/{id}/like")
                                     .path("id", commentId);
        
        http.delete(query, token);
    }
    
    public List<TraktItemComment> getTrendingComments(@Nonnull TraktComment.Type commentType, @Nonnull TraktItemType type, boolean includeReplies, @Nullable Pagination pagination, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("comments/trending/{comment_type}/{type}")
                                     .path("comment_type", commentType)
                                     .path("type", type)
                                     .query("include_replies", includeReplies)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.ITEM_COMMENTS);
    }
    
    public List<TraktItemComment> getRecentComments(@Nonnull TraktComment.Type commentType, @Nonnull TraktItemFilterType type, boolean includeReplies, @Nullable Pagination pagination, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("comments/recent/{comment_type}/{type}")
                                     .path("comment_type", commentType)
                                     .path("type", type)
                                     .query("include_replies", includeReplies)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.ITEM_COMMENTS);
    }
    
    public List<TraktItemComment> getUpdatesComments(@Nonnull TraktComment.Type commentType, @Nonnull TraktItemFilterType type, boolean includeReplies, @Nullable Pagination pagination, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("comments/updates/{comment_type}/{type}")
                                     .path("comment_type", commentType)
                                     .path("type", type)
                                     .query("include_replies", includeReplies)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.ITEM_COMMENTS);
    }
}
