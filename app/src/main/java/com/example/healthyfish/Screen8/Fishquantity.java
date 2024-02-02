package com.example.healthyfish.Screen8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthyfish.R;
import com.example.healthyfish.Screen10.MyCart;
import com.example.healthyfish.Screen11.DeliveryAddress;
import com.example.healthyfish.Screen7.Freshfish;
import com.example.healthyfish.Screen7.GridAdapter1;
import com.example.healthyfish.Screen7.Griditem1;
import com.example.healthyfish.Screen9.SelectCut;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Fishquantity extends AppCompatActivity  {

    private int counter = 0;
    private int counter2 = 100;
    private TextView counterTextView,counterTextView2,viewmore;
     Button increaseButton,decreaseButton,
             increaseButton2,decreaseButton2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishquantity);

        Intent intent = this.getIntent();
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        String imageUrl = intent.getStringExtra("image");

        TextView textViewProductName = this.findViewById(R.id.textViewProductName);
        TextView textViewProductPrice = this.findViewById(R.id.textViewProductPrice);
        ImageView imageViewProduct = this.findViewById(R.id.imageViewProduct);
        textViewProductName.setText(name);
        textViewProductPrice.setText(price);
        Picasso.get().load(imageUrl).into(imageViewProduct);

        viewmore = findViewById(R.id.viewmore);

        viewmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tx = new Intent(Fishquantity.this, Freshfish.class);
                startActivity(tx);
            }
        });


        counterTextView = findViewById(R.id.counterTextView);
        Button increaseButton = findViewById(R.id.increaseButton);
        decreaseButton = findViewById(R.id.decreaseButton);

        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                updateCounterTextView();
            }
        });

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0) {
                    counter--;
                    updateCounterTextView();
                }
            }
        });


        counterTextView2 = findViewById(R.id.counterTextView2);
        Button increaseButton2 = findViewById(R.id.increaseButton2);

        decreaseButton2 = findViewById(R.id.decreaseButton2);

        increaseButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter2++;
                updateCounterTextView2();
            }
        });

        decreaseButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter2 > 0) {
                    counter2--;
                    updateCounterTextView2();
                }
            }
        });

    }

    private void updateCounterTextView2() {

        counterTextView2.setText(String.valueOf(counter2));
    }

    private void updateCounterTextView() {

        counterTextView.setText(String.valueOf(counter));
    }



}
