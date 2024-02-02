package com.example.healthyfish.Screen1.apiinterface;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginApi {

    @FormUrlEncoded
    @POST("index.php?route=api/login&api_token=")
     Call<JsonObject>datapost(@Field("email") String email,
                                     @Field("password") String password,
                              @Field("key")String key);
}
