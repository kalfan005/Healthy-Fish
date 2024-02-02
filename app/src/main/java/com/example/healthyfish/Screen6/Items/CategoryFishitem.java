package com.example.healthyfish.Screen6.Items;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.healthyfish.R;
import com.example.healthyfish.Screen6.Categoryclasses.Call;
import com.example.healthyfish.Screen6.Categoryclasses.Callback;
import com.example.healthyfish.Screen6.Categoryclasses.Controller;


import java.util.ArrayList;

public class CategoryFishitem extends AppCompatActivity implements Callback {

    private static final String TAG = "CategoryFishitem";
    private Call call;
    RecyclerView recyclerViewfish;
    String category_id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_fishitem);

        Intent intent = getIntent();
        if (intent != null) {
            category_id = intent.getStringExtra("category_id");
        }


            recyclerViewfish = findViewById(R.id.recyclerViewfish);


        call = new Controller(getApplicationContext(), this);
        call.getRegisterdata2("368",category_id, "koFCpCMzm8hhn9ULj0BnUzZkpqM3rg9Mqdii3FwPRjBwZFQWriIJYgB5jjOhNIyasSl4RrmCFLW3tHDRtI39viQbYEP7nEkYvba2wstThYWjvkndZq0zaXJaWjuqeZo8vR3MMHa6OhBDKsFPmWOlIM4H1TgB1fudQndGKzUPg8YhAoaAoCxZ562zjbQdPO73ZkwyPV7iOIkyH11ZLAN42a5dgLH22Rs1VasEWBKdfkqMLPfDbLQpF9Ofqah4fqwc");



    }

    @Override
    public void getResponse(String message, ArrayList list) {



    }

    @Override
    public void categoryResponse(ArrayList list) {
        Log.d(TAG, "categoryResponse: mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"+list);
        MyListAdapter2 adapter = new MyListAdapter2(list);
        recyclerViewfish.setHasFixedSize(true);
        recyclerViewfish.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewfish.setAdapter(adapter);

    }
}
