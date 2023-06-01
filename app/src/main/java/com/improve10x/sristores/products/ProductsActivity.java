package com.improve10x.sristores.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.sristores.databinding.ActivityProductsBinding;
import com.improve10x.sristores.models.Product;
import com.improve10x.sristores.network.FakeApi;
import com.improve10x.sristores.network.FakeApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends AppCompatActivity {

        private ActivityProductsBinding binding;
        private ArrayList<Product> products = new ArrayList<>();
        private ProductAdapter productAdapter;
        String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Products");
        if(getIntent().hasExtra("category")){
            category = getIntent().getStringExtra("category");
        }
        fetchProducts();
        setupData();
        setProductAdapter();
        setProductRv();
    }

    private void fetchProducts() {
        FakeApi fakeApi = new FakeApi();
        FakeApiService fakeApiService = fakeApi.createFakeApiService();
        Call<List<Product>> call = fakeApiService.fetchProducts(category);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> productsList = response.body();
                productAdapter.setData(productsList);
                Toast.makeText(ProductsActivity.this, "SuccesFully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(ProductsActivity.this, "Failed to load Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setProductAdapter() {
        productAdapter = new ProductAdapter();
        productAdapter.setData(products);
        productAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onClicked(int productsId) {
                Intent intent = new Intent(getApplicationContext(), ProductDetailsActivity.class);
                intent.putExtra("products", productsId);
                startActivity(intent);
            }
        });
    }

    private void setProductRv() {
        binding.productRv.setLayoutManager(new GridLayoutManager(this, 2));
        binding.productRv.setAdapter(productAdapter);
    }

    private void setupData() {
        products = new ArrayList<>();
    }
}