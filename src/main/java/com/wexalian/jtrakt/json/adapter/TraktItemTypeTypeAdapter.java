package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.endpoint.TraktItemType;

import java.lang.reflect.Type;

public class TraktItemTypeTypeAdapter implements JsonSerializer<TraktItemType>, JsonDeserializer<TraktItemType> {
    public static TraktItemTypeTypeAdapter INSTANCE = new TraktItemTypeTypeAdapter();
    
    @Override
    public TraktItemType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return TraktItemType.fromValue(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(TraktItemType src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }
}
