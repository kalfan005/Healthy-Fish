package com.example.healthyfish.screen22;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface apiinterface2 {

    @FormUrlEncoded
    @POST("index.php?route=api/completeapi/getRecipes&api_token=")
    Call<JsonObject> datapost(@Field("user_id")String user_id,
                              @Field("key")String key);
}
