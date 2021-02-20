package com.wexalian.jtrakt.endpoint.auth.data;

public class TraktRefreshTokenData {
    private final String refresh_token;
    private final String client_id;
    private final String client_secret;
    private final String redirect_url;
    private final String grant_type = "refresh_token";
    
    public TraktRefreshTokenData(String refresh_token, String client_id, String client_secret) {
        this(refresh_token, client_id, client_secret, "urn:ietf:wg:oauth:2.0:oob");
    }
    
    public TraktRefreshTokenData(String refresh_token, String client_id, String client_secret, String redirect_url) {
        this.refresh_token = refresh_token;
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.redirect_url = redirect_url;
    }
}
