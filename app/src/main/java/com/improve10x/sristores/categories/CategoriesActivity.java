package com.improve10x.sristores.categories;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.improve10x.sristores.network.FakeApi;
import com.improve10x.sristores.network.FakeApiService;
import com.improve10x.sristores.databinding.ActivityCategoriesBinding;
import com.improve10x.sristores.products.ProductsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends AppCompatActivity {

    private ActivityCategoriesBinding binding;
    private ArrayList<String> categories = new ArrayList<>();
    private CategoriesAdapter categoriesAdapter;
    private FakeApiService fakeApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Categories");
        setupData();
        setupCategoriesAdapter();
        setupCategoriesRv();
        setupApiService();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchCategories();
    }

    private void fetchCategories() {
        Call<List<String>> call = fakeApiService.fetchCategories();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<String> categoryList = response.body();
                categoriesAdapter.setData(categoryList);
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(CategoriesActivity.this, "Failed to Load", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupApiService() {
        FakeApi fakeApi = new FakeApi();
        fakeApiService = fakeApi.createFakeApiService();
    }

    private void setupCategoriesAdapter() {
        categoriesAdapter = new CategoriesAdapter();
        categoriesAdapter.setData(categories);
        categoriesAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onClicked(String categoryName) {
                Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
                intent.putExtra("category", categoryName);
                startActivity(intent);
            }
        });
    }

    private void setupCategoriesRv() {
        binding.categoriesRv.setLayoutManager(new LinearLayoutManager(this));
        binding.categoriesRv.setAdapter(categoriesAdapter);
    }

    private void setupData() {
        /*categories = new ArrayList<>();
        *//*categories.add("electronics");
        categories.add("electronics");
        categories.add("electronics");
        categories.add("electronics");
        categories.add("electronics");
        categories.add("electronics");*/
    }
}