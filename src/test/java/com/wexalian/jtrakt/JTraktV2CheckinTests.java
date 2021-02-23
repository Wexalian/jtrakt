package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.checkin.TraktCheckinData;
import com.wexalian.jtrakt.endpoint.checkin.TraktCheckinItem;
import org.junit.jupiter.api.*;

@Tag("checkin")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JTraktV2CheckinTests extends JTraktV2Tests {
    
    @Tag(STAGING_TAG)
    @Order(1)
    @Test
    public void testCheckin() {
        TraktCheckinData data = new TraktCheckinData(EPISODE);
        TraktCheckinItem checkin = TRAKT.getCheckinEndpoint().checkin(data, ACCESS_TOKEN);
    
        Assertions.assertNotNull(checkin, "checkin is null");
    }
    
    @Tag(STAGING_TAG)
    @Order(2)
    @Test
    public void testDeleteAllCheckins() {
        TRAKT.getCheckinEndpoint().deleteAllCheckins(ACCESS_TOKEN);
    }
}
