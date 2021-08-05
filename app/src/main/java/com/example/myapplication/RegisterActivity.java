package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.ui.data.entities.Client;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnRegister = findViewById(R.id.register);
        EditText textUser = findViewById(R.id.username);
        EditText textPassword = findViewById(R.id.password);
        EditText textRPassword = findViewById(R.id.passwordRepeat);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = textUser.getText().toString();
                String password = textPassword.getText().toString();
                String rPassword = textPassword.getText().toString();
                DatabaseReference db = FirebaseDatabase.getInstance().getReference();
                db.child("client").child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task.getException());
                        }else{
                            if(task.getResult().getValue()==null && password.equals(rPassword)){
                                Client client = new Client(username,password,200);
                                db.child("client").child(username).setValue(client);
                                Intent intent= new Intent (RegisterActivity.this, MainActivity.class);
                                startActivity(intent);
                            }else{
                                // TODO: HAGAN UN TOAST POFAVOR POFAVOCITO
                            }
                        }
                    }
                });
            }
        });



    }


}