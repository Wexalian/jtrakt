package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.http.query.Genre;

import java.lang.reflect.Type;

public class GenreTypeAdapter implements JsonSerializer<Genre>, JsonDeserializer<Genre>
{
    public static GenreTypeAdapter INSTANCE = new GenreTypeAdapter();
    
    @Override
    public Genre deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        return Genre.fromSlug(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(Genre src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(src.getSlug());
    }
}
