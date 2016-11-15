package com.scorecared.alexfedosenko.magicfollowers.model;

import com.google.gson.annotations.SerializedName;

public class AccessTokenDetails {
    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("user")
    private User instagramUser;

    public AccessTokenDetails() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public User getInstagramUser() {
        return instagramUser;
    }
}
