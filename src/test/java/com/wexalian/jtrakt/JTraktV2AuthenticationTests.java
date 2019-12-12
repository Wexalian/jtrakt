package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class JTraktV2AuthenticationTests extends JTraktV2Tests
{
    @Test
    public void testDeviceAuth()
    {
        TraktAccessToken accessToken = TRAKT.getAuthentication()
                                            .setupDeviceOAuth(System.out::println, this::browse);
        
        System.out.println(accessToken);
    }
    
    private void browse(String url)
    {
        try
        {
            Desktop.getDesktop()
                   .browse(URI.create(url));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testRefreshToken()
    {
        TraktAccessToken accessToken = TRAKT.getAuthentication()
                                            .refreshAccessToken(ACCESS_TOKEN);
        
        System.out.println(accessToken);
    }
    
}
