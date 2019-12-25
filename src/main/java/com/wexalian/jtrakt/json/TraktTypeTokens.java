package com.wexalian.jtrakt.json;

import com.google.gson.reflect.TypeToken;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.endpoint.auth.data.TraktAuthCode;
import com.wexalian.jtrakt.http.query.Language;
import com.wexalian.jtrakt.media.*;
import com.wexalian.jtrakt.media.calender.TraktCalendarEpisode;
import com.wexalian.jtrakt.media.calender.TraktCalendarMovie;
import com.wexalian.jtrakt.media.certification.TraktCertifications;
import com.wexalian.jtrakt.media.checkin.TraktCheckinEpisode;
import com.wexalian.jtrakt.media.checkin.TraktCheckinMovie;
import com.wexalian.jtrakt.media.comment.TraktAttachedMedia;
import com.wexalian.jtrakt.media.comment.TraktCommentLike;
import com.wexalian.jtrakt.media.comment.TraktMediaComment;
import com.wexalian.jtrakt.media.episode.TraktEpisodeCast;
import com.wexalian.jtrakt.media.info.*;
import com.wexalian.jtrakt.media.movie.*;
import com.wexalian.jtrakt.media.people.TraktPersonMovieCast;
import com.wexalian.jtrakt.media.people.TraktPersonShowCast;
import com.wexalian.jtrakt.media.scrobble.TraktScrobbleMovie;
import com.wexalian.jtrakt.media.scrobble.TraktScrobbleShow;
import com.wexalian.jtrakt.media.search.TraktSearchMedia;
import com.wexalian.jtrakt.media.show.*;

import java.util.List;

public final class TraktTypeTokens
{
    //general
    public static final TypeToken<TraktShow> SHOW = new TypeToken<>() {};
    public static final TypeToken<TraktMovie> MOVIE = new TypeToken<>() {};
    public static final TypeToken<TraktEpisode> EPISODE = new TypeToken<>() {};
    public static final TypeToken<TraktComment> COMMENT = new TypeToken<>() {};
    public static final TypeToken<TraktAttachedMedia> MEDIA = new TypeToken<>() {};
    
    //oauth
    public static final TypeToken<TraktAccessToken> ACCESS_TOKEN = new TypeToken<>() {};
    
    //oauth device
    public static final TypeToken<TraktAuthCode> AUTH_CODE = new TypeToken<>() {};
    
    //calender
    public static final TypeToken<List<TraktCalendarEpisode>> CALENDAR_EPISODES = new TypeToken<>() {};
    public static final TypeToken<List<TraktCalendarMovie>> CALENDAR_MOVIES = new TypeToken<>() {};
    
    //certifications
    public static final TypeToken<TraktCertifications> CERTIFICATIONS = new TypeToken<>() {};
    
    //checkin
    public static final TypeToken<TraktCheckinMovie> CHECKIN_MOVIE = new TypeToken<>() {};
    public static final TypeToken<TraktCheckinEpisode> CHECKIN_EPISODE = new TypeToken<>() {};
    
    //comments
    public static final TypeToken<List<TraktCommentLike>> COMMENT_LIKES = new TypeToken<>() {};
    public static final TypeToken<List<TraktMediaComment>> MEDIA_COMMENTS = new TypeToken<>() {};
    
    //countries
    public static final TypeToken<List<Country>> COUNTRIES = new TypeToken<>() {};
    
    //genres
    public static final TypeToken<List<Genre>> GENRES = new TypeToken<>() {};
    
    //languages
    public static final TypeToken<List<Language>> LANGUAGES = new TypeToken<>() {};
    
    //movies
    public static final TypeToken<List<TraktMovie>> MOVIES = new TypeToken<>() {};
    public static final TypeToken<List<TraktTrendingMovie>> TRENDING_MOVIES = new TypeToken<>() {};
    public static final TypeToken<List<TraktWatchedMovie>> WATCHED_MOVIES = new TypeToken<>() {};
    public static final TypeToken<List<TraktListedMovie>> LISTED_MOVIES = new TypeToken<>() {};
    public static final TypeToken<List<TraktUpdatedMovie>> UPDATED_MOVIES = new TypeToken<>() {};
    public static final TypeToken<List<TraktBoxOfficeMovie>> BOX_OFFICE_MOVIES = new TypeToken<>() {};
    public static final TypeToken<List<MovieRelease>> RELEASES = new TypeToken<>() {};
    public static final TypeToken<TraktMovieCast> MOVIE_CAST = new TypeToken<>() {};
    
    //languages
    public static final TypeToken<List<Network>> NETWORKS = new TypeToken<>() {};
    
    //people
    public static final TypeToken<TraktPerson> PERSON = new TypeToken<>() {};
    public static final TypeToken<List<TraktPersonMovieCast>> PERSON_MOVIE_CASTS = new TypeToken<>() {};
    public static final TypeToken<List<TraktPersonShowCast>> PERSON_SHOW_CASTS = new TypeToken<>() {};
    
    //scrobble
    public static final TypeToken<TraktScrobbleMovie> SCROBBLE_MOVIE = new TypeToken<>() {};
    public static final TypeToken<TraktScrobbleShow> SCROBBLE_SHOW = new TypeToken<>() {};
    
    //search
    public static final TypeToken<List<TraktSearchMedia>> SEARCH_MEDIA = new TypeToken<>() {};
    
    //seasons
    public static final TypeToken<List<TraktSeason>> SEASONS = new TypeToken<>() {};
    
    //shows
    public static final TypeToken<List<TraktTrendingShow>> TRENDING_SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktShow>> SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktWatchedShow>> WATCHED_SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktListedShow>> LISTED_SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktUpdatedShow>> UPDATED_SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<Alias>> ALIASES = new TypeToken<>() {};
    public static final TypeToken<List<TraktComment>> COMMENTS = new TypeToken<>() {};
    public static final TypeToken<List<TraktList>> LISTS = new TypeToken<>() {};
    public static final TypeToken<List<Translation>> TRANSLATIONS = new TypeToken<>() {};
    public static final TypeToken<TraktCollectionProgress.Show> COLLECTED_PROGRESS = new TypeToken<>() {};
    public static final TypeToken<TraktWatchedProgress.Show> WATCHED_PROGRESS = new TypeToken<>() {};
    public static final TypeToken<Ratings> RATINGS = new TypeToken<>() {};
    public static final TypeToken<Stats> STATS = new TypeToken<>() {};
    public static final TypeToken<List<TraktUser>> USERS = new TypeToken<>() {};
    public static final TypeToken<TraktShowCast> SHOW_CAST = new TypeToken<>() {};
    
    //episodes
    public static final TypeToken<List<TraktEpisode>> EPISODES = new TypeToken<>() {};
    public static final TypeToken<TraktEpisodeCast> EPISODE_CAST = new TypeToken<>() {};
}
