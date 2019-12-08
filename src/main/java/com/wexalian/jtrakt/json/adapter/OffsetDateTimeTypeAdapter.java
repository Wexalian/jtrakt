package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeTypeAdapter implements JsonSerializer<OffsetDateTime>, JsonDeserializer<OffsetDateTime>
{
    public static OffsetDateTimeTypeAdapter INSTANCE = new OffsetDateTimeTypeAdapter();
    
    @Override
    public OffsetDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        return OffsetDateTime.parse(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(OffsetDateTime src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(src.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
    }
}
