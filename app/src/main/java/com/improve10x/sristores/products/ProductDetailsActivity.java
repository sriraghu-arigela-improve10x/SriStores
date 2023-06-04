package com.improve10x.sristores.products;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.improve10x.sristores.BaseActivity;
import com.improve10x.sristores.Constants;
import com.improve10x.sristores.R;
import com.improve10x.sristores.cart.CartProductActivity;
import com.improve10x.sristores.databinding.ActivityProductDetailsBinding;
import com.improve10x.sristores.models.Product;
import com.improve10x.sristores.network.FakeApi;
import com.improve10x.sristores.network.FakeApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends BaseActivity {
        private ActivityProductDetailsBinding binding;
        private int productsId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Product details");
        if (getIntent().hasExtra(Constants.KEY_PRODUCTS_VALUE)) {
            productsId = getIntent().getIntExtra(Constants.KEY_PRODUCTS_VALUE, productsId);
        }
        fetchProductDetails();
    }

    private void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    private void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void fetchProductDetails() {
        showProgressBar();
        Call<Product> call = fakeApiService.fetchProductDetails(productsId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                hideProgressBar();
                Product product = response.body();
                binding.setProduct(product);
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                hideProgressBar();
                showToast("Failed to load the data");
            }
        });
    }
}