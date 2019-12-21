package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;

public class JTraktV2Tests
{
    protected static final String API_KEY = "d37bc084cad26a17a8a4ae8bf01eb73262e9ae15823351257f87c335c69f466d";
    protected static final String CLIENT_SECRET = "ba0b07289702f71b73c3427503c5d62598bcd2d83e62d8e0d9b4496a4699c328";
    
    protected static final TraktAccessToken ACCESS_TOKEN = new TraktAccessToken("a698cc9c67a564172dd59928dadf16ce63ce2b4a66e40d392b66d894ecc11cbb", "8ee7d29b4997e37a6679ad7ca541d722495d40c010aa9c1c36df6ee7e98c46dd", 1576964470);
    protected static final JTraktV2 TRAKT = new JTraktV2(API_KEY, CLIENT_SECRET);
}
