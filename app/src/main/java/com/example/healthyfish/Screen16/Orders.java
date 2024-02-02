package com.example.healthyfish.Screen16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.healthyfish.R;
import com.example.healthyfish.Screen9.ProductAdapter;
import com.example.healthyfish.Screen9.product;

import java.util.ArrayList;
import java.util.List;

public class Orders extends AppCompatActivity {

    List<product3> productList3;


    RecyclerView recyclerView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orders);


        recyclerView3 = (RecyclerView) findViewById(R.id.recyclerView3);
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));

        productList3 = new ArrayList<>();

        productList3.add(
                new product3(
                        1,
                        "Tilapia/ Jilebi Fish(100g to 240g)",
                        "Shipped",
                        "Delivery between 12PM to 2PM on sat,11th Feb",
                         "Order ID",
                        1235467891,
                        R.drawable.mackerel));

        productList3.add(
                new product3(
                        2,
                        "Pink Perch/ kilimeen/Sankara meen/Thread Finned Bream(Large)(180g to 310g)",
                        "Delivered",
                        "Delivery on 20 Apr 2018",
                        "Order ID",
                        1234567892,
                        R.drawable.catla));

        productList3.add(
                new product3(
                        3,
                        "Tilapia/ Jilebi Fish(100g to 240g)",
                        "Delivered",
                        "Delivery on 20 Apr 2018",
                        "Order ID :",
                        1234567893,
                       R.drawable.cod));

        ProductAdapter3 adapter = new ProductAdapter3(this,productList3);

        recyclerView3.setAdapter(adapter);


    }
}