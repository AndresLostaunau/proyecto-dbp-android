package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.login);
        Button btnRegLogin = findViewById(R.id.registerLogin);
        EditText textUser = findViewById(R.id.usernameLogin);
        EditText textPassword = findViewById(R.id.passwordLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent (LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnRegLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent (LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}