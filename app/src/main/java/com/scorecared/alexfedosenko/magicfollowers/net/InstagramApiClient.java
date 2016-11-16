package com.scorecared.alexfedosenko.magicfollowers.net;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.scorecared.alexfedosenko.magicfollowers.AppConfig;
import com.scorecared.alexfedosenko.magicfollowers.model.AccessTokenDetails;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InstagramApiClient {

    private static final String TAG = "InstagramApiClient";

    private static final String BASE_URL = "https://api.instagram.com";

    private static volatile InstagramApiClient sInstance;

    private volatile Retrofit httpClient;

    private String accessToken;

    private InstagramApiClient() {
        httpClient = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    public static InstagramApiClient getInstance() {
        if (sInstance == null) {
            synchronized (InstagramApiClient.class) {
                if (sInstance == null) {
                    sInstance = new InstagramApiClient();
                }
            }
        }
        return sInstance;
    }

    public Future<AccessTokenDetails> getAccessToken(String requestCode, Callback<AccessTokenDetails> callback) {
        InstagramApi api = httpClient.create(InstagramApi.class);
        Map<String, String> map = buildGetAccessTokenFieldMap();
        map.put("code", requestCode);
        Call<AccessTokenDetails> accessTokenCall = api.getAccessToken(map);
        accessTokenCall.enqueue(callback);
        return new ResultFuture<>(accessTokenCall);
    }

    private Map<String, String> buildGetAccessTokenFieldMap() {
        Map<String, String> map = new HashMap<>();
        map.put("redirect_uri", AppConfig.INSTAGRAM_REDIRECT_URL);
        map.put("client_id", AppConfig.INSTAGRAM_CLIENT_ID);
        map.put("client_secret", AppConfig.INSTAGRAM_CLIENT_SECRET);
        map.put("grant_type", "authorization_code");
        return map;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
