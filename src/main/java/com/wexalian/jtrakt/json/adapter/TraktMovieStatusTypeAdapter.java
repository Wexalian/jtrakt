package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;

import java.lang.reflect.Type;

public class TraktMovieStatusTypeAdapter implements JsonSerializer<TraktMovie.Status>, JsonDeserializer<TraktMovie.Status> {
    public static TraktMovieStatusTypeAdapter INSTANCE = new TraktMovieStatusTypeAdapter();
    
    @Override
    public TraktMovie.Status deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return TraktMovie.Status.fromValue(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(TraktMovie.Status src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }
}
