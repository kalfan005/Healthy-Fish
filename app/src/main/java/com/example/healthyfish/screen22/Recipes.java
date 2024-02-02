package com.example.healthyfish.screen22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.healthyfish.R;
import com.example.healthyfish.Screen6.Categoryclasses.Call;
import com.example.healthyfish.Screen6.Items.MyListAdapter2;

import java.util.ArrayList;
import java.util.List;

public class Recipes extends AppCompatActivity implements Callback2 {

    private static final String TAG = "Recipes";
    private Call2 call2;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        recyclerView = findViewById(R.id.idCourseRV);

        call2 = new Controller(getApplicationContext(),this);
        call2.getRegisterdata("368","koFCpCMzm8hhn9ULj0BnUzZkpqM3rg9Mqdii3FwPRjBwZFQWriIJYgB5jjOhNIyasSl4RrmCFLW3tHDRtI39viQbYEP7nEkYvba2wstThYWjvkndZq0zaXJaWjuqeZo8vR3MMHa6OhBDKsFPmWOlIM4H1TgB1fudQndGKzUPg8YhAoaAoCxZ562zjbQdPO73ZkwyPV7iOIkyH11ZLAN42a5dgLH22Rs1VasEWBKdfkqMLPfDbLQpF9Ofqah4fqwc");
    }

    @Override
    public void getResponse(ArrayList list) {

        RecipesAdapter adapter = new RecipesAdapter(list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}