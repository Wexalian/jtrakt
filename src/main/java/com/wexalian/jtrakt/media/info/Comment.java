package com.wexalian.jtrakt.media.info;

import com.wexalian.jtrakt.media.TraktUser;

import java.time.OffsetDateTime;

public class Comment
{
    private int id;
    private String comment;
    private boolean spoiler;
    private boolean review;
    private int parent_id;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;
    private int replies;
    private int likes;
    private int user_rating;
    private TraktUser user;
    
    public enum Sort
    {
        NEWEST("newest"),
        OLDEST("oldest"),
        LIKES("likes"),
        REPLIES("replies");
        
        private final String sort;
        
        Sort(String sort) {this.sort = sort;}
        
        public String getSort()
        {
            return sort;
        }
        
        @Override
        public String toString()
        {
            return getSort();
        }
    }
}
