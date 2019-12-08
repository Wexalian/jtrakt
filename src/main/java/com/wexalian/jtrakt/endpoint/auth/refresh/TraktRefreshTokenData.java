package com.wexalian.jtrakt.endpoint.auth.refresh;

public class TraktRefreshTokenData
{
    private String refresh_token;
    private String client_id;
    private String client_secret;
    private String redirect_url;
    private String grant_type = "refresh_token";
    
    public TraktRefreshTokenData(String refresh_token, String client_id, String client_secret)
    {
        this(refresh_token, client_id, client_secret, "urn:ietf:wg:oauth:2.0:oob");
    }
    
    public TraktRefreshTokenData(String refresh_token, String client_id, String client_secret, String redirect_url)
    {
        this.refresh_token = refresh_token;
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.redirect_url = redirect_url;
    }
}
