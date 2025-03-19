package com.example.recyclervw_complete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Categories;
import com.example.model.Category;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context    context;
    private Categories categories;
    private int        single_layout;

    public interface OnItemClickListener{
        public void onItemClicked(Category category);
    }

    public interface OnItemLongClickListener{
        public boolean onItemLongClicked(Category category);
    }

    private CategoryAdapter.OnItemClickListener listener;
    private CategoryAdapter.OnItemLongClickListener longlistener;

    public CategoryAdapter(Context context, Categories categories, int single_layout, OnItemClickListener listener, OnItemLongClickListener longlistener) {
        this.context = context;
        this.categories = categories;
        this.single_layout = single_layout;
        this.listener = listener;
        this.longlistener = longlistener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(single_layout, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        Category category = categories.get(position);

        if(category != null){
            holder.bind(category, listener, longlistener);
        }
    }

    @Override
    public int getItemCount() {
        return (categories == null) ? 0 : categories.size();
    }

    public void setToyCategories(Categories categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivCategory;
        private TextView  tvCategory;

        public CategoryViewHolder (@NonNull View itemView){
            super(itemView);

            ivCategory = itemView.findViewById(R.id.ivCategory);
            tvCategory = itemView.findViewById(R.id.tvCategory);
        }

        public void bind(Category category, OnItemClickListener listener, OnItemLongClickListener longlistener){
            tvCategory.setText(category.getName());

            itemView.setOnClickListener(v -> {
                listener.onItemClicked(category);
            });

            itemView.setOnLongClickListener(v -> {
                longlistener.onItemLongClicked(category);
                return true;
            });
        }
    }
}
