package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.scrobble.TraktScrobbleData;
import com.wexalian.jtrakt.endpoint.scrobble.TraktScrobbleItem;
import org.junit.jupiter.api.*;

@Tag("scrobble")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JTraktV2ScrobbleTests extends JTraktV2Tests {
    @Test
    @Tag(STAGING_TAG)
    @Order(1)
    public void testStart() {
        TraktScrobbleData data = new TraktScrobbleData(EPISODE, 1);
        TraktScrobbleItem start = TRAKT.getScrobbleEndpoint().start(data, ACCESS_TOKEN);
        
        Assertions.assertNotNull(start, "scrobble start returned null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(2)
    public void testPause() {
        TraktScrobbleData data = new TraktScrobbleData(EPISODE, 50);
        TraktScrobbleItem pause = TRAKT.getScrobbleEndpoint().pause(data, ACCESS_TOKEN);
        
        Assertions.assertNotNull(pause, "scrobble pause returned null");
    }
    
    @Test
    @Tag(STAGING_TAG)
    @Order(3)
    public void testStop() {
        TraktScrobbleData data = new TraktScrobbleData(EPISODE, 75);
        TraktScrobbleItem stop = TRAKT.getScrobbleEndpoint().stop(data, ACCESS_TOKEN);
        
        Assertions.assertNotNull(stop, "scrobble stop returned null");
    }
    
}