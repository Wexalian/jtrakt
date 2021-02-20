package com.wexalian.jtrakt.endpoint.users;

import com.google.gson.annotations.SerializedName;
import com.wexalian.jtrakt.endpoint.TraktIds;

import java.time.OffsetDateTime;

public class TraktUser {
    private String username;
    @SerializedName("private")
    private boolean is_private;
    private String name;
    private boolean vip;
    private boolean vip_ep;
    private TraktIds ids;
    
    //extended
    private OffsetDateTime joined_at;
    private String location;
    private String about;
    private String gender;
    private int age;
    private Images images;
    private boolean vip_og;
    private int vip_years;
    
    public String getUsername() {
        return username;
    }
    
    public boolean isPrivate() {
        return is_private;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isVip() {
        return vip;
    }
    
    public boolean isVipEp() {
        return vip_ep;
    }
    
    public TraktIds getIds() {
        return ids;
    }
    
    private static class Images {
        private Avatar avatar;
        
        public Avatar getAvatar() {
            return avatar;
        }
        
        private static class Avatar {
            private String full;
            
            public String getFull() {
                return full;
            }
        }
    }
}
