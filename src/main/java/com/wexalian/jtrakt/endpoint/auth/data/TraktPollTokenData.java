package com.wexalian.jtrakt.endpoint.auth.data;

public class TraktPollTokenData
{
    private String code;
    private String client_id;
    private String client_secret;
    
    public TraktPollTokenData(String deviceCode, String clientId, String clientSecret)
    {
        this.code = deviceCode;
        this.client_id = clientId;
        this.client_secret = clientSecret;
    }
}
