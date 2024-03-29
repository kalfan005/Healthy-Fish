package com.example.healthyfish.Screen6.Categoryclasses;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface apiinterface {
    @FormUrlEncoded
    @POST("index.php?route=api/completeapi&api_token=")
    Call<JsonObject> datapost1(@Field("user_id")String user_id,
                               @Field("key")String key);


    @FormUrlEncoded
    @POST("index.php?route=api/completeapi/categoryProducts&api_token=")
    Call<JsonObject> datapost2(@Field("user_id")String user_id,
                               @Field("category_id")String category_id,
                               @Field("key")String key);

}
