package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.endpoint.movies.TraktMovieStatus;

import java.lang.reflect.Type;

public class TraktMovieStatusTypeAdapter implements JsonSerializer<TraktMovieStatus>, JsonDeserializer<TraktMovieStatus> {
    public static TraktMovieStatusTypeAdapter INSTANCE = new TraktMovieStatusTypeAdapter();
    
    @Override
    public TraktMovieStatus deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return TraktMovieStatus.fromValue(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(TraktMovieStatus src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }
}
