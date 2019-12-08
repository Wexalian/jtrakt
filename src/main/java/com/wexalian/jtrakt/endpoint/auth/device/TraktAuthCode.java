package com.wexalian.jtrakt.endpoint.auth.device;

public class TraktAuthCode
{
    private String device_code;
    private String user_code;
    private String verification_url;
    private int expires_in;
    private int interval;
    
    public String getDeviceCode()
    {
        return device_code;
    }
    
    public String getUserCode()
    {
        return user_code;
    }
    
    public String getVerificationUrl()
    {
        return verification_url;
    }
    
    public int getExpiresInSeconds()
    {
        return expires_in;
    }
    
    public int getInterval()
    {
        return interval;
    }
}
