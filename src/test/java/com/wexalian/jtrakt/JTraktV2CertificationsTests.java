package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktItemFilterType;
import com.wexalian.jtrakt.endpoint.certifications.TraktCertifications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("certifications")
public class JTraktV2CertificationsTests extends JTraktV2Tests {
    
    @Test
    public void testCertifications() {
        TraktCertifications certifications = TEST_TRAKT.getCertificationsEndpoint()
                                                       .getCertifications(TraktItemFilterType.MOVIES);
        
        Assertions.assertNotNull(certifications, "certifications are null");
        Assertions.assertNotNull(certifications.getUs(), "us certifications are null");
        Assertions.assertTrue(certifications.getUs().size() > 0, "us certifications size is 0");
    }
}
