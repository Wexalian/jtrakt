package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.endpoint.scrobble.TraktScrobbleAction;

import java.lang.reflect.Type;

public class ScrobbleActionTypeAdapter implements JsonSerializer<TraktScrobbleAction>, JsonDeserializer<TraktScrobbleAction>
{
    public static ScrobbleActionTypeAdapter INSTANCE = new ScrobbleActionTypeAdapter();
    
    @Override
    public TraktScrobbleAction deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        return TraktScrobbleAction.get(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(TraktScrobbleAction src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(src.toString());
    }
}
