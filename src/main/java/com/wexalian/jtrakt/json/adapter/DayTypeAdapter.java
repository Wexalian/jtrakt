package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.endpoint.TraktAirsInfo;

import java.lang.reflect.Type;

public class DayTypeAdapter implements JsonSerializer<TraktAirsInfo.Day>, JsonDeserializer<TraktAirsInfo.Day> {
    public static DayTypeAdapter INSTANCE = new DayTypeAdapter();
    
    @Override
    public TraktAirsInfo.Day deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return TraktAirsInfo.Day.fromValue(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(TraktAirsInfo.Day src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }
}
