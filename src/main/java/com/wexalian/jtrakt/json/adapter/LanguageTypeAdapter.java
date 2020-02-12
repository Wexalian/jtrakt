package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.endpoint.languages.TraktLanguage;

import java.lang.reflect.Type;

public class LanguageTypeAdapter implements JsonSerializer<TraktLanguage>, JsonDeserializer<TraktLanguage>
{
    public static LanguageTypeAdapter INSTANCE = new LanguageTypeAdapter();
    
    @Override
    public TraktLanguage deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        return TraktLanguage.fromCode(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(TraktLanguage src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(src.getCode());
    }
}
