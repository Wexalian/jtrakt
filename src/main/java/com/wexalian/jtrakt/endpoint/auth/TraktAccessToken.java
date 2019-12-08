package com.wexalian.jtrakt.endpoint.auth;

public class TraktAccessToken
{
    private String access_token;
    private String refresh_token;
    private long created_at;
    
    public TraktAccessToken(String accessToken, String refreshToken, long createdAt)
    {
        this.access_token = accessToken;
        this.refresh_token = refreshToken;
        this.created_at = createdAt;
    }
    
    public String getAccessToken()
    {
        return access_token;
    }
    
    public String getRefreshToken()
    {
        return refresh_token;
    }
    
    public long getCreatedAt()
    {
        return created_at;
    }
}
