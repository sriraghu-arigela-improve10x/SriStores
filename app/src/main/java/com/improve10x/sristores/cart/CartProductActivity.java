package com.improve10x.sristores.cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.improve10x.sristores.BaseActivity;
import com.improve10x.sristores.R;
import com.improve10x.sristores.databinding.ActivityCartProductBinding;
import com.improve10x.sristores.network.FakeApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartProductActivity extends BaseActivity {

    private ActivityCartProductBinding binding;
    private ArrayList<CartProductsDetails> cartProducts = new ArrayList<>();
    private CartsAdapter cartsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Cart");
        showProgressBar();
        hideProgressBar();
        fetchCartProducts();
        setupCartAdapter();
        setupCartRv();

    }

    private void fetchCartProducts() {
        Call<CartProduct> call = fakeApiService.fetchCartProducts();
        call.enqueue(new Callback<CartProduct>() {
            @Override
            public void onResponse(Call<CartProduct> call, Response<CartProduct> response) {
                CartProduct cartProduct = response.body();
                cartsAdapter.setData(cartProduct.products);
            }

            @Override
            public void onFailure(Call<CartProduct> call, Throwable t) {
                showToast("Failed");
            }
        });
    }

    private void setupCartAdapter() {
        cartsAdapter = new CartsAdapter();
        cartsAdapter.setData(cartProducts);
    }

    private void setupCartRv() {
        binding.cartRv.setLayoutManager(new LinearLayoutManager(this));
        binding.cartRv.setAdapter(cartsAdapter);
    }

    private void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }
}