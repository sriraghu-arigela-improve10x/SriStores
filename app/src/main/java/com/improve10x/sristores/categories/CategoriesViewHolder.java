package com.improve10x.sristores.categories;

import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.sristores.databinding.CategoriesitemBinding;

public class CategoriesViewHolder extends RecyclerView.ViewHolder {
        CategoriesitemBinding binding;

    public CategoriesViewHolder(CategoriesitemBinding categoriesBinding) {
        super(categoriesBinding.getRoot());
        binding = categoriesBinding;
    }
}
