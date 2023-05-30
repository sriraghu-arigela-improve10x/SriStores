package com.improve10x.sristores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.sristores.databinding.ActivityElectronicsBinding;

public class ElectronicsActivity extends AppCompatActivity {

    private ActivityElectronicsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityElectronicsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}