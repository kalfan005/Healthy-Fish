package com.example.healthyfish.Screen13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthyfish.R;
import com.example.healthyfish.Screen13_2.PaymentConfirmation;
import com.example.healthyfish.Screen15.EditProfile;

public class OrderPlaceActivity extends AppCompatActivity {

    Button bbb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_place);

        bbb = findViewById(R.id.bbb);

        bbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderPlaceActivity.this, EditProfile.class);
                startActivity(intent);
            }
        });
    }
}