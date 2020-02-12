package com.wexalian.jtrakt.endpoint.scrobble;

import java.util.HashMap;
import java.util.Map;

public enum TraktScrobbleAction
{
    START("start"),
    PAUSE("pause"),
    SCROBBLE("scrobble");
    
    private static final Map<String, TraktScrobbleAction> STRING_MAPPING = new HashMap<>();
    
    static
    {
        for (TraktScrobbleAction action : values())
        {
            STRING_MAPPING.put(action.toString(), action);
        }
    }
    
    private String action;
    
    TraktScrobbleAction(String action)
    {
        this.action = action;
    }
    
    @Override
    public String toString()
    {
        return action;
    }
    
    public static TraktScrobbleAction get(String action)
    {
        return STRING_MAPPING.get(action);
    }
}
