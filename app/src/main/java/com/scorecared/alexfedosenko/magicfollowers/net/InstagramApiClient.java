package com.scorecared.alexfedosenko.magicfollowers.net;

import java.util.concurrent.Future;

import com.scorecared.alexfedosenko.magicfollowers.AppConfig;
import com.scorecared.alexfedosenko.magicfollowers.model.AccessTokenDetails;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InstagramApiClient {

    private static final String TAG = "InstagramApiClient";

    private static final String BASE_URL = "https://api.instagram.com";

    private static volatile InstagramApiClient sInstance;

    private volatile Retrofit httpClient;

    public InstagramApiClient() {
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

    public Future<AccessTokenDetails> getAccessToken(String requestCode) {
        InstagramApi api = httpClient.create(InstagramApi.class);
        Call<AccessTokenDetails> accessTokenCall = api.getAccessToken(requestCode,
            AppConfig.INSTAGRAM_REDIRECT_URL,
            AppConfig.INSTAGRAM_CLIENT_ID,
            AppConfig.INSTAGRAM_CLIENT_SECRET,
            "authorization_code");
//        accessTokenCall.
        return null;
    }

}
