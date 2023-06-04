package com.improve10x.sristores.categories;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.improve10x.sristores.BaseActivity;
import com.improve10x.sristores.Constants;
import com.improve10x.sristores.R;
import com.improve10x.sristores.cart.CartProductActivity;
import com.improve10x.sristores.network.FakeApi;
import com.improve10x.sristores.network.FakeApiService;
import com.improve10x.sristores.databinding.ActivityCategoriesBinding;
import com.improve10x.sristores.products.ProductsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends BaseActivity {

    private ActivityCategoriesBinding binding;
    private List<Category> categories = new ArrayList<>();
    private CategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Categories");
        fetchCategories();
        setupCategoriesAdapter();
        setupCategoriesRv();

    }

    private void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    private void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void fetchCategories() {
        showProgressBar();
        Call<List<Category>> call = fakeApiService.fetchCategories();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                hideProgressBar();
                List<Category> categoryList = response.body();
                categoriesAdapter.setData(categoryList);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                hideProgressBar();
                showToast("Failed to load the data");
            }
        });
    }

    private void setupCategoriesAdapter() {
        categoriesAdapter = new CategoriesAdapter();
        categoriesAdapter.setData(categories);
        categoriesAdapter.setOnItemActionListener(categoryName -> {
            Intent intent = new Intent(CategoriesActivity.this, ProductsActivity.class);
            intent.putExtra(Constants.KEY_CATEGORY_VALUE, categoryName);
            startActivity(intent);
        });
    }

    private void setupCategoriesRv() {
        binding.categoriesRv.setLayoutManager(new LinearLayoutManager(this));
        binding.categoriesRv.setAdapter(categoriesAdapter);
    }
}