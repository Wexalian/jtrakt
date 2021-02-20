package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.endpoint.genres.TraktGenre;

import java.lang.reflect.Type;

public class TraktGenreTypeAdapter implements JsonSerializer<TraktGenre>, JsonDeserializer<TraktGenre> {
    public static TraktGenreTypeAdapter INSTANCE = new TraktGenreTypeAdapter();
    
    @Override
    public TraktGenre deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonPrimitive() && json.getAsJsonPrimitive().isString()) {
            return TraktGenre.fromSlug(json.getAsString());
        }
        else {
            return TraktGenre.fromSlug(json.getAsJsonObject().get("slug").getAsString());
        }
    }
    
    @Override
    public JsonElement serialize(TraktGenre src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getSlug());
    }
}
