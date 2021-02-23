package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.json.TraktJSON;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

@Tag("auth")
public class JTraktV2AuthenticationTests extends JTraktV2Tests {
    
    @Test
    @Order(1)
    public void testDeviceAuth() {
        TraktAccessToken accessToken = TRAKT.getAuthenticationEndpoint().setupDeviceOAuth((code, url) -> {
            Assertions.assertNotEquals("", code, "authentication code is empty");
            Assertions.assertNotEquals("", url, "authentication url is empty");
    
            System.out.println(code);
            browse(url);
        });
        
        Assertions.assertNotEquals(null, accessToken);
        System.out.println("Auth: " + TraktJSON.toJson(accessToken));
    }
    
    private void browse(String url) {
        try {
            Desktop.getDesktop().browse(URI.create(url));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    @Order(2)
    public void testRefreshToken() {
        TraktAccessToken accessToken = TRAKT.getAuthenticationEndpoint().refreshAccessToken(ACCESS_TOKEN);
        
        Assertions.assertNotEquals(null, accessToken);
        System.out.println("Refresh: " + TraktJSON.toJson(accessToken));
    }
}
