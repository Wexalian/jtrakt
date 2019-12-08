package com.wexalian.jtrakt.endpoint.auth;

import com.google.common.base.Strings;
import com.wexalian.jtrakt.JTraktV2;
import com.wexalian.jtrakt.endpoint.auth.device.TraktAuthCode;
import com.wexalian.jtrakt.endpoint.auth.device.TraktClientID;
import com.wexalian.jtrakt.endpoint.auth.device.TraktPollTokenData;
import com.wexalian.jtrakt.endpoint.auth.refresh.TraktRefreshTokenData;
import com.wexalian.jtrakt.http.TraktHTTP;
import com.wexalian.jtrakt.http.TraktQuery;
import com.wexalian.jtrakt.json.TraktTypeTokens;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Duration;
import java.util.function.Consumer;

public class TraktAuthentication
{
    private static final long ONE_MONTH_SECONDS = Duration.ofDays(31).getSeconds();
    
    private final JTraktV2 jtrakt;
    private final TraktHTTP http;
    
    public TraktAuthentication(@Nonnull JTraktV2 jtrakt, @Nonnull TraktHTTP http)
    {
        this.jtrakt = jtrakt;
        this.http = http;
    }
    
    @Nullable
    public TraktAccessToken setupDeviceOAuth(Consumer<String> userCodeConsumer, Consumer<String> verificationUrlConsumer)
    {
        // if (oldToken != null)
        // {
        //     long time = System.currentTimeMillis() - oldToken.getCreatedAt();
        //     if (time > ONE_MONTH_SECONDS)
        //     {
        //         return refreshAccessToken(oldToken);
        //     }
        //     return null;
        // }
        // else
        // {
        //request token
        
        TraktClientID clientId = new TraktClientID(jtrakt.getClientId());
        TraktQuery codeQuery = TraktQuery.create("oauth/device/code");
        TraktAuthCode authCode = http.postAndParse(codeQuery, clientId, TraktTypeTokens.AUTH_CODE);
        
        userCodeConsumer.accept(authCode.getUserCode());
        verificationUrlConsumer.accept(authCode.getVerificationUrl());
        
        TraktPollTokenData data = new TraktPollTokenData(authCode.getDeviceCode(), jtrakt.getClientId(), jtrakt.getSecretId());
        TraktQuery tokenQuery = TraktQuery.create("oauth/device/token");
        
        for (int expires = 0; expires < authCode.getExpiresInSeconds(); expires += authCode.getInterval())
        {
            TraktAccessToken token = http.postAndParse(tokenQuery, data, TraktTypeTokens.ACCESS_TOKEN);
            
            if (isAccessTokenEmpty(token))
            {
                try
                {
                    Thread.sleep(authCode.getInterval() * 1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                    return null;
                }
            }
            else return token;
        }
        return null;
    }
    
    private boolean isAccessTokenEmpty(TraktAccessToken token)
    {
        return token == null || Strings.isNullOrEmpty(token.getAccessToken()) || Strings.isNullOrEmpty(token.getRefreshToken()) || token.getCreatedAt() <= 0;
    }
    
    @Nullable
    public TraktAccessToken refreshAccessToken(@Nonnull TraktAccessToken oldToken)
    {
        TraktRefreshTokenData data = new TraktRefreshTokenData(oldToken.getRefreshToken(), jtrakt.getClientId(), jtrakt.getSecretId());
        
        TraktQuery query = TraktQuery.create("oauth/token");
        return http.postAndParse(query, data, TraktTypeTokens.ACCESS_TOKEN);
    }
}
