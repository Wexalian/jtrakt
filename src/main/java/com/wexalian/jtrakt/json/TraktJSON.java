package com.wexalian.jtrakt.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.wexalian.jtrakt.endpoint.TraktAirsInfo;
import com.wexalian.jtrakt.endpoint.TraktItemType;
import com.wexalian.jtrakt.endpoint.genres.TraktGenre;
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
                                                      .registerTypeAdapter(TraktGenre.class, TraktGenreTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(TraktLanguage.class, TraktLanguageTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(LocalTime.class, LocalTimeTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(TraktItemType.class, TraktItemTypeTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(OffsetDateTime.class, OffsetDateTimeTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(TraktScrobbleActionTypeAdapter.class, TraktScrobbleActionTypeAdapter.INSTANCE)
                                                      .registerTypeAdapter(TraktStatus.class, TraktStatusTypeAdapter.INSTANCE)
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
