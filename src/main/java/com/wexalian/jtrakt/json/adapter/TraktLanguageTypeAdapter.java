package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.endpoint.languages.TraktLanguage;

import java.lang.reflect.Type;

public class TraktLanguageTypeAdapter implements JsonSerializer<TraktLanguage>, JsonDeserializer<TraktLanguage> {
    public static TraktLanguageTypeAdapter INSTANCE = new TraktLanguageTypeAdapter();
    
    @Override
    public TraktLanguage deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonPrimitive() && json.getAsJsonPrimitive().isString()) {
            return TraktLanguage.fromCode(json.getAsString());
        }
        else {
            return TraktLanguage.fromCode(json.getAsJsonObject().get("code").getAsString());
        }
    }
    
    @Override
    public JsonElement serialize(TraktLanguage src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getCode());
    }
}
