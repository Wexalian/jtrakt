package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.endpoint.TraktItemType;

import java.lang.reflect.Type;

public class MediaTypeTypeAdapter implements JsonSerializer<TraktItemType>, JsonDeserializer<TraktItemType>
{
    public static MediaTypeTypeAdapter INSTANCE = new MediaTypeTypeAdapter();
    
    @Override
    public TraktItemType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        return TraktItemType.fromValue(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(TraktItemType src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(src.toString());
    }
}
