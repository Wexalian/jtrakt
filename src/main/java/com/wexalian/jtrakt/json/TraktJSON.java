package com.wexalian.jtrakt.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.wexalian.jtrakt.http.query.Genre;
import com.wexalian.jtrakt.http.query.Language;
import com.wexalian.jtrakt.json.adapter.*;
import com.wexalian.jtrakt.media.info.Day;
import com.wexalian.jtrakt.media.info.MediaType;
import com.wexalian.jtrakt.media.info.Status;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public class TraktJSON
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting()
                                                      .registerTypeAdapter(Day.class, DayTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(Genre.class, GenreTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(Language.class, LanguageTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(LocalTime.class, LocalTimeTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(MediaType.class, MediaTypeTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(OffsetDateTime.class, OffsetDateTimeTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(ScrobbleActionTypeAdapter.class, ScrobbleActionTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(Status.class, StatusTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(ZoneId.class, ZoneIdTypeAdapter.INSTANCE)
                                                      .create();
    
    public static <T> T fromJson(String json, TypeToken<T> typeToken)
    {
        return GSON.fromJson(json, typeToken.getType());
    }
    
    public static String toJson(Object src)
    {
        if (src == null) return "";
        return GSON.toJson(src);
    }
}
