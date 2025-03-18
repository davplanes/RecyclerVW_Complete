package com.example.recyclervw_complete;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davidkerman.viewmodel.CategoriesViewModel;
import com.example.model.Categories;
import com.example.model.Category;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CategoriesActivity extends AppCompatActivity {

    private RecyclerView         rvCategories;
    //private Categories           categories;
    private CategoryAdapter      cAdapter;
    private CategoriesViewModel  categoriesViewModel;
    private ConstraintLayout     inputCL;
    private FloatingActionButton fButton;

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
        setupViewModel();
        //getAllCategories();
        setRecyclerView();
    }

    private void setupViewModel() {
        categoriesViewModel = new
                ViewModelProvider(this).get(CategoriesViewModel.class);

        categoriesViewModel.getCategoriesMutableLiveData()
                .observe(this, Categories -> {
                    cAdapter.setToyCategories(Categories);
                });
    }


    private void setRecyclerView() {
        cAdapter = new CategoryAdapter(this, null, R.layout.category_single_layout);
        rvCategories.setAdapter(cAdapter);
        rvCategories.setLayoutManager(new LinearLayoutManager(this));
    }

    /*private void getAllCategories() {
        categories = new Categories();

        categories.add(new Category("Puzzles"));
        categories.add(new Category("Board Games"));
        categories.add(new Category("Card Games"));
        categories.add(new Category("Legos"));
        categories.add(new Category("Action figures"));
        categories.add(new Category("Pokemons"));
    }*/

    private void initializeViews() {
        rvCategories = findViewById(R.id.rvCategories);
        fButton = findViewById(R.id.fButton);
        inputCL = findViewById(R.id.inputCL);

        SetListeners();
    }

    private void SetListeners() {
        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputCL.getVisibility() == View.VISIBLE){
                    inputCL.setVisibility(View.GONE);
                }
                else{
                    inputCL.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}