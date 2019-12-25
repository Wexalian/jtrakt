package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.media.info.ScrobbleAction;

import java.lang.reflect.Type;

public class ScrobbleActionTypeAdapter implements JsonSerializer<ScrobbleAction>, JsonDeserializer<ScrobbleAction>
{
    public static ScrobbleActionTypeAdapter INSTANCE = new ScrobbleActionTypeAdapter();
    
    @Override
    public ScrobbleAction deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        return ScrobbleAction.get(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(ScrobbleAction src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(src.toString());
    }
}
