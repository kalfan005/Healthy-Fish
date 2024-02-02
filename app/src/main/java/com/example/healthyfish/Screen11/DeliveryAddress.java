package com.example.healthyfish.Screen11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthyfish.R;
import com.example.healthyfish.Screen1.MainActivity;
import com.example.healthyfish.Screen12.AddAddress;
import com.example.healthyfish.Screen2.Registration;

public class DeliveryAddress extends AppCompatActivity {

    Button Checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deliveryaddress);

        Checkout = findViewById(R.id.Checkout);
        Checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryAddress.this, AddAddress.class);
                startActivity(intent);
            }
        });
    }
}