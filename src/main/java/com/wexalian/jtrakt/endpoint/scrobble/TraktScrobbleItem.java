package com.wexalian.jtrakt.endpoint.scrobble;

import com.wexalian.jtrakt.endpoint.TraktMovie;
import com.wexalian.jtrakt.endpoint.TraktSharing;
import com.wexalian.jtrakt.endpoint.TraktShow;

public class TraktScrobbleItem
{
    private long id;
    private TraktScrobbleAction action;
    private TraktSharing sharing;
    private TraktMovie movie;
    private TraktShow show;
    
    public long getId()
    {
        return id;
    }
    
    public TraktScrobbleAction getAction()
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
