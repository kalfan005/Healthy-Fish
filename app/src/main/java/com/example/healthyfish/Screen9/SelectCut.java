package com.example.healthyfish.Screen9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthyfish.Screen10.MyCart;
import com.example.healthyfish.R;

import java.util.ArrayList;
import java.util.List;

public class SelectCut extends AppCompatActivity {

    Button buttonnSC;

    List<product> productList;


    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cut);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();

        productList.add(
                new product(
                        1,
                        "Curry Cut(with skin)",
                        "Gross wt.approx.500g|Net wt.500g",
                        349.00/500,
                        R.drawable.catla));

        productList.add(
                new product(
                        2,
                        "Fry Cut",
                        "Gross wt.approx.500g|Net wt.500g",
                        349.00/500,
                        R.drawable.cod));

        productList.add(
                new product(
                        3,
                        "Customize",
                        "Gross wt.approx.500g|Net wt.500g",
                        349.00/500,
                        R.drawable.salmon));

        productList.add(
                new product(
                        4,
                        "Whole(cleaned)",
                        "Gross wt.approx.500g|Net wt.500g",
                        349.00/500,
                        R.drawable.mackerel));

        productList.add(
                new product(
                        5,
                        "Whole(not cleaned)",
                        "Gross wt.approx.500g|Net wt.500g",
                        349.00/500,
                        R.drawable.hake));

        buttonnSC = findViewById(R.id.buttonnSC);
        buttonnSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCut.this, MyCart.class);
                startActivity(intent);
            }
        });


        ProductAdapter adapter = new ProductAdapter(this, productList);

        recyclerView.setAdapter(adapter);


    }
}