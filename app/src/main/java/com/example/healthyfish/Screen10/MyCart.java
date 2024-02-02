package com.example.healthyfish.Screen10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthyfish.R;
import com.example.healthyfish.Screen11.DeliveryAddress;

import java.util.ArrayList;
import java.util.List;

public class MyCart extends AppCompatActivity {

    Button button9;

    List<product2> productList2;


    RecyclerView recyclerView2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        productList2 = new ArrayList<>();

        productList2.add(
                new product2(
                        1,
                        "Indian mackerel/Ayala/Bangada/Aiyala(large)6+Count/kg",
                        199.00,
                        R.drawable.mackerel));

        productList2.add(
                new product2(
                        2,
                        "Pink Perch/Kilimeen/Sankara Meen/Thread Finned Bream(large)(180g to 310g)",
                        399.00,
                        R.drawable.mackerel));

        button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyCart.this, DeliveryAddress.class);
                startActivity(intent);
            }
        });

        ProductAdapter2 adapter = new ProductAdapter2(this, productList2);

        recyclerView2.setAdapter(adapter);
    }
}