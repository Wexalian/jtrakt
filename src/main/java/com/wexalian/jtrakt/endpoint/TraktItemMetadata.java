package com.wexalian.jtrakt.endpoint;

import com.google.gson.annotations.SerializedName;

public class TraktItemMetadata
{
    private String media_type;
    private String resolution;
    private String hdr;
    private String audio;
    private String audio_channels;
    @SerializedName("3d")
    private boolean is3d;
    
    public String getMediaType()
    {
        return media_type;
    }
    
    public String getResolution()
    {
        return resolution;
    }
    
    public String getHdr()
    {
        return hdr;
    }
    
    public String getAudio()
    {
        return audio;
    }
    
    public String getAudioChannels()
    {
        return audio_channels;
    }
    
    public boolean isIs3d()
    {
        return is3d;
    }
}
