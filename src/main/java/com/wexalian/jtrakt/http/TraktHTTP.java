package com.wexalian.jtrakt.http;

import com.google.gson.reflect.TypeToken;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.json.TraktJSON;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// @SuppressWarnings("DuplicatedCode")
public class TraktHTTP {
    public static final String API_HOST = "api.trakt.tv";
    public static final String API_HOST_STAGING = "api-staging.trakt.tv";
    
    public static final String API_VERSION = "2";
    
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_AUTHORIZATION_BEARER = "Bearer ";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String HEADER_CONTENT_TYPE_JSON = "application/json";
    private static final String HEADER_TRAKT_API_VERSION = "trakt-api-version";
    private static final String HEADER_TRAKT_API_KEY = "trakt-api-key";
    
    private final String clientId;
    private final boolean staging;
    private final HttpClient client;
    
    public TraktHTTP(@Nonnull String clientId, boolean useStaging) {
        this.clientId = clientId;
        this.staging = useStaging;
        this.client = HttpClient.newBuilder()
                                .version(HttpClient.Version.HTTP_2)
                                .followRedirects(HttpClient.Redirect.NORMAL)
                                .build();
    }
    
    public <T> T getAndParse(@Nonnull TraktQuery query, @Nonnull TypeToken<T> typeToken) {
        return getAndParse(query, typeToken, null);
    }
    
    public <T> T getAndParse(@Nonnull TraktQuery query, @Nonnull TypeToken<T> typeToken, @Nullable TraktAccessToken accessToken) {
        HttpRequest.Builder builder = getBuilder(query, accessToken).GET();
        
        return sendAsync(builder, typeToken);
    }
    
    public void post(@Nonnull TraktQuery query, @Nullable Object postData, @Nullable TraktAccessToken accessToken) {
        HttpRequest.Builder builder = getBuilder(query, accessToken).POST(HttpRequest.BodyPublishers.ofString(TraktJSON.toJson(postData)));
        
        sendAsync(builder);
    }
    
    public <T> T postAndParse(@Nonnull TraktQuery query, @Nullable Object postData, @Nonnull TypeToken<T> typeToken) {
        return postAndParse(query, postData, typeToken, null);
    }
    
    public <T> T postAndParse(@Nonnull TraktQuery query, @Nullable Object postData, @Nonnull TypeToken<T> typeToken, @Nullable TraktAccessToken accessToken) {
        HttpRequest.Builder builder = getBuilder(query, accessToken).POST(HttpRequest.BodyPublishers.ofString(TraktJSON.toJson(postData)));
        
        return sendAsync(builder, typeToken);
    }
    
    public <T> T putAndParse(@Nonnull TraktQuery query, @Nullable Object postData, @Nonnull TypeToken<T> typeToken, @Nullable TraktAccessToken accessToken) {
        HttpRequest.Builder builder = getBuilder(query, accessToken).PUT(HttpRequest.BodyPublishers.ofString(TraktJSON.toJson(postData)));
        
        return sendAsync(builder, typeToken);
    }
    
    public void delete(@Nonnull TraktQuery query, @Nullable TraktAccessToken accessToken) {
        HttpRequest.Builder builder = getBuilder(query, accessToken).DELETE();
        
        sendAsync(builder);
    }
    
    private void sendAsync(@Nonnull HttpRequest.Builder builder) {
        client.sendAsync(builder.build(), HttpResponse.BodyHandlers.discarding()).join();
    }
    
    private <T> T sendAsync(@Nonnull HttpRequest.Builder builder, @Nonnull TypeToken<T> typeToken) {
        return client.sendAsync(builder.build(), HttpResponse.BodyHandlers.ofString()).thenApply(stringHttpResponse -> {
            if (stringHttpResponse.statusCode() == 429) {
                runUnchecked(() -> Thread.sleep(1000L));
                return sendAsync(builder, typeToken);
            }
            if (stringHttpResponse.statusCode() == 521) {
                return null;
            }
            
            String body = stringHttpResponse.body();
            return TraktJSON.fromJson(body, typeToken);
        }).join();
    }
    
    private HttpRequest.Builder getBuilder(@Nonnull TraktQuery query, @Nullable TraktAccessToken accessToken) {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                                                 .uri(URI.create(query.format(staging ? API_HOST_STAGING : API_HOST)))
                                                 .header(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_JSON)
                                                 .header(HEADER_TRAKT_API_VERSION, API_VERSION)
                                                 .header(HEADER_TRAKT_API_KEY, clientId);
        
        if (accessToken != null) {
            builder = builder.header(HEADER_AUTHORIZATION, HEADER_AUTHORIZATION_BEARER + accessToken.getAccessToken());
        }
        
        return builder;
    }
    
    private void runUnchecked(UncheckedRunnable runnable) {
        try {
            runnable.run();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FunctionalInterface
    private interface UncheckedRunnable {
        void run() throws Exception;
    }
}
