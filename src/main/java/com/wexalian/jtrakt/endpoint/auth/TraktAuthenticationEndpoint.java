package com.wexalian.jtrakt.endpoint.auth;

import com.google.common.base.Strings;
import com.wexalian.jtrakt.JTraktV2;
import com.wexalian.jtrakt.endpoint.auth.data.TraktAuthCode;
import com.wexalian.jtrakt.endpoint.auth.data.TraktClientID;
import com.wexalian.jtrakt.endpoint.auth.data.TraktPollTokenData;
import com.wexalian.jtrakt.endpoint.auth.data.TraktRefreshTokenData;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.BiConsumer;

public class TraktAuthenticationEndpoint {
    //TODO add method for revoking token
    //TODO add method for oauth2
    
    private final JTraktV2 jtrakt;
    private final TraktHTTP http;
    
    public TraktAuthenticationEndpoint(@Nonnull JTraktV2 jtrakt, @Nonnull TraktHTTP http) {
        this.jtrakt = jtrakt;
        this.http = http;
    }
    
    /**
     * @param codeVerificationUrlConsumer consumer that takes the user code and verification url, for the user to verify themselves with trakt.tv
     *
     * @return a valid TraktAccessToken, or null if something failed
     */
    @Nullable
    public TraktAccessToken setupDeviceOAuth(BiConsumer<String, String> codeVerificationUrlConsumer) {
        TraktClientID clientId = new TraktClientID(jtrakt.getClientId());
        TraktQuery codeQuery = TraktQuery.create("oauth/device/code");
        TraktAuthCode authCode = http.postAndParse(codeQuery, clientId, TraktTypeTokens.AUTH_CODE);
        
        codeVerificationUrlConsumer.accept(authCode.getUserCode(), authCode.getVerificationUrl());
        
        TraktPollTokenData data = new TraktPollTokenData(authCode.getDeviceCode(), jtrakt.getClientId(), jtrakt.getSecretId());
        TraktQuery tokenQuery = TraktQuery.create("oauth/device/token");
        
        for (int expires = 0; expires < authCode.getExpiresInSeconds(); expires += authCode.getInterval()) {
            TraktAccessToken token = http.postAndParse(tokenQuery, data, TraktTypeTokens.ACCESS_TOKEN);
            
            if (isAccessTokenEmpty(token)) {
                boolean interrupted = sleep(authCode.getInterval());
                if (interrupted) break;
            }
            else return token;
        }
        return null;
    }
    
    private boolean isAccessTokenEmpty(TraktAccessToken token) {
        return token == null || Strings.isNullOrEmpty(token.getAccessToken()) || Strings.isNullOrEmpty(token.getRefreshToken()) || token
                                                                                                                                       .getCreatedAt() <= 0;
    }
    
    private boolean sleep(int interval) {
        try {
            Thread.sleep(interval * 1000L);
            return false;
        }
        catch (InterruptedException e) {
            return true;
        }
    }
    
    @Nullable
    public TraktAccessToken refreshAccessToken(@Nonnull TraktAccessToken oldToken) {
        TraktRefreshTokenData data = new TraktRefreshTokenData(oldToken.getRefreshToken(), jtrakt.getClientId(), jtrakt.getSecretId());
        
        TraktQuery query = TraktQuery.create("oauth/token");
        return http.postAndParse(query, data, TraktTypeTokens.ACCESS_TOKEN);
    }
}
