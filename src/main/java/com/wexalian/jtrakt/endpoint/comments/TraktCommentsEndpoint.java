package com.wexalian.jtrakt.endpoint.comments;

import com.wexalian.jtrakt.endpoint.TraktItemFilterType;
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
    
    public TraktComment getComment(int id)
    {
        TraktQuery query = TraktQuery.create("comments/{id}")
                                     .path("id", id);
    
        return http.getAndParse(query, TraktTypeTokens.COMMENT);
    }
    
    public TraktComment updateComment(int id, @Nonnull TraktPostCommentData data, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("comments/{id}")
                                     .path("id", id);
        
        return http.postAndParse(query, data, TraktTypeTokens.COMMENT, token);
    }
    
    public void deleteComment(int id, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("comments/{id}")
                                     .path("id", id);
        
        http.delete(query, token);
    }
    
    public List<TraktComment> getReplies(int id, @Nullable Pagination pagination)
    {
        TraktQuery query = TraktQuery.create("comments/{id}/replies")
                                     .path("id", id)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.COMMENTS);
    }
    
    public TraktComment postReply(int id, @Nonnull TraktPostCommentData data, @Nonnull TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("comments/{id}/replies")
                                     .path("id", id);
        
        return http.postAndParse(query, data, TraktTypeTokens.COMMENT, token);
    }
    
    public TraktAttachedMedia getAttachedMedia(int id, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("comments/{id}/item")
                                     .path("id", id)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.MEDIA);
    }
    
    public List<TraktCommentLike> getCommentLikes(int id, @Nullable Pagination pagination)
    {
        TraktQuery query = TraktQuery.create("comments/{id}/likes")
                                     .path("id", id)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.COMMENT_LIKES);
    }
    
    public void likeComment(int id, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("comments/{id}/like")
                                     .path("id", id);
        
        http.post(query, null, token);
    }
    
    public void deleteCommentLike(int id, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("comments/{id}/like")
                                     .path("id", id);
        
        http.delete(query, token);
    }
    
    public List<TraktItemComment> getTrendingComments(@Nullable TraktComment.Type commentType, @Nullable TraktItemFilterType type, boolean includeReplies, @Nullable Pagination pagination, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("comments/trending/{comment_type}/{type}")
                                     .path("comment_type", commentType)
                                     .path("type", type)
                                     .query("include_replies", includeReplies)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.ITEM_COMMENTS);
    }
    
    public List<TraktItemComment> getRecentComments(@Nullable TraktComment.Type commentType, @Nullable TraktItemFilterType type, boolean includeReplies, @Nullable Pagination pagination, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("comments/recent/{comment_type}/{type}")
                                     .path("comment_type", commentType)
                                     .path("type", type)
                                     .query("include_replies", includeReplies)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.ITEM_COMMENTS);
    }
    
    public List<TraktItemComment> getUpdatesComments(@Nullable TraktComment.Type commentType, @Nullable TraktItemFilterType type, boolean includeReplies, @Nullable Pagination pagination, @Nullable Extended extended)
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
