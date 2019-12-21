package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.media.info.MediaType;

import java.lang.reflect.Type;

public class MediaTypeTypeAdapter implements JsonSerializer<MediaType>, JsonDeserializer<MediaType>
{
    public static MediaTypeTypeAdapter INSTANCE = new MediaTypeTypeAdapter();
    
    @Override
    public MediaType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        return MediaType.fromValue(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(MediaType src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(src.toString());
    }
}
