package com.wexalian.jtrakt;

import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;

public class JTraktV2Tests
{
    protected static final String API_KEY = "d37bc084cad26a17a8a4ae8bf01eb73262e9ae15823351257f87c335c69f466d";
    protected static final String CLIENT_SECRET = "ba0b07289702f71b73c3427503c5d62598bcd2d83e62d8e0d9b4496a4699c328";
    
    protected static final TraktAccessToken ACCESS_TOKEN = new TraktAccessToken("8be02b32e7b28264f34906cd3c9f0fd2e4504a3eaba1187ea44a9fbdf36e962b", "8ef58ceec5afb4cc5449e9ea69b5d747be1e525d50a1fa09429984c8e54d654b", 1575833129);
    protected static final JTraktV2 TRAKT = new JTraktV2(API_KEY, CLIENT_SECRET);
}
