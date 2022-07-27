package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    Button sighIn;
    EditText username;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        sighIn.setOnClickListener(v->{
            if(username.getText().toString().matches(emailPattern)){
                Intent intent = new Intent(this,DashboardActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(this,"Please Enter Valid Email.",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        sighIn = findViewById(R.id.signIn);
        username = findViewById(R.id.userId);
    }
}