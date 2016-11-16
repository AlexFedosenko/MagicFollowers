package com.scorecared.alexfedosenko.magicfollowers.net;

import java.util.Map;

import com.scorecared.alexfedosenko.magicfollowers.model.AccessTokenDetails;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InstagramApi {

    @FormUrlEncoded
    @POST("/oauth/access_token")
    Call<AccessTokenDetails> getAccessToken(@FieldMap Map<String, String> fieldMap);
//                                            @FieldMap("code") String requestToken,
//                                            @Field("redirect_uri") String redirect,
//                                            @Field("client_id") String clientId,
//                                            @Field("client_secret") String clientSecret,
//                                            @Field("grant_type") String grantType);
}
