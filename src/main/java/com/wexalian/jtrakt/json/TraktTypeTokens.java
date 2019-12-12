package com.wexalian.jtrakt.json;

import com.google.gson.reflect.TypeToken;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.endpoint.auth.device.TraktAuthCode;
import com.wexalian.jtrakt.media.TraktCast;
import com.wexalian.jtrakt.media.TraktEpisode;
import com.wexalian.jtrakt.media.TraktUser;
import com.wexalian.jtrakt.media.calender.TraktCalenderEpisode;
import com.wexalian.jtrakt.media.info.*;
import com.wexalian.jtrakt.media.show.TraktCollectionProgress;
import com.wexalian.jtrakt.media.show.TraktList;
import com.wexalian.jtrakt.media.show.TraktShow;
import com.wexalian.jtrakt.media.show.TraktWatchedProgress;

import java.util.List;

public final class TraktTypeTokens
{
    //general
    
    //oauth
    public static final TypeToken<TraktAccessToken> ACCESS_TOKEN = new TypeToken<>() {};
    
    //oauth device
    public static final TypeToken<TraktAuthCode> AUTH_CODE = new TypeToken<>() {};
    
    //calender
    public static final TypeToken<List<TraktCalenderEpisode>> CALENDER_EPISODE = new TypeToken<>() {};
    public static final TypeToken<List<TraktCalenderEpisode>> CALENDER_MOVIE = new TypeToken<>() {};
    
    //shows
    public static final TypeToken<List<TraktShow.Trending>> TRENDING_SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktShow>> SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktShow.Watched>> WATCHED_SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktShow.Listed>> LISTED_SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktShow.Updated>> UPDATED_SHOWS = new TypeToken<>() {};
    public static final TypeToken<TraktShow> SHOW = new TypeToken<>() {};
    public static final TypeToken<List<Alias>> ALIASES = new TypeToken<>() {};
    public static final TypeToken<List<Comment>> COMMENTS = new TypeToken<>() {};
    public static final TypeToken<List<TraktList>> LISTS = new TypeToken<>() {};
    public static final TypeToken<List<Translation>> TRANSLATIONS = new TypeToken<>() {};
    public static final TypeToken<TraktCollectionProgress.Show> COLLECTED_PROGRESS = new TypeToken<>() {};
    public static final TypeToken<TraktWatchedProgress.Show> WATCHED_PROGRESS = new TypeToken<>() {};
    public static final TypeToken<TraktCast> CAST = new TypeToken<>() {};
    public static final TypeToken<Ratings> RATINGS = new TypeToken<>() {};
    public static final TypeToken<Stats> STATS = new TypeToken<>() {};
    public static final TypeToken<List<TraktUser>> USERS = new TypeToken<>() {};
    
    //episodes
    public static final TypeToken<TraktEpisode> EPISODE = new TypeToken<>() {};
}
