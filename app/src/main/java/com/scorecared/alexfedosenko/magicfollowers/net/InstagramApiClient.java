package com.scorecared.alexfedosenko.magicfollowers.net;

public class InstagramApiClient {

    private static final String TAG = "InstagramApiClient";

    private static final String BASE_URL = "https://api.instagram.com";

    private static volatile InstagramApiClient sInstance;

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
}
