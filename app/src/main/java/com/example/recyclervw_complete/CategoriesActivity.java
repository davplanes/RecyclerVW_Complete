package com.example.recyclervw_complete;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Categories;
import com.example.model.Category;

public class CategoriesActivity extends AppCompatActivity {

    private RecyclerView    rvCategories;
    private Categories      categories;
    private CategoryAdapter cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_categories);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeViews();

        getAllCategories();
        setRecyclerView();
    }

    private void setRecyclerView() {
        cAdapter = new CategoryAdapter(this, categories, R.layout.category_single_layout);
        rvCategories.setAdapter(cAdapter);
        rvCategories.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getAllCategories() {
        categories = new Categories();

        categories.add(new Category("Puzzles"));
        categories.add(new Category("Board Games"));
        categories.add(new Category("Card Games"));
        categories.add(new Category("Legos"));
        categories.add(new Category("Action figures"));
        categories.add(new Category("Pokemons"));
    }

    private void initializeViews() {
        rvCategories = findViewById(R.id.rvCategories);
    }
}