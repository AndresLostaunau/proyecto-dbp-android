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

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        EditText saldo = root.findViewById(R.id.saldo);
        Button btn200 = root.findViewById(R.id.costo200);
        Button btn150 = root.findViewById(R.id.costo150);

        btn150.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nuevo= Integer.parseInt(saldo.getText().toString())-150;
                saldo.setText(String.valueOf(nuevo));
            }
        });

        btn200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nuevo= Integer.parseInt(saldo.getText().toString())-200;
                saldo.setText(String.valueOf(nuevo));
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}