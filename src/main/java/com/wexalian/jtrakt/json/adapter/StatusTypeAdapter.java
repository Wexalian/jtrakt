package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.media.info.Status;

import java.lang.reflect.Type;

public class StatusTypeAdapter implements JsonSerializer<Status>, JsonDeserializer<Status>
{
    public static StatusTypeAdapter INSTANCE = new StatusTypeAdapter();
    
    @Override
    public Status deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        return Status.fromValue(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(Status src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(src.toString());
    }
}
