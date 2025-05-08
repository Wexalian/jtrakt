package com.wexalian.jtrakt.endpoint.lists;

import com.wexalian.jtrakt.endpoint.TraktIds;
import com.wexalian.jtrakt.endpoint.users.TraktUser;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

public class TraktList {
    private String name;
    private String description;
    private Privacy privacy;
    private boolean display_numbers;
    private boolean allow_comments;
    private SortBy sort_by;
    private SortHow sort_how;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;
    private int item_count;
    private int comment_count;
    private int likes;
    private TraktIds ids;
    private TraktUser user;
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Privacy getPrivacy() {
        return privacy;
    }
    
    public boolean isDisplayNumbers() {
        return display_numbers;
    }
    
    public boolean isAllowComments() {
        return allow_comments;
    }
    
    public SortBy getSortBy() {
        return sort_by;
    }
    
    public SortHow getSortHow() {
        return sort_how;
    }
    
    public OffsetDateTime getCreatedAt() {
        return created_at;
    }
    
    public OffsetDateTime getUpdatedAt() {
        return updated_at;
    }
    
    public int getItemCount() {
        return item_count;
    }
    
    public int getCommentCount() {
        return comment_count;
    }
    
    public int getLikes() {
        return likes;
    }
    
    public TraktIds getIds() {
        return ids;
    }
    
    public TraktUser getUser() {
        return user;
    }
    
    public enum Type {
        ALL("all"),
        PERSONAL("personal"),
        OFFICIAL("official"),
        WATCHLISTS("watchlists"),
        RECOMMENDATIOND("recommendations");
        
        private final String type;
        
        Type(String type) {
            this.type = type;
        }
        
        @Override
        public String toString() {
            return type;
        }
    }
    
    public enum Sort {
        POPULAR("popular"),
        LIKES("likes"),
        COMMENTS("comments"),
        ITEMS("items"),
        ADDED("added"),
        UPDATED("updated");
        
        private final String sort;
        
        Sort(String sort) {
            this.sort = sort;
        }
        
        @Override
        public String toString() {
            return sort;
        }
    }
    
    public enum Privacy {
        PRIVATE("private"),
        FRIENDS("friends"),
        PUBLIC("public");
        
        private static final Map<String, Privacy> STRING_MAPPING = new HashMap<>();
        
        static {
            for (Privacy type : values()) {
                STRING_MAPPING.put(type.toString(), type);
            }
        }
        
        private final String type;
        
        Privacy(String type) {
            this.type = type;
        }
        
        public static Privacy fromValue(String value) {
            return STRING_MAPPING.get(value);
        }
        
        @Override
        public String toString() {
            return type;
        }
    }
    
    public enum SortBy {
        RANK("rank"),
        ADDED("added"),
        TITLE("title"),
        RELEASED("released"),
        RUNTIME("runtime"),
        POPULARITY("popularity"),
        PERCENTAGE("percentage"),
        VOTES("votes"),
        MY_RATING("my_rating"),
        RANDOM("random"),
        WATCHED("watched"),
        COLLECTED("collected");
        
        private static final Map<String, SortBy> STRING_MAPPING = new HashMap<>();
        
        static {
            for (SortBy type : values()) {
                STRING_MAPPING.put(type.toString(), type);
            }
        }
        
        private final String type;
        
        SortBy(String type) {
            this.type = type;
        }
        
        public static SortBy fromValue(String value) {
            return STRING_MAPPING.get(value);
        }
        
        @Override
        public String toString() {
            return type;
        }
    }
    
    public enum SortHow {
        ASC("asc"),
        DESC("desc");
        
        private static final Map<String, SortHow> STRING_MAPPING = new HashMap<>();
        
        static {
            for (SortHow type : values()) {
                STRING_MAPPING.put(type.toString(), type);
            }
        }
        
        private final String type;
        
        SortHow(String type) {
            this.type = type;
        }
        
        public static SortHow fromValue(String value) {
            return STRING_MAPPING.get(value);
        }
        
        @Override
        public String toString() {
            return type;
        }
    }
}
