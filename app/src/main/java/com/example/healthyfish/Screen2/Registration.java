package com.example.healthyfish.Screen2;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthyfish.Screen1.MainActivity;
import com.example.healthyfish.Screen2.Controller.RegisterController;
import com.example.healthyfish.Screen2.apiinterface.RegisterCall;
import com.example.healthyfish.Screen2.apiinterface.RegisterCallBack;
import com.example.healthyfish.Screen3.Forgotpass;
import com.example.healthyfish.R;

public class Registration extends AppCompatActivity implements RegisterCallBack {

    private RegisterCall registercall;

    String firstname,lastname,email,telephone,password,type,referal_code,key;

    EditText editTextfname,editTextlname,editTextemail,editTextmobile,
            editTextpassword,editTexttype,editTextreferal;

    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editTextfname = findViewById(R.id.editTextfname);
        editTextlname = findViewById(R.id.editTextlname);
        editTextemail = findViewById(R.id.editTextemail);
        editTextmobile = findViewById(R.id.editTextmobile);
        editTextpassword = findViewById(R.id.editTextpassword);
        editTexttype = findViewById(R.id.editTexttype);
        editTextreferal = findViewById(R.id.editTextreferal);

         register = findViewById(R.id.register);

         registercall = new RegisterController(getApplicationContext(),this);

         register.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
               firstname = editTextfname.getText().toString();
               lastname = editTextlname.getText().toString();
               email = editTextemail.getText().toString();
               telephone = editTextmobile.getText().toString();
               password = editTextpassword.getText().toString();
               type = editTexttype.getText().toString();
               referal_code = editTextreferal.getText().toString();


               registercall.getRegisterdata(firstname,lastname,email,telephone,
                       password,type,referal_code,key);
                 Log.d(TAG,"onClick: "+firstname+lastname+email+telephone+
                         password+type+referal_code);

             }
         });

    }

    @Override
    public void getResponse(String message, String status) {

        if (status.equals("successfuly logged")){
            Toast.makeText(getApplicationContext(), message + status , Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), MainActivity.class);

            startActivity(i);
        }
        else {
            Toast.makeText(this, "already registered", Toast.LENGTH_SHORT).show();
        }

    }
}