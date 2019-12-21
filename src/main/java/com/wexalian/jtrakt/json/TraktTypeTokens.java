package com.wexalian.jtrakt.json;

import com.google.gson.reflect.TypeToken;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.endpoint.auth.data.TraktAuthCode;
import com.wexalian.jtrakt.media.*;
import com.wexalian.jtrakt.media.calender.TraktCalendarEpisode;
import com.wexalian.jtrakt.media.calender.TraktCalendarMovie;
import com.wexalian.jtrakt.media.checkin.TraktCheckinEpisode;
import com.wexalian.jtrakt.media.checkin.TraktCheckinMovie;
import com.wexalian.jtrakt.media.comment.TraktAttachedMedia;
import com.wexalian.jtrakt.media.comment.TraktCommentLike;
import com.wexalian.jtrakt.media.comment.TraktMediaComment;
import com.wexalian.jtrakt.media.info.Alias;
import com.wexalian.jtrakt.media.info.Ratings;
import com.wexalian.jtrakt.media.info.Stats;
import com.wexalian.jtrakt.media.info.Translation;
import com.wexalian.jtrakt.media.show.TraktCollectionProgress;
import com.wexalian.jtrakt.media.show.TraktWatchedProgress;

import java.util.List;

public final class TraktTypeTokens
{
    //general
    public static final TypeToken<TraktShow> SHOW = new TypeToken<>() {};
    public static final TypeToken<TraktEpisode> EPISODE = new TypeToken<>() {};
    public static final TypeToken<TraktComment> COMMENT = new TypeToken<>() {};
    public static final TypeToken<TraktCast> CAST = new TypeToken<>() {};
    public static final TypeToken<TraktAttachedMedia> MEDIA = new TypeToken<>() {};
    
    //oauth
    public static final TypeToken<TraktAccessToken> ACCESS_TOKEN = new TypeToken<>() {};
    
    //oauth device
    public static final TypeToken<TraktAuthCode> AUTH_CODE = new TypeToken<>() {};
    
    //calender
    public static final TypeToken<List<TraktCalendarEpisode>> CALENDAR_EPISODES = new TypeToken<>() {};
    public static final TypeToken<List<TraktCalendarMovie>> CALENDAR_MOVIES = new TypeToken<>() {};
    
    //checkin
    public static final TypeToken<TraktCheckinMovie> CHECKIN_MOVIE = new TypeToken<>() {};
    public static final TypeToken<TraktCheckinEpisode> CHECKIN_EPISODE = new TypeToken<>() {};
    
    //comments
    public static final TypeToken<List<TraktCommentLike>> COMMENT_LIKES = new TypeToken<>() {};
    public static final TypeToken<List<TraktMediaComment>> MEDIA_COMMENTS = new TypeToken<>() {};
    
    //shows
    public static final TypeToken<List<TraktShow.Trending>> TRENDING_SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktShow>> SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktShow.Watched>> WATCHED_SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktShow.Listed>> LISTED_SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktShow.Updated>> UPDATED_SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<Alias>> ALIASES = new TypeToken<>() {};
    public static final TypeToken<List<TraktComment>> COMMENTS = new TypeToken<>() {};
    public static final TypeToken<List<TraktList>> LISTS = new TypeToken<>() {};
    public static final TypeToken<List<Translation>> TRANSLATIONS = new TypeToken<>() {};
    public static final TypeToken<TraktCollectionProgress.Show> COLLECTED_PROGRESS = new TypeToken<>() {};
    public static final TypeToken<TraktWatchedProgress.Show> WATCHED_PROGRESS = new TypeToken<>() {};
    public static final TypeToken<Ratings> RATINGS = new TypeToken<>() {};
    public static final TypeToken<Stats> STATS = new TypeToken<>() {};
    public static final TypeToken<List<TraktUser>> USERS = new TypeToken<>() {};
    
    //episodes
    
}
