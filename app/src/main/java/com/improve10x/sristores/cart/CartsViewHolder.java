package com.improve10x.sristores.cart;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.sristores.databinding.CartItemBinding;

public class CartsViewHolder extends RecyclerView.ViewHolder {

    CartItemBinding cartItemBinding;
    public CartsViewHolder(CartItemBinding cartItemBinding) {
        super(cartItemBinding.getRoot());
        this.cartItemBinding = cartItemBinding;
    }
}
