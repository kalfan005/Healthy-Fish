package com.example.healthyfish.Screen13_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthyfish.R;
import com.example.healthyfish.Screen13.OrderPlaceActivity;
import com.example.healthyfish.Screen13_1.Payment;

public class PaymentConfirmation extends AppCompatActivity {

    Button placeorder;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_confirmation);

        placeorder = findViewById(R.id.placeorder);
        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentConfirmation.this, OrderPlaceActivity.class);
                startActivity(intent);
            }
        });

    }
}