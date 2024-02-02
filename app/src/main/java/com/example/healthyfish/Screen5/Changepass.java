package com.example.healthyfish.Screen5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthyfish.Screen6.Home1;
import com.example.healthyfish.Screen7.Freshfish;
import com.example.healthyfish.R;

public class Changepass extends AppCompatActivity {

    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepass);

       button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Changepass.this, Home1.class);
                startActivity(intent);
            }
        });

    }
}