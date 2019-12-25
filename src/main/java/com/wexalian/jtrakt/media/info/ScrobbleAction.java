package com.wexalian.jtrakt.media.info;

import java.util.HashMap;
import java.util.Map;

public enum ScrobbleAction
{
    START("start"),
    PAUSE("pause"),
    SCROBBLE("scrobble");
    
    private static final Map<String, ScrobbleAction> STRING_MAPPING = new HashMap<>();
    
    static
    {
        for (ScrobbleAction action : values())
        {
            STRING_MAPPING.put(action.toString(), action);
        }
    }
    
    private String action;
    
    ScrobbleAction(String action)
    {
        this.action = action;
    }
    
    @Override
    public String toString()
    {
        return action;
    }
    
    public static ScrobbleAction get(String action)
    {
        return STRING_MAPPING.get(action);
    }
}
