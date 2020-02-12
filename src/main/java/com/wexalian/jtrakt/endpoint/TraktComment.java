package com.wexalian.jtrakt.endpoint;

import java.time.OffsetDateTime;

public class TraktComment
{
    private int id;
    private int parent_id;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;
    private String comment;
    private boolean spoiler;
    private boolean review;
    private int replies;
    private int likes;
    private int user_rating;
    private TraktUser user;
    private TraktSharing sharing;
    
    public enum Sort
    {
        NEWEST("newest"),
        OLDEST("oldest"),
        LIKES("likes"),
        REPLIES("replies");
        
        private final String sort;
        
        Sort(String sort) {this.sort = sort;}
        
        @Override
        public String toString()
        {
            return sort;
        }
    }
    
    public enum Type
    {
        ALL("all"),
        REVIEWS("reviews"),
        SHOUTS("shouts");
        
        private final String type;
        
        Type(String type) {this.type = type;}
        
        @Override
        public String toString()
        {
            return type;
        }
    }
}