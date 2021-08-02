package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.ui.db.DBService;

public class RegisterActivity extends AppCompatActivity {
DBService dbService = DBService.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnRegister = findViewById(R.id.register);
        EditText textUser = findViewById(R.id.username);
        EditText textPassword = findViewById(R.id.password);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent (RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }


}