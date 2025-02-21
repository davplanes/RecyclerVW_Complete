package com.example.recyclervw_complete;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Categories;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {


    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        public CategoryViewHolder (@NonNull View itemView){
            super(itemView);
        }
    }
}
