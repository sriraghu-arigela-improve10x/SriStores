package com.improve10x.sristores.products;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.sristores.databinding.ActivityProductDetailsBinding;
import com.improve10x.sristores.models.Product;
import com.improve10x.sristores.network.FakeApi;
import com.improve10x.sristores.network.FakeApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity {
        ActivityProductDetailsBinding binding;
        int productsId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Product details");
        if (getIntent().hasExtra("products")) {
            productsId = getIntent().getIntExtra("products", productsId);
        }
        fetchProductDetails();
    }

    private void fetchProductDetails() {
        FakeApi fakeApi = new FakeApi();
        FakeApiService fakeApiService = fakeApi.createFakeApiService();
        Call<Product> call = fakeApiService.fetchProductDetails(productsId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Product product = response.body();
                binding.setProduct(product);
                binding.ratingBar.setRating(product.rating.getRate());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
    }
}