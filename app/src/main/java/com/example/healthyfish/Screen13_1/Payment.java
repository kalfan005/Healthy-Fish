package com.example.healthyfish.Screen13_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthyfish.R;
import com.example.healthyfish.Screen12.AddAddress;
import com.example.healthyfish.Screen13_2.PaymentConfirmation;

public class Payment extends AppCompatActivity {

    Button Checkout3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

        Checkout3 = findViewById(R.id.Checkout3);
        Checkout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payment.this, PaymentConfirmation.class);
                startActivity(intent);
            }
        });
    }
}