package com.improve10x.sristores.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.sristores.databinding.CartItemBinding;

import java.util.List;

public class CartsAdapter extends RecyclerView.Adapter<CartsViewHolder> {
    private List<CartProduct> cartProducts;

    void setData(List<CartProduct> cartProductsList) {
        cartProducts = cartProductsList;
    }
    @NonNull
    @Override
    public CartsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartItemBinding cartItemBinding = CartItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CartsViewHolder cartsViewHolder = new CartsViewHolder(cartItemBinding);
        return cartsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return cartProducts.size();
    }
}
