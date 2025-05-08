package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.endpoint.lists.TraktList;

import java.lang.reflect.Type;

public class TraktListPrivacyTypeAdapter implements JsonSerializer<TraktList.Privacy>, JsonDeserializer<TraktList.Privacy> {
    public static TraktListPrivacyTypeAdapter INSTANCE = new TraktListPrivacyTypeAdapter();
    
    @Override
    public TraktList.Privacy deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return TraktList.Privacy.fromValue(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(TraktList.Privacy src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }
}
