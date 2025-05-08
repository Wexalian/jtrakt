package com.wexalian.jtrakt.http;

import com.google.gson.reflect.TypeToken;
import com.wexalian.jtrakt.endpoint.auth.TraktAccessToken;
import com.wexalian.jtrakt.json.TraktJSON;
import com.wexalian.nullability.annotations.Nonnull;
import com.wexalian.nullability.annotations.Nullable;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
    private final String apiHost;
    private final HttpClient client;
    
    public TraktHTTP(@Nonnull String clientId, boolean useStaging) {
        this.clientId = clientId;
        this.apiHost = useStaging ? API_HOST_STAGING : API_HOST;
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
    
    public boolean post(@Nonnull TraktQuery query, @Nullable Object postData, @Nullable TraktAccessToken accessToken) {
        HttpRequest.Builder builder = getBuilder(query, accessToken).POST(getPublisherForPostData(postData));
        
        return sendAsync(builder);
    }
    
    public <T> T postAndParse(@Nonnull TraktQuery query, @Nullable Object postData, @Nonnull TypeToken<T> typeToken) {
        return postAndParse(query, postData, typeToken, null);
    }
    
    public <T> T postAndParse(@Nonnull TraktQuery query, @Nullable Object postData, @Nonnull TypeToken<T> typeToken, @Nullable TraktAccessToken accessToken) {
        HttpRequest.Builder builder = getBuilder(query, accessToken).POST(getPublisherForPostData(postData));
        
        return sendAsync(builder, typeToken);
    }
    
    private HttpRequest.BodyPublisher getPublisherForPostData(@Nullable Object postData) {
        return HttpRequest.BodyPublishers.ofString(TraktJSON.toJson(postData));
    }
    
    public <T> T putAndParse(@Nonnull TraktQuery query, @Nullable Object postData, @Nonnull TypeToken<T> typeToken, @Nullable TraktAccessToken accessToken) {
        HttpRequest.Builder builder = getBuilder(query, accessToken).PUT(getPublisherForPostData(postData));
        
        return sendAsync(builder, typeToken);
    }
    
    public boolean delete(@Nonnull TraktQuery query, @Nullable TraktAccessToken accessToken) {
        HttpRequest.Builder builder = getBuilder(query, accessToken).DELETE();
        
        return sendAsync(builder);
    }
    
    private boolean sendAsync(@Nonnull HttpRequest.Builder builder) {
        return client.sendAsync(builder.build(), HttpResponse.BodyHandlers.discarding()).join().statusCode() == 204;
    }
    
    private <T> T sendAsync(@Nonnull HttpRequest.Builder builder, @Nonnull TypeToken<T> typeToken) {
        return client.sendAsync(builder.build(), HttpResponse.BodyHandlers.ofString()).thenApply(response -> {
            switch (response.statusCode()) {
                case 429:
                    String retryTime = response.headers().firstValue("Retry-After").orElse("1");
                    int time = Integer.parseInt(retryTime);
                    runUnchecked(() -> Thread.sleep(time * 1000L));
                    return sendAsync(builder, typeToken);
                case 502:
                case 503:
                case 504:
                case 520:
                case 521:
                case 522:
                    return null;
                default:
                    return TraktJSON.fromJson(response.body(), typeToken);
            }
        }).join();
    }
    
    private HttpRequest.Builder getBuilder(@Nonnull TraktQuery query, @Nullable TraktAccessToken accessToken) {
        HttpRequest.Builder builder = HttpRequest.newBuilder().uri(query.format(apiHost))
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
