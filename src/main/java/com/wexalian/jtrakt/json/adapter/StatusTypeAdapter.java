package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.endpoint.shows.TraktStatus;

import java.lang.reflect.Type;

public class StatusTypeAdapter implements JsonSerializer<TraktStatus>, JsonDeserializer<TraktStatus>
{
    public static StatusTypeAdapter INSTANCE = new StatusTypeAdapter();
    
    @Override
    public TraktStatus deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        return TraktStatus.fromValue(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(TraktStatus src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(src.toString());
    }
}
