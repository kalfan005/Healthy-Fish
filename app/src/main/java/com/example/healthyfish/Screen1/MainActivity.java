package com.example.healthyfish.Screen1;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthyfish.R;
import com.example.healthyfish.Screen1.Controller.LoginController;
import com.example.healthyfish.Screen1.apiinterface.LoginCall;
import com.example.healthyfish.Screen1.apiinterface.LoginCallback;
import com.example.healthyfish.Screen16.Orders;
import com.example.healthyfish.Screen2.Registration;
import com.example.healthyfish.Screen6.Home1;
import com.example.healthyfish.Screen7.Freshfish;

public class MainActivity extends AppCompatActivity implements LoginCallback {

    private LoginCall loginCall;

    String email,password,key;

    EditText edttxt_email,edttxt_password;

    Button lgn_btn;

    TextView textrgst;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          edttxt_email = findViewById(R.id.edttxt_email);
          edttxt_password = findViewById(R.id.edttxt_password);
          lgn_btn = findViewById(R.id.lgn_btn);

        loginCall = new LoginController(getApplicationContext(),this);

          lgn_btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
               email = edttxt_email.getText().toString();
               password = edttxt_password.getText().toString();

                  loginCall.getLogindata(email,password,key);
                  Toast.makeText(MainActivity.this, "Button pressed", Toast.LENGTH_SHORT).show();
              }
          });


        textrgst = findViewById(R.id.textrgst);

        textrgst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void getResponse(String status, String message) {

        if (message.equals("success")) {
            Intent i = new Intent(getApplicationContext(), Home1.class);
            Toast.makeText(getApplicationContext(), status + message, Toast.LENGTH_SHORT).show();
            startActivity(i);
            Log.d(TAG,"getResponse :"+status+message);
        }
        else {
            Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
        }

    }
}
