package com.example.myapplication.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.myapplication.databinding.FragmentGalleryBinding;

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

        btn150_fort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nuevo= Integer.parseInt(saldo.getText().toString())-150;
                saldo.setText(String.valueOf(nuevo));
            }
        });




        btn200_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nuevo= Integer.parseInt(saldo.getText().toString())-200;
                saldo.setText(String.valueOf(nuevo));
            }
        });

        btn120_COD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nuevo= Integer.parseInt(saldo.getText().toString())-120;
                saldo.setText(String.valueOf(nuevo));
            }
        });


    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}