package com.wexalian.jtrakt.media.scrobble;

import com.wexalian.jtrakt.media.TraktShow;
import com.wexalian.jtrakt.media.checkin.TraktSharing;
import com.wexalian.jtrakt.media.info.ScrobbleAction;

public class TraktScrobbleShow
{
    private long id;
    private ScrobbleAction action;
    private TraktSharing sharing;
    private TraktShow movie;
    
    public long getId()
    {
        return id;
    }
    
    public ScrobbleAction getAction()
    {
        return action;
    }
    
    public TraktSharing getSharing()
    {
        return sharing;
    }
    
    public TraktShow getShow()
    {
        return movie;
    }
}
