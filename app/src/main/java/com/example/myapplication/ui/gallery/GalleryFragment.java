package com.example.myapplication.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.LoginActivity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.RegisterActivity;
import com.example.myapplication.databinding.FragmentGalleryBinding;
import com.example.myapplication.ui.data.entities.Client;
import com.example.myapplication.ui.data.entities.Inventory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    EditText saldo;
    Button btn200_mine, btn150_fort, btn120_COD;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        saldo = view.findViewById(R.id.saldo);
        btn200_mine = view.findViewById(R.id.costo200Minecraft);
        btn150_fort = view.findViewById(R.id.costo150Fortnite);
        btn120_COD = view.findViewById(R.id.costo120COD);


        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        db.child("client").child("admin").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                try{
                    saldo.setText(String.valueOf(task.getResult().getValue(Client.class).getBalance()));
                }catch (Exception e){
                    // Toast, error.
                }
            }
        });

        btn150_fort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int precio = 150;
                db.child("client").child("admin").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        try{
                            Client client = task.getResult().getValue(Client.class);
                            if(precio > client.getBalance()){
                                //Toast, sin dinero.
                                return;
                            }
                            db.child("inventory").child("admin").child("Fortnite").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if(task.getResult().getValue() == null){
                                        db.child("inventory").child("admin").child("Fortnite").setValue(true);
                                        db.child("client").child("admin").child("balance").setValue(client.getBalance()-precio);
                                        saldo.setText(String.valueOf(client.getBalance()-precio));
                                    }else{
                                        //toast, ya tienes el juego.
                                    }
                                }
                            });
                        }catch (Exception e){
                            // Toast, error.
                        }
                    }
                });
            }
        });




        btn200_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int precio = 200;
                db.child("client").child("admin").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        try{
                            Client client = task.getResult().getValue(Client.class);
                            if(precio > client.getBalance()){
                                //Toast, sin dinero.
                                return;
                            }
                            db.child("inventory").child("admin").child("Minecraft").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if(task.getResult().getValue() == null){
                                        db.child("inventory").child("admin").child("Minecraft").setValue(true);
                                        db.child("client").child("admin").child("balance").setValue(client.getBalance()-precio);
                                        saldo.setText(String.valueOf(client.getBalance()-precio));
                                    }else{
                                        //toast, ya tienes el juego.
                                    }
                                }
                            });
                        }catch (Exception e){
                            // Toast, error.
                        }
                    }
                });
            }
        });

        btn120_COD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int precio = 120;
                //int nuevo= Integer.parseInt(saldo.getText().toString())-precio;
                //saldo.setText(String.valueOf(nuevo));
                db.child("client").child("admin").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        try{
                            Client client = task.getResult().getValue(Client.class);
                            if(precio > client.getBalance()){
                                //Toast, sin dinero.
                                return;
                            }
                            db.child("inventory").child("admin").child("Call of Duty").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if(task.getResult().getValue() == null){
                                        db.child("inventory").child("admin").child("Call of Duty").setValue(true);
                                        db.child("client").child("admin").child("balance").setValue(client.getBalance()-precio);
                                        saldo.setText(String.valueOf(client.getBalance()-precio));
                                    }else{
                                        //toast, ya tienes el juego.
                                    }
                                }
                            });
                        }catch (Exception e){
                            // Toast, error.
                        }
                    }
                });
            }
        });


    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}