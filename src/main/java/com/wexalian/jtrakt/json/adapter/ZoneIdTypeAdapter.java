package com.wexalian.jtrakt.json.adapter;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.ZoneId;

public class ZoneIdTypeAdapter implements JsonSerializer<ZoneId>, JsonDeserializer<ZoneId> {
    public static ZoneIdTypeAdapter INSTANCE = new ZoneIdTypeAdapter();
    
    @Override
    public ZoneId deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return ZoneId.of(json.getAsString());
    }
    
    @Override
    public JsonElement serialize(ZoneId src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }
}
