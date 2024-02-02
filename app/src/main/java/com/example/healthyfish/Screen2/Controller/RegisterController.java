package com.example.healthyfish.Screen2.Controller;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.healthyfish.Screen2.Registration;
import com.example.healthyfish.Screen2.apiinterface.ApiInterface;
import com.example.healthyfish.Screen2.apiinterface.RegisterCall;
import com.example.healthyfish.Screen2.apiinterface.RegisterCallBack;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterController implements RegisterCall {
    Context context;
    RegisterCallBack registercallback;

    public RegisterController(Context context, Registration registercallback) {
        this.context = context;
        this.registercallback = registercallback;


    }

    @Override
    public void getRegisterdata(String firstname, String lastname, String email, String telephone, String password, String type, String referal_code, String key) {

        Retrofit retrofit = RetrofitClass.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Log.d(TAG, "getRegisterdata: " + firstname + lastname + email + telephone +
                password + type + referal_code);

        apiInterface.datapost(firstname, lastname, email, telephone,
                password, type, referal_code, "koFCpCMzm8hhn9ULj0BnUzZkpqM3rg9Mqdii3FwPRjBwZFQWriIJYgB5jjOhNIyasSl4RrmCFLW3tHDRtI39viQbYEP7nEkYvba2wstThYWjvkndZq0zaXJaWjuqeZo8vR3MMHa6OhBDKsFPmWOlIM4H1TgB1fudQndGKzUPg8YhAoaAoCxZ562zjbQdPO73ZkwyPV7iOIkyH11ZLAN42a5dgLH22Rs1VasEWBKdfkqMLPfDbLQpF9Ofqah4fqwc").enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {

                    Log.d("Data response", response.body().toString());

                    JsonObject jsonObject = response.body();
                    String message = jsonObject.get("status").getAsString();
                    String status = jsonObject.get("message").getAsString();
                    Log.d(TAG, "onResponse: " + message + status);

                    registercallback.getResponse(message, status);
                } else {
                    Toast.makeText(context.getApplicationContext(), "Error", Toast.LENGTH_SHORT);
                }
            }


            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

                Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show();
            }

        });
    }
}


