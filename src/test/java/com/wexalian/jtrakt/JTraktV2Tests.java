package com.wexalian.jtrakt;

import com.google.gson.reflect.TypeToken;
import com.wexalian.jtrakt.endpoint.TraktIds;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.endpoint.episodes.TraktEpisode;
import com.wexalian.jtrakt.endpoint.movies.TraktMovie;
import com.wexalian.jtrakt.endpoint.shows.TraktShow;
import com.wexalian.jtrakt.json.TraktJSON;
import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JTraktV2Tests {
    public static final boolean STAGING = false;
    protected static final String STAGING_TAG = STAGING ? "staging" : "not_staging";
    protected static final String TRAKT_FILE = STAGING ? "data/trakt_staging.json" : "data/trakt.json";
    protected static final String ACCESS_TOKEN_FILE = STAGING ? "data/access_token_staging.json" : "data/access_token.json";
    
    protected static final JTraktV2 TRAKT = getTrakt();
    protected static TraktAccessToken ACCESS_TOKEN = getAccessToken();
    
    protected static final int LIST_ID = getListId();
    protected static final TraktMovie MOVIE = getMovie();
    protected static final TraktShow SHOW = getShow();
    protected static final TraktEpisode EPISODE = getEpisode();
    
    private static int getListId() {
        return STAGING ? 86 : 31334553; // only available list id (in range 1-1500) on staging
    }
    
    private static JTraktV2 getTrakt() {
        JTraktV2.Data data = readFile(TRAKT_FILE, new TypeToken<>() {});
        return new JTraktV2(data.clientId(), data.secretId(), STAGING);
    }
    
    private static TraktAccessToken getAccessToken() {
        return readFile(ACCESS_TOKEN_FILE, new TypeToken<>() {});
    }
    
    protected static void writeAccessToken(TraktAccessToken token) {
        ACCESS_TOKEN = token;
        writeFile(ACCESS_TOKEN_FILE, token);
    }
    
    private static TraktMovie getMovie() {
        return new TraktMovie("Iron Man", 2005, TraktIds.slug("iron-man-2008"));
    }
    
    private static TraktShow getShow() {
        return new TraktShow("Arrow", 2012, TraktIds.imdb("tt2193021"));
    }
    
    private static TraktEpisode getEpisode() {
        return new TraktEpisode(1, 1, "Pilot", TraktIds.of(47304, null, 4325893, "tt2340185", 64111, -1));
    }
    
    public static void notNull(Object obj, String message) {
        Assertions.assertNotNull(obj, message);
    }
    
    private static <T> T readFile(String fileName, TypeToken<T> token) {
        try {
            String json = Files.readString(Path.of(fileName));
            return TraktJSON.fromJson(json, token);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(
                    "Data file not found, please add the trakt api client and secret file or run auth to get access token data",
                    e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private static void writeFile(String fileName, Object obj) {
        try {
            String json = TraktJSON.toJson(obj);
            Files.writeString(Path.of(fileName), json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
