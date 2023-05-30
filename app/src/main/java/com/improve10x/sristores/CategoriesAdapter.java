package com.improve10x.sristores;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.sristores.databinding.CategoriesitemBinding;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesViewHolder> {

    private ArrayList<Categories> categoriesList;
    void setData(ArrayList<Categories> categories) {
        categoriesList = categories;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoriesitemBinding binding = CategoriesitemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CategoriesViewHolder categoriesViewHolder = new CategoriesViewHolder(binding);
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        Categories categories = categoriesList.get(position);
        holder.binding.setCategories(categories);
    }
    @Override
    public int getItemCount() {
        return categoriesList.size();
    }
}
