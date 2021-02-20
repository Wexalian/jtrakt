package com.wexalian.jtrakt.endpoint.auth;

public class TraktAccessToken {
    private final String access_token;
    private final String refresh_token;
    private final long created_at;
    
    public TraktAccessToken(String access_token, String refresh_token, long created_at) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.created_at = created_at;
    }
    
    public String getAccessToken() {
        return access_token;
    }
    
    public String getRefreshToken() {
        return refresh_token;
    }
    
    public long getCreatedAt() {
        return created_at;
    }
}
