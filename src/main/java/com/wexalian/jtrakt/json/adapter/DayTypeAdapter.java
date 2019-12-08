package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;
import com.wexalian.jtrakt.media.info.Day;

import java.lang.reflect.Type;

public class DayTypeAdapter implements JsonSerializer<Day>, JsonDeserializer<Day>
{
    public static DayTypeAdapter INSTANCE = new DayTypeAdapter();
    
    @Override
    public Day deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        return Day.fromValue(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(Day src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(src.toString());
    }
}
