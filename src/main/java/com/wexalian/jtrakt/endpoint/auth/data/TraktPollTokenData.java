package com.wexalian.jtrakt.endpoint.auth.data;

public class TraktPollTokenData {
    private final String code;
    private final String client_id;
    private final String client_secret;
    
    public TraktPollTokenData(String deviceCode, String clientId, String clientSecret) {
        this.code = deviceCode;
        this.client_id = clientId;
        this.client_secret = clientSecret;
    }
}
