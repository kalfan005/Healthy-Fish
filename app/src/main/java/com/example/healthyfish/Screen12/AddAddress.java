package com.example.healthyfish.Screen12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthyfish.R;
import com.example.healthyfish.Screen11.DeliveryAddress;
import com.example.healthyfish.Screen13_1.Payment;

public class AddAddress extends AppCompatActivity {
    Button Checkout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addaddress);

        Checkout2 = findViewById(R.id.Checkout2);
        Checkout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddAddress.this, Payment.class);
                startActivity(intent);
            }
        });
    }
}