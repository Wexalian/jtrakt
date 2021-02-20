package com.wexalian.jtrakt.json;

import com.google.gson.reflect.TypeToken;
import com.wexalian.jtrakt.endpoint.*;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.endpoint.auth.data.TraktAuthCode;
import com.wexalian.jtrakt.endpoint.calendars.TraktCalendarEpisode;
import com.wexalian.jtrakt.endpoint.calendars.TraktCalendarMovie;
import com.wexalian.jtrakt.endpoint.certifications.TraktCertifications;
import com.wexalian.jtrakt.endpoint.checkin.TraktCheckinItem;
import com.wexalian.jtrakt.endpoint.comments.TraktAttachedMediaItem;
import com.wexalian.jtrakt.endpoint.comments.TraktComment;
import com.wexalian.jtrakt.endpoint.comments.TraktItemComment;
import com.wexalian.jtrakt.endpoint.countries.TraktCountry;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisodeCast;
import com.wexalian.jtrakt.endpoint.genres.TraktGenre;
import com.wexalian.jtrakt.endpoint.languages.TraktLanguage;
import com.wexalian.jtrakt.endpoint.lists.TraktLikedList;
import com.wexalian.jtrakt.endpoint.lists.TraktList;
import com.wexalian.jtrakt.endpoint.movies.*;
import com.wexalian.jtrakt.endpoint.networks.TraktNetwork;
import com.wexalian.jtrakt.endpoint.people.TraktMovieCredits;
import com.wexalian.jtrakt.endpoint.people.TraktPerson;
import com.wexalian.jtrakt.endpoint.people.TraktShowCredits;
import com.wexalian.jtrakt.endpoint.scrobble.TraktScrobbleItem;
import com.wexalian.jtrakt.endpoint.search.TraktSearchItem;
import com.wexalian.jtrakt.endpoint.seasons.TraktSeason;
import com.wexalian.jtrakt.endpoint.shows.*;
import com.wexalian.jtrakt.endpoint.sync.TraktHistoryItem;
import com.wexalian.jtrakt.endpoint.sync.TraktPlayback;
import com.wexalian.jtrakt.endpoint.sync.TraktSyncUpdate;
import com.wexalian.jtrakt.endpoint.sync.activity.TraktActivity;
import com.wexalian.jtrakt.endpoint.sync.collection.TraktCollectionMovie;
import com.wexalian.jtrakt.endpoint.sync.collection.TraktCollectionShow;
import com.wexalian.jtrakt.endpoint.sync.rating.TraktRatedItem;
import com.wexalian.jtrakt.endpoint.sync.watched.TraktWatchedItem;
import com.wexalian.jtrakt.endpoint.sync.watchlist.TraktWatchlistItem;
import com.wexalian.jtrakt.endpoint.users.*;
import com.wexalian.jtrakt.endpoint.users.follow.TraktFollowRequest;
import com.wexalian.jtrakt.endpoint.users.follow.TraktFollower;
import com.wexalian.jtrakt.endpoint.users.follow.TraktFollowerConfirmation;
import com.wexalian.jtrakt.endpoint.users.follow.TraktFollowerRequest;
import com.wexalian.jtrakt.endpoint.users.hidden.TraktHiddenItem;

import java.util.List;

public final class TraktTypeTokens {
    //general
    public static final TypeToken<TraktShow> SHOW = new TypeToken<>() {};
    public static final TypeToken<TraktMovie> MOVIE = new TypeToken<>() {};
    public static final TypeToken<TraktEpisode> EPISODE = new TypeToken<>() {};
    public static final TypeToken<TraktComment> COMMENT = new TypeToken<>() {};
    public static final TypeToken<TraktAttachedMediaItem> MEDIA = new TypeToken<>() {};
    public static final TypeToken<List<TraktLike>> LIKES = new TypeToken<>() {};
    
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
    public static final TypeToken<TraktCheckinItem> CHECKIN = new TypeToken<>() {};
    
    //comments
    public static final TypeToken<List<TraktItemComment>> ITEM_COMMENTS = new TypeToken<>() {};
    
    //countries
    public static final TypeToken<List<TraktCountry>> COUNTRIES = new TypeToken<>() {};
    
    //genres
    public static final TypeToken<List<TraktGenre>> GENRES = new TypeToken<>() {};
    
    //languages
    public static final TypeToken<List<TraktLanguage>> LANGUAGES = new TypeToken<>() {};
    
    //lists
    public static final TypeToken<TraktList> LIST = new TypeToken<>() {};
    public static final TypeToken<List<TraktLikedList>> LIKED_LISTS = new TypeToken<>() {};
    public static final TypeToken<List<TraktListItem>> LIST_ITEMS = new TypeToken<>() {};
    
    //movies
    public static final TypeToken<List<TraktMovie>> MOVIES = new TypeToken<>() {};
    public static final TypeToken<List<TraktTrendingMovie>> TRENDING_MOVIES = new TypeToken<>() {};
    public static final TypeToken<List<TraktWatchedMovie>> WATCHED_MOVIES = new TypeToken<>() {};
    public static final TypeToken<List<TraktListedMovie>> LISTED_MOVIES = new TypeToken<>() {};
    public static final TypeToken<List<TraktUpdatedMovie>> UPDATED_MOVIES = new TypeToken<>() {};
    public static final TypeToken<List<TraktBoxOfficeMovie>> BOX_OFFICE_MOVIES = new TypeToken<>() {};
    public static final TypeToken<List<TraktMovieRelease>> RELEASES = new TypeToken<>() {};
    public static final TypeToken<TraktMovieCast> MOVIE_CAST = new TypeToken<>() {};
    
    //languages
    public static final TypeToken<List<TraktNetwork>> NETWORKS = new TypeToken<>() {};
    
    //people
    public static final TypeToken<TraktPerson> PERSON = new TypeToken<>() {};
    public static final TypeToken<TraktMovieCredits> MOVIE_CREDITS = new TypeToken<>() {};
    public static final TypeToken<TraktShowCredits> SHOW_CREDITS = new TypeToken<>() {};
    
    //scrobble
    public static final TypeToken<TraktScrobbleItem> SCROBBLE_ITEM = new TypeToken<>() {};
    
    //search
    public static final TypeToken<List<TraktSearchItem>> SEARCH_ITEM = new TypeToken<>() {};
    
    //seasons
    public static final TypeToken<List<TraktSeason>> SEASONS = new TypeToken<>() {};
    
    //shows
    public static final TypeToken<List<TraktTrendingShow>> TRENDING_SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktShow>> SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktWatchedShow>> WATCHED_SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktListedShow>> LISTED_SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktUpdatedShow>> UPDATED_SHOWS = new TypeToken<>() {};
    public static final TypeToken<List<TraktAlias>> ALIASES = new TypeToken<>() {};
    public static final TypeToken<List<TraktComment>> COMMENTS = new TypeToken<>() {};
    public static final TypeToken<List<TraktList>> LISTS = new TypeToken<>() {};
    public static final TypeToken<List<TraktTranslation>> TRANSLATIONS = new TypeToken<>() {};
    public static final TypeToken<TraktCollectionProgress.Show> COLLECTED_PROGRESS = new TypeToken<>() {};
    public static final TypeToken<TraktWatchedProgress.Show> WATCHED_PROGRESS = new TypeToken<>() {};
    public static final TypeToken<TraktRatings> RATINGS = new TypeToken<>() {};
    public static final TypeToken<TraktStats> STATS = new TypeToken<>() {};
    public static final TypeToken<List<TraktUser>> USERS = new TypeToken<>() {};
    public static final TypeToken<TraktShowCast> SHOW_CAST = new TypeToken<>() {};
    
    //episodes
    public static final TypeToken<List<TraktEpisode>> EPISODES = new TypeToken<>() {};
    public static final TypeToken<TraktEpisodeCast> EPISODE_CAST = new TypeToken<>() {};
    
    //sync
    public static final TypeToken<TraktActivity> LAST_ACTIVITY = new TypeToken<>() {};
    public static final TypeToken<TraktPlayback> PLAYBACK = new TypeToken<>() {};
    public static final TypeToken<List<TraktCollectionMovie>> MOVIE_COLLECTION = new TypeToken<>() {};
    public static final TypeToken<List<TraktCollectionShow>> SHOW_COLLECTION = new TypeToken<>() {};
    public static final TypeToken<TraktSyncUpdate> SYNC_UPDATE = new TypeToken<>() {};
    public static final TypeToken<List<TraktWatchedItem>> SYNC_WATCHED_ITEMS = new TypeToken<>() {};
    public static final TypeToken<List<TraktHistoryItem>> HISTORY_ITEMS = new TypeToken<>() {};
    public static final TypeToken<List<TraktRatedItem>> RATED_ITEMS = new TypeToken<>() {};
    public static final TypeToken<List<TraktWatchlistItem>> WATCHLIST_ITEMS = new TypeToken<>() {};
    
    //users
    public static final TypeToken<TraktSettings> SETTINGS = new TypeToken<>() {};
    public static final TypeToken<List<TraktFollowerRequest>> FOLLOWER_REQUESTS = new TypeToken<>() {};
    public static final TypeToken<TraktFollowerConfirmation> FOLLOWER_CONFIRMATION = new TypeToken<>() {};
    public static final TypeToken<List<TraktHiddenItem>> HIDDEN_ITEMS = new TypeToken<>() {};
    public static final TypeToken<List<TraktLikedItem>> LIKED_ITEMS = new TypeToken<>() {};
    public static final TypeToken<TraktUser> USER = new TypeToken<>() {};
    public static final TypeToken<TraktListReorderUpdate> LIST_REORDER_UPDATE = new TypeToken<>() {};
    public static final TypeToken<TraktFollowRequest> FOLLOW_REQUEST = new TypeToken<>() {};
    public static final TypeToken<List<TraktFollower>> USER_FOLLOWERS = new TypeToken<>() {};
    public static final TypeToken<List<TraktFriend>> USER_FRIENDS = new TypeToken<>() {};
    public static final TypeToken<TraktWatchingItem> WATCHING_ITEM = new TypeToken<>() {};
    public static final TypeToken<TraktUserStats> USER_STATS = new TypeToken<>() {};
}
