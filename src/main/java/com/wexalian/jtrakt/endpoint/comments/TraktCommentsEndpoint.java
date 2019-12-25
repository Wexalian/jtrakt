package com.wexalian.jtrakt.endpoint.comments;

import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.endpoint.comments.data.TraktPostCommentData;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.http.query.Extended;
import com.wexalian.jtrakt.http.query.Pagination;
import com.wexalian.jtrakt.json.TraktTypeTokens;
import com.wexalian.jtrakt.media.*;
import com.wexalian.jtrakt.media.checkin.TraktSharing;
import com.wexalian.jtrakt.media.comment.TraktAttachedMedia;
import com.wexalian.jtrakt.media.comment.TraktCommentLike;
import com.wexalian.jtrakt.media.comment.TraktMediaComment;
import com.wexalian.jtrakt.media.info.MediaType;

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
    
    public TraktComment post(@Nonnull TraktMovie movie, @Nonnull String comment, boolean spoiler, @Nullable TraktSharing sharing, @Nonnull TraktAccessToken accessToken)
    {
        TraktPostCommentData data = new TraktPostCommentData(movie, comment, spoiler, sharing);
        TraktQuery query = TraktQuery.create("comments");
        
        return http.postAndParse(query, data, TraktTypeTokens.COMMENT, accessToken);
    }
    
    public TraktComment post(@Nonnull TraktShow show, @Nonnull String comment, boolean spoiler, @Nullable TraktSharing sharing, @Nonnull TraktAccessToken accessToken)
    {
        TraktPostCommentData data = new TraktPostCommentData(show, comment, spoiler, sharing);
        TraktQuery query = TraktQuery.create("comments");
        
        return http.postAndParse(query, data, TraktTypeTokens.COMMENT, accessToken);
    }
    
    public TraktComment post(@Nonnull TraktSeason season, @Nonnull String comment, boolean spoiler, @Nullable TraktSharing sharing, @Nonnull TraktAccessToken accessToken)
    {
        TraktPostCommentData data = new TraktPostCommentData(season, comment, spoiler, sharing);
        TraktQuery query = TraktQuery.create("comments");
        
        return http.postAndParse(query, data, TraktTypeTokens.COMMENT, accessToken);
    }
    
    public TraktComment post(@Nonnull TraktEpisode episode, @Nonnull String comment, boolean spoiler, @Nullable TraktSharing sharing, @Nonnull TraktAccessToken accessToken)
    {
        TraktPostCommentData data = new TraktPostCommentData(episode, comment, spoiler, sharing);
        TraktQuery query = TraktQuery.create("comments");
        
        return http.postAndParse(query, data, TraktTypeTokens.COMMENT, accessToken);
    }
    
    public TraktComment post(@Nonnull TraktList list, @Nonnull String comment, boolean spoiler, @Nullable TraktSharing sharing, @Nonnull TraktAccessToken accessToken)
    {
        TraktPostCommentData data = new TraktPostCommentData(list, comment, spoiler, sharing);
        TraktQuery query = TraktQuery.create("comments");
        
        return http.postAndParse(query, data, TraktTypeTokens.COMMENT, accessToken);
    }
    
    public TraktComment get(int commentId)
    {
        TraktQuery query = TraktQuery.create("comments/{id}")
                                     .path("id", commentId);
        
        return http.getAndParse(query, TraktTypeTokens.COMMENT);
    }
    
    public TraktComment update(int commentId, @Nonnull String comment, boolean spoiler, @Nonnull TraktAccessToken token)
    {
        TraktPostCommentData data = new TraktPostCommentData(comment, spoiler);
        
        TraktQuery query = TraktQuery.create("comments/{id}")
                                     .path("id", commentId);
        
        return http.postAndParse(query, data, TraktTypeTokens.COMMENT, token);
    }
    
    public void delete(int commentId, @Nonnull TraktAccessToken token)
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
    
    public TraktComment postReply(int commentId, @Nonnull String comment, boolean spoiler, @Nonnull TraktAccessToken token)
    {
        TraktPostCommentData data = new TraktPostCommentData(comment, spoiler);
        
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
    
    public List<TraktCommentLike> getLikes(int commentId, @Nullable Pagination pagination)
    {
        TraktQuery query = TraktQuery.create("comments/{id}/likes")
                                     .path("id", commentId)
                                     .query(pagination);
        
        return http.getAndParse(query, TraktTypeTokens.COMMENT_LIKES);
    }
    
    public void like(int commentId, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("comments/{id}/like")
                                     .path("id", commentId);
        
        http.post(query, null, token);
    }
    
    public void deleteLike(int commentId, @Nullable TraktAccessToken token)
    {
        TraktQuery query = TraktQuery.create("comments/{id}/like")
                                     .path("id", commentId);
        
        http.delete(query, token);
    }
    
    public List<TraktMediaComment> getTrending(@Nonnull TraktComment.Type commentType, @Nonnull MediaType type, boolean includeReplies, @Nullable Pagination pagination, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("comments/trending/{comment_type}/{type}")
                                     .path("comment_type", commentType)
                                     .path("type", type)
                                     .query("include_replies", includeReplies)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.MEDIA_COMMENTS);
    }
    
    public List<TraktMediaComment> getRecent(@Nonnull TraktComment.Type commentType, @Nonnull MediaType type, boolean includeReplies, @Nullable Pagination pagination, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("comments/recent/{comment_type}/{type}")
                                     .path("comment_type", commentType)
                                     .path("type", type)
                                     .query("include_replies", includeReplies)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.MEDIA_COMMENTS);
    }
    
    public List<TraktMediaComment> getUpdates(@Nonnull TraktComment.Type commentType, @Nonnull MediaType type, boolean includeReplies, @Nullable Pagination pagination, @Nullable Extended extended)
    {
        TraktQuery query = TraktQuery.create("comments/updates/{comment_type}/{type}")
                                     .path("comment_type", commentType)
                                     .path("type", type)
                                     .query("include_replies", includeReplies)
                                     .query(pagination)
                                     .query(extended);
        
        return http.getAndParse(query, TraktTypeTokens.MEDIA_COMMENTS);
    }
}
