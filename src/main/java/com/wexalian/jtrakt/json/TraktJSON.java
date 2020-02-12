package com.wexalian.jtrakt.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.wexalian.jtrakt.endpoint.Genre;
import com.wexalian.jtrakt.endpoint.TraktAirsInfo;
import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.endpoint.languages.TraktLanguage;
import com.wexalian.jtrakt.endpoint.shows.TraktStatus;
import com.wexalian.jtrakt.json.adapter.*;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public class TraktJSON
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting()
                                                      .registerTypeAdapter(TraktAirsInfo.Day.class, DayTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(Genre.class, GenreTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(TraktLanguage.class, LanguageTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(LocalTime.class, LocalTimeTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(TraktItemType.class, MediaTypeTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(OffsetDateTime.class, OffsetDateTimeTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(ScrobbleActionTypeAdapter.class, ScrobbleActionTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(TraktStatus.class, StatusTypeAdapter.INSTANCE)
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
