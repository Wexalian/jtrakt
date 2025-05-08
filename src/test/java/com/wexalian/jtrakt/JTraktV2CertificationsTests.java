package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.TraktItemsType;
import com.wexalian.jtrakt.endpoint.certifications.TraktCertifications;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Tag("certifications")
public class JTraktV2CertificationsTests extends JTraktV2Tests {
    
    @Test
    public void testCertifications() {
        TraktCertifications certifications = TRAKT.getCertificationsEndpoint().getCertifications(TraktItemsType.SHOWS);
        
        assertNotNull(certifications, "certifications are null");
        assertNotNull(certifications.getUs(), "us certifications are null");
        assertFalse(certifications.getUs().isEmpty(), "us certifications size is 0");
    }
}
