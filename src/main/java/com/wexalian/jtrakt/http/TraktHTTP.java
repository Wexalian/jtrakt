package com.wexalian.jtrakt.http;

import com.google.gson.reflect.TypeToken;
import com.wexalian.jtrakt.JTraktV2;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.json.TraktJSON;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SuppressWarnings("DuplicatedCode")
public class TraktHTTP
{
    public static final String API_HOST = "api.trakt.tv";
    public static final String API_URL = "https://" + API_HOST + "/";
    public static final String API_VERSION = "2";
    
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_AUTHORIZATION_BEARER = "Bearer ";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String HEADER_CONTENT_TYPE_JSON = "application/json";
    private static final String HEADER_TRAKT_API_VERSION = "trakt-api-version";
    private static final String HEADER_TRAKT_API_KEY = "trakt-api-key";
    
    private JTraktV2 traktApi;
    private HttpClient client;
    
    public TraktHTTP(JTraktV2 traktApi)
    {
        this.traktApi = traktApi;
        this.client = HttpClient.newBuilder()
                                .version(HttpClient.Version.HTTP_2)
                                .followRedirects(HttpClient.Redirect.NORMAL)
                                .build();
    }
    
    public <T> T getAndParse(@Nonnull TraktQuery query, @Nonnull TypeToken<T> typeToken)
    {
        return getAndParse(query, typeToken, null);
    }
    
    public <T> T getAndParse(@Nonnull TraktQuery query, @Nonnull TypeToken<T> typeToken, @Nullable TraktAccessToken accessToken)
    {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                                                 .GET()
                                                 .uri(URI.create(query.format()))
                                                 .header(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_JSON)
                                                 .header(HEADER_TRAKT_API_VERSION, API_VERSION)
                                                 .header(HEADER_TRAKT_API_KEY, traktApi.getClientId());
        
        if (accessToken != null)
        {
            builder = builder.header(HEADER_AUTHORIZATION, HEADER_AUTHORIZATION_BEARER + accessToken.getAccessToken());
        }
        
        return client.sendAsync(builder.build(), HttpResponse.BodyHandlers.ofString())
                     .thenApply(HttpResponse::body)
                     .thenApply(s -> TraktJSON.fromJson(s, typeToken))
                     .join();
    }
    
    public void post(@Nonnull TraktQuery query, @Nullable Object postData, @Nullable TraktAccessToken accessToken)
    {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                                                 .POST(HttpRequest.BodyPublishers.ofString(TraktJSON.toJson(postData)))
                                                 .uri(URI.create(query.format()))
                                                 .header(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_JSON)
                                                 .header(HEADER_TRAKT_API_VERSION, API_VERSION)
                                                 .header(HEADER_TRAKT_API_KEY, traktApi.getClientId());
        
        if (accessToken != null)
        {
            builder = builder.header(HEADER_AUTHORIZATION, "Bearer " + accessToken.getAccessToken());
        }
        
        client.sendAsync(builder.build(), HttpResponse.BodyHandlers.discarding());
    }
    
    public <T> T postAndParse(@Nonnull TraktQuery query, @Nullable Object postData, @Nonnull TypeToken<T> typeToken)
    {
        return postAndParse(query, postData, typeToken, null);
    }
    
    public <T> T postAndParse(@Nonnull TraktQuery query, @Nullable Object postData, @Nonnull TypeToken<T> typeToken, @Nullable TraktAccessToken accessToken)
    {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                                                 .POST(HttpRequest.BodyPublishers.ofString(TraktJSON.toJson(postData)))
                                                 .uri(URI.create(query.format()))
                                                 .header(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_JSON)
                                                 .header(HEADER_TRAKT_API_VERSION, API_VERSION)
                                                 .header(HEADER_TRAKT_API_KEY, traktApi.getClientId());
        
        if (accessToken != null)
        {
            builder = builder.header(HEADER_AUTHORIZATION, "Bearer " + accessToken.getAccessToken());
        }
        
        return client.sendAsync(builder.build(), HttpResponse.BodyHandlers.ofString())
                     .thenApply(HttpResponse::body)
                     .thenApply(s -> TraktJSON.fromJson(s, typeToken))
                     .join();
    }
    
    public void delete(@Nonnull TraktQuery query, @Nullable TraktAccessToken accessToken)
    {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                                                 .DELETE()
                                                 .uri(URI.create(query.format()))
                                                 .header(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_JSON)
                                                 .header(HEADER_TRAKT_API_VERSION, API_VERSION)
                                                 .header(HEADER_TRAKT_API_KEY, traktApi.getClientId());
        
        if (accessToken != null)
        {
            builder = builder.header(HEADER_AUTHORIZATION, HEADER_AUTHORIZATION_BEARER + accessToken.getAccessToken());
        }
        
        client.sendAsync(builder.build(), HttpResponse.BodyHandlers.discarding())
              .join();
    }
}
