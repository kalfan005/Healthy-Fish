package com.example.healthyfish.Screen1.Controller;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.healthyfish.Screen1.apiinterface.LoginApi;
import com.example.healthyfish.Screen1.apiinterface.LoginCall;
import com.example.healthyfish.Screen1.apiinterface.LoginCallback;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginController implements LoginCall {


    Context context;
    LoginCallback loginCallback;

    public LoginController(Context context, LoginCallback loginCallback){

        this.context = context;
        this.loginCallback = loginCallback;
    }
    @Override
    public void getLogindata(String email, String password, String key) {

        retrofit2.Retrofit retrofit1 = Retrofit.getClient();
        LoginApi loginApi = retrofit1.create(LoginApi.class);

         loginApi.datapost(email, password, "koFCpCMzm8hhn9ULj0BnUzZkpqM3rg9Mqdii3FwPRjBwZFQWriIJYgB5jjOhNIyasSl4RrmCFLW3tHDRtI39viQbYEP7nEkYvba2wstThYWjvkndZq0zaXJaWjuqeZo8vR3MMHa6OhBDKsFPmWOlIM4H1TgB1fudQndGKzUPg8YhAoaAoCxZ562zjbQdPO73ZkwyPV7iOIkyH11ZLAN42a5dgLH22Rs1VasEWBKdfkqMLPfDbLQpF9Ofqah4fqwc").enqueue(new Callback<JsonObject>() {
             @Override
             public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                 Log.d(TAG, "onResponse: "+response);

                 if (response.isSuccessful()){
                     Log.d("Data response", response.body().toString());

                     JsonObject jsonObject = response.body();
                     String status = jsonObject.get("status").getAsString();
                     String message = jsonObject.get("message").getAsString();

                     Log.d(TAG,"onResponse: "+status+message);

                     loginCallback.getResponse(message,status);

                 }
                 else {
                     Toast.makeText(context.getApplicationContext(), "Error",Toast.LENGTH_SHORT);
                 }
             }

             @Override
             public void onFailure(Call<JsonObject> call, Throwable t) {

                 Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show();
                 Log.d(TAG,"onFailure: "+t);

             }
         });

    }
}
