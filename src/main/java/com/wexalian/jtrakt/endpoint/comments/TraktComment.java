package com.wexalian.jtrakt.endpoint.comments;

import com.wexalian.jtrakt.endpoint.users.TraktUser;

import java.time.OffsetDateTime;

public class TraktComment {
    private int id;
    private int parent_id;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;
    private String comment;
    private boolean spoiler;
    private boolean review;
    private int replies;
    private int likes;
    private float user_rating;
    private TraktUser user;
    
    public int getId() {
        return id;
    }
    
    public int getParentId() {
        return parent_id;
    }
    
    public OffsetDateTime getCreatedAt() {
        return created_at;
    }
    
    public OffsetDateTime getUpdatedAt() {
        return updated_at;
    }
    
    public String getComment() {
        return comment;
    }
    
    public boolean isSpoiler() {
        return spoiler;
    }
    
    public boolean isReview() {
        return review;
    }
    
    public int getReplies() {
        return replies;
    }
    
    public int getLikes() {
        return likes;
    }
    
    public float getUserRating() {
        return user_rating;
    }
    
    public TraktUser getUser() {
        return user;
    }
    
    public enum Sort {
        NEWEST("newest"),
        OLDEST("oldest"),
        LIKES("likes"),
        REPLIES("replies");
        
        private final String sort;
        
        Sort(String sort) {this.sort = sort;}
        
        @Override
        public String toString() {
            return sort;
        }
    }
    
    public enum Type {
        ALL("all"),
        REVIEWS("reviews"),
        SHOUTS("shouts");
        
        private final String type;
        
        Type(String type) {this.type = type;}
        
        @Override
        public String toString() {
            return type;
        }
    }
}