package com.scorecared.alexfedosenko.magicfollowers.net;

import retrofit2.Retrofit;

public class AbstractApiClient {

    private volatile Retrofit httpClient;

    protected final Retrofit getHttpClient() {
        if (httpClient == null) {
            synchronized (this) {
                if (httpClient == null) {
                    httpClient = createHttpClient();
                }
            }
        }
        return httpClient;
    }

    private void createHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}
