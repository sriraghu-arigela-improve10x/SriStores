package com.improve10x.sristores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.improve10x.sristores.databinding.ActivityCategoriesBinding;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity {

    private ActivityCategoriesBinding binding;
    private ArrayList<String> categories;
    private CategoriesAdapter categoriesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Categories");
        setupData();
        setupCategoriesAdapter();
        setupCategoriesRv();
    }

    private void setupCategoriesAdapter() {
        categoriesAdapter = new CategoriesAdapter();
        categoriesAdapter.setData(categories);
    }

    private void setupCategoriesRv() {
        binding.categoriesRv.setLayoutManager(new LinearLayoutManager(this));
        binding.categoriesRv.setAdapter(categoriesAdapter);
    }

    private void setupData() {
        categories = new ArrayList<>();
        categories.add("electronics");
        categories.add("electronics");
        categories.add("electronics");
        categories.add("electronics");
        categories.add("electronics");
        categories.add("electronics");
    }
}