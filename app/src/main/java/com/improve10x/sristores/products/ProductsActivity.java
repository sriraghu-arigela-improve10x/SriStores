package com.improve10x.sristores.products;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.improve10x.sristores.BaseActivity;
import com.improve10x.sristores.Constants;
import com.improve10x.sristores.R;
import com.improve10x.sristores.cart.CartProductActivity;
import com.improve10x.sristores.categories.CategoriesActivity;
import com.improve10x.sristores.databinding.ActivityProductsBinding;
import com.improve10x.sristores.models.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends BaseActivity {

        private ActivityProductsBinding binding;
        private ArrayList<Product> products = new ArrayList<>();
        private ProductAdapter productAdapter;

         private String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Products");
        if(getIntent().hasExtra(Constants.KEY_CATEGORY_VALUE)){
            category = getIntent().getStringExtra(Constants.KEY_CATEGORY_VALUE);
        }
        fetchProducts();
        setupProductAdapter();
        setupProductRv();


    }

    private void showProgressbar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    private void fetchProducts() {
        showProgressbar();
        Call<List<Product>> call = fakeApiService.fetchProducts(category);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                hideProgressBar();
                List<Product> productsList = response.body();
                productAdapter.setData(productsList);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                hideProgressBar();
                showToast("Failed to load the data");
            }
        });
    }
    private void setupProductAdapter() {
        productAdapter = new ProductAdapter();
        productAdapter.setData(products);
        productAdapter.setOnItemActionListener(productsId -> {
            Intent intent = new Intent(ProductsActivity.this, ProductDetailsActivity.class);
            intent.putExtra(Constants.KEY_PRODUCTS_VALUE, productsId);
            startActivity(intent);
        });
    }

    private void setupProductRv() {
        binding.productRv.setLayoutManager(new GridLayoutManager(this, 2));
        binding.productRv.setAdapter(productAdapter);
    }
}