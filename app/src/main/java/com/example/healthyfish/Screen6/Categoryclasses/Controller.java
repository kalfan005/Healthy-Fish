package com.example.healthyfish.Screen6.Categoryclasses;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Response;
import retrofit2.Retrofit;

public class Controller implements Call{

    private static final String TAG = "Controller";

    Context context;
    Callback callback;


 public Controller(Context context, Callback callback){
     this.context = context;
      this.callback =callback;
 }
    ArrayList<HashMap<String, String>> ImageList = new ArrayList<>();


    @Override
    public void getRegisterdata(String user_id, String key) {
        Log.d(TAG, "getRegisterdata:bbbbbbbbbbbbbbbbbbbbbbbb "+user_id+key);
        Retrofit retrofit = RetrofitClass.getClient();
        apiinterface apiinterface =retrofit.create(apiinterface.class);


       apiinterface.datapost1(user_id, "koFCpCMzm8hhn9ULj0BnUzZkpqM3rg9Mqdii3FwPRjBwZFQWriIJYgB5jjOhNIyasSl4RrmCFLW3tHDRtI39viQbYEP7nEkYvba2wstThYWjvkndZq0zaXJaWjuqeZo8vR3MMHa6OhBDKsFPmWOlIM4H1TgB1fudQndGKzUPg8YhAoaAoCxZ562zjbQdPO73ZkwyPV7iOIkyH11ZLAN42a5dgLH22Rs1VasEWBKdfkqMLPfDbLQpF9Ofqah4fqwc")
               .enqueue(new retrofit2.Callback<JsonObject>()

               {
           @Override
           public void onResponse(retrofit2.Call<JsonObject> call, Response<JsonObject> response) {



               if (response.isSuccessful()) {
                   JsonObject jsonObject = response.body();


                   String status = jsonObject.get("status").getAsString();
                   String notificationCount = jsonObject.get("notification_count").getAsString();


                   JsonObject dataObject = jsonObject.getAsJsonObject("data");

                   JsonArray categoriesArray = dataObject.getAsJsonArray("categories");
                   for (int i = 0; i < categoriesArray.size(); i++) {
                       JsonObject categoriesObject = categoriesArray.get(i).getAsJsonObject();
                       String jcategory_id = categoriesObject.get("category_id").getAsString();
                       String jimage = categoriesObject.get("image").getAsString();
                       String jname = categoriesObject.get("name").getAsString();

                       HashMap<String, String> contact = new HashMap<>();
                       contact.put("category_id", jcategory_id);
                       contact.put("image", jimage);
                       contact.put("name", jname);

                       ImageList.add(contact);
                   }

                   callback.getResponse(status, ImageList);
               } else {
                   Log.e(TAG, "Unsuccessful response. Code: " + response.code());
               }
           }

                   @Override
                   public void onFailure(retrofit2.Call<JsonObject> call, Throwable t) {
                       Log.e(TAG, "Request failed: " + t.getMessage());
                   }
               });
    }

    @Override
    public Void getRegisterdata2(String user_id, String category_id, String key) {

        Retrofit retrofit1 = RetrofitClass.getClient();
        apiinterface apiinterface =retrofit1.create(apiinterface.class);

        apiinterface.datapost2(user_id, category_id, "koFCpCMzm8hhn9ULj0BnUzZkpqM3rg9Mqdii3FwPRjBwZFQWriIJYgB5jjOhNIyasSl4RrmCFLW3tHDRtI39viQbYEP7nEkYvba2wstThYWjvkndZq0zaXJaWjuqeZo8vR3MMHa6OhBDKsFPmWOlIM4H1TgB1fudQndGKzUPg8YhAoaAoCxZ562zjbQdPO73ZkwyPV7iOIkyH11ZLAN42a5dgLH22Rs1VasEWBKdfkqMLPfDbLQpF9Ofqah4fqwc")
                .enqueue(new retrofit2.Callback<JsonObject>() {
                    @Override
                    public void onResponse(retrofit2.Call<JsonObject> call, Response<JsonObject> response) {
                        Log.d("Data response", response.body().toString());
                        if (response.isSuccessful()) {
                            JsonObject jsonObject = response.body();

                            String status = jsonObject.get("status").getAsString();
                            String notificationCount = jsonObject.get("notification_count").getAsString();

                             JsonArray jarray = jsonObject.getAsJsonArray("data");
                            for (int i = 0; i < jarray.size(); i++){

                                JsonObject dataobj = jarray.get(i).getAsJsonObject();
                                String product_id = dataobj.get("product_id").getAsString();
                                String image = dataobj.get("image").getAsString();
                                String name = dataobj.get("name").getAsString();
                                String price = dataobj.get("price").getAsString();

                                HashMap<String, String> contact2 = new HashMap<>();

                                contact2.put("product_id",product_id);
                                contact2.put("image",image);
                                contact2.put("name",name);
                                contact2.put("price",price);

                                ImageList.add(contact2);
                                Log.d(TAG, "onResponse: Product ID: " + product_id + ", Name: " + name + ", Price: " + price + contact2 );

                            }

                            callback.categoryResponse(ImageList);

                        }

                    }

                    @Override
                    public void onFailure(retrofit2.Call<JsonObject> call, Throwable t) {
                        Log.e(TAG, "Request failed: " + t.getMessage());
                    }
                });
        return null;
    }
}