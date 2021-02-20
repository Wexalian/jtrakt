package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.checkin.TraktCheckinData;
import com.wexalian.jtrakt.endpoint.checkin.TraktCheckinItem;
import org.junit.jupiter.api.*;

@Tag("checkin")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JTraktV2CheckinTests extends JTraktV2Tests {
    
    @Tag("staging")
    @Order(1)
    @Test
    public void testCheckin() {
        TraktCheckinData data = new TraktCheckinData(TEST_EPISODE);
        TraktCheckinItem checkin = TEST_TRAKT.getCheckinEndpoint().checkin(data, TEST_ACCESS_TOKEN);
        
        Assertions.assertNotNull(checkin, "checkin is null");
    }
    
    @Tag("staging")
    @Order(2)
    @Test
    public void testDeleteAllCheckins() {
        TEST_TRAKT.getCheckinEndpoint().deleteAllCheckins(TEST_ACCESS_TOKEN);
    }
}
