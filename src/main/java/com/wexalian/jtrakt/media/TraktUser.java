package com.wexalian.jtrakt.media;

import com.google.gson.annotations.SerializedName;
import com.wexalian.jtrakt.media.info.TraktIds;

public class TraktUser
{
    private String username;
    @SerializedName("private")
    private boolean is_private;
    private String name;
    private boolean vip;
    private boolean vip_ep;
    private TraktIds ids;
    
    public String getUsername()
    {
        return username;
    }
    
    public boolean isPrivate()
    {
        return is_private;
    }
    
    public String getName()
    {
        return name;
    }
    
    public boolean isVip()
    {
        return vip;
    }
    
    public boolean isVipEp()
    {
        return vip_ep;
    }
    
    public TraktIds getIds()
    {
        return ids;
    }
}
