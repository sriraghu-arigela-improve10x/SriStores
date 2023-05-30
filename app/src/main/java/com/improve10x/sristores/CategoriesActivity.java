package com.improve10x.sristores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.sristores.databinding.ActivityCategoriesBinding;

public class CategoriesActivity extends AppCompatActivity {

    private ActivityCategoriesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Categories");
    }
}