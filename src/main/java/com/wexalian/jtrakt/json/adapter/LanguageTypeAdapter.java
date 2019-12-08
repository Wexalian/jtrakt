package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.http.query.Language;

import java.lang.reflect.Type;

public class LanguageTypeAdapter implements JsonSerializer<Language>, JsonDeserializer<Language>
{
    public static LanguageTypeAdapter INSTANCE = new LanguageTypeAdapter();
    
    @Override
    public Language deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        return Language.fromCode(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(Language src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(src.getCode());
    }
}
