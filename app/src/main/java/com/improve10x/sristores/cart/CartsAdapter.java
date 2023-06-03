package com.improve10x.sristores.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.sristores.databinding.CartItemBinding;
import com.improve10x.sristores.products.OnItemActionListener;

import java.util.List;

public class CartsAdapter extends RecyclerView.Adapter<CartsViewHolder> {
    private List<CartProduct> cartProducts;

    private OnItemActionListener onItemActionListener;

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

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
        holder.cartItemBinding.idTxt.setText(String.valueOf(cartProducts));
        holder.cartItemBinding.cartQuantityTxt.setText(String.valueOf(cartProducts));
        holder.cartItemBinding.increaseImageBtn.setOnClickListener(v -> {
            onItemActionListener.onClicked(cartProducts.get(position).getId());
        });
        holder.cartItemBinding.decreaseImageBtn.setOnClickListener(v -> {
            onItemActionListener.onClicked(cartProducts.get(position).getId());
        });
    }

    @Override
    public int getItemCount() {
        return cartProducts.size();
    }
}
