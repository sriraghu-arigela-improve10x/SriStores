package com.improve10x.sristores.cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.improve10x.sristores.R;
import com.improve10x.sristores.databinding.ActivityCartProductBinding;

import java.util.ArrayList;

public class CartProductActivity extends AppCompatActivity {

    private ActivityCartProductBinding binding;
    private ArrayList<CartProduct> cartProducts = new ArrayList<>();
    private CartsAdapter cartsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Cart");
        showProgressBar();
        hideProgressBar();
        setupCartRv();
    }

    private void setupCartRv() {

    }

    private void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }
}