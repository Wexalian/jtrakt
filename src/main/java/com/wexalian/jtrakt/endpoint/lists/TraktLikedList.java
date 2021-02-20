package com.wexalian.jtrakt.endpoint.lists;

public class TraktLikedList {
    private int like_count;
    private int comment_count;
    private TraktList list;
    
    public int getLikeCount() {
        return like_count;
    }
    
    public int getCommentCount() {
        return comment_count;
    }
    
    public TraktList getList() {
        return list;
    }
}
