package com.wexalian.jtrakt.media.scrobble;

import com.wexalian.jtrakt.media.TraktMovie;
import com.wexalian.jtrakt.media.checkin.TraktSharing;
import com.wexalian.jtrakt.media.info.ScrobbleAction;

public class TraktScrobbleMovie
{
    private long id;
    private ScrobbleAction action;
    private TraktSharing sharing;
    private TraktMovie movie;
    
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
    
    public TraktMovie getMovie()
    {
        return movie;
    }
}
