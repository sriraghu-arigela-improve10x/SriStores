package com.improve10x.sristores.products;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.improve10x.sristores.R;
import com.improve10x.sristores.databinding.ActivityProductDetailsBinding;

public class ProductDetails extends AppCompatActivity {
        ActivityProductDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Product details");
    }
}