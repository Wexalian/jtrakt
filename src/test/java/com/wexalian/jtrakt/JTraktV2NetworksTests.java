package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.networks.TraktNetwork;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

@Tag("networks")
public class JTraktV2NetworksTests extends JTraktV2Tests {
    
    @Test
    public void testNetworks() {
        List<TraktNetwork> networks = TRAKT.getNetworksEndpoint().getNetworks();
        
        notNull(networks, "networks are null");
        Assertions.assertTrue(networks.size() > 0, "networks size is 0");
    }
}
