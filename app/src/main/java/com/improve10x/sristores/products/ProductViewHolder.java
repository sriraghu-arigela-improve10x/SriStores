package com.improve10x.sristores.products;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.sristores.databinding.ProductitemBinding;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    ProductitemBinding binding;

    public ProductViewHolder(ProductitemBinding productitemBinding) {
        super(productitemBinding.getRoot());
        binding = productitemBinding;
    }
}
