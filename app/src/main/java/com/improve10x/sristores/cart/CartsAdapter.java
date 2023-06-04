package com.improve10x.sristores.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.sristores.databinding.CartItemBinding;
import com.improve10x.sristores.products.OnItemActionListener;

import java.util.List;

public class CartsAdapter extends RecyclerView.Adapter<CartsViewHolder> {
    private List<CartProductsDetails> cartProducts;

    void setData(List<CartProductsDetails> cartProductsList) {
        cartProducts = cartProductsList;
        notifyDataSetChanged();
    }

    private OnItemActionListener onItemActionListener;

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
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
        CartProductsDetails cartProductsDetails = new CartProductsDetails();
        holder.cartItemBinding.idTxt.setText(String.valueOf(cartProductsDetails.getProductId()));
        holder.cartItemBinding.cartQuantityTxt.setText(String.valueOf(cartProductsDetails.getProductId()));
    }

    @Override
    public int getItemCount() {
        return cartProducts.size();
    }
}
