package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;

import java.lang.reflect.Type;

public class TraktShowStatusTypeAdapter implements JsonSerializer<TraktShow.Status>, JsonDeserializer<TraktShow.Status> {
    public static TraktShowStatusTypeAdapter INSTANCE = new TraktShowStatusTypeAdapter();
    
    @Override
    public TraktShow.Status deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return TraktShow.Status.fromValue(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(TraktShow.Status src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }
}
