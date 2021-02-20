package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.endpoint.shows.TraktShowStatus;

import java.lang.reflect.Type;

public class TraktShowStatusTypeAdapter implements JsonSerializer<TraktShowStatus>, JsonDeserializer<TraktShowStatus> {
    public static TraktShowStatusTypeAdapter INSTANCE = new TraktShowStatusTypeAdapter();
    
    @Override
    public TraktShowStatus deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return TraktShowStatus.fromValue(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(TraktShowStatus src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }
}
