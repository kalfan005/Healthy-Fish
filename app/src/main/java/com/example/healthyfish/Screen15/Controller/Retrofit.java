package com.example.healthyfish.Screen15.Controller;

import android.app.Application;

import okhttp3.OkHttpClient;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit extends Application {

    public static final String BASE_URL = "https://iroidtechnologies.in/healthyfish/";

    static OkHttpClient.Builder httpClient = null;
    private static retrofit2.Retrofit retrofit2 = null;

    public void onCreate(){

        super.onCreate();
    }

    private static OkHttpClient buildClient(){
        return new OkHttpClient.Builder()
                .build();
    }

    public static retrofit2.Retrofit getClient(){
        if (retrofit2 == null){
            retrofit2 = new retrofit2.Retrofit.Builder()
                    .client(buildClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit2;
    }


}