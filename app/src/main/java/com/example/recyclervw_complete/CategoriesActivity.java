package com.example.recyclervw_complete;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.davidkerman.viewmodel.CategoriesViewModel;
import com.example.model.Categories;
import com.example.model.Category;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CategoriesActivity extends AppCompatActivity {

    private RecyclerView         rvCategories;
    private CategoryAdapter      cAdapter;
    private CategoriesViewModel  categoriesViewModel;
    private ConstraintLayout     inputCL;
    private FloatingActionButton fButton;
    private EditText             categoryinput;
    private ImageView            vButton;
    private ImageView            xButton;

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
        setRecyclerView();
    }

    private void setupViewModel() {
        categoriesViewModel = new
                ViewModelProvider(this).get(CategoriesViewModel.class);

        categoriesViewModel.getCategoriesMutableLiveData()
                .observe(this, Categories -> {
                    cAdapter.setToyCategories(Categories);
                });

        categoriesViewModel.getSuccessLivedata().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Toast.makeText(CategoriesActivity.this, "This category already exists", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setRecyclerView() {
        CategoryAdapter.OnItemLongClickListener longlistener = new CategoryAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClicked(Category category) {
                int position = categoriesViewModel.getCategoriesMutableLiveData().getValue().indexOf(category);
                if (position >= 0){
                    categoriesViewModel.delete(position);
                    return true;
                }
                return false;
            }
        };

        cAdapter = new CategoryAdapter(this, null, R.layout.category_single_layout, longlistener);
        rvCategories.setAdapter(cAdapter);
        rvCategories.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initializeViews() {
        rvCategories = findViewById(R.id.rvCategories);
        categoryinput = findViewById(R.id.categoryinput);
        vButton = findViewById(R.id.vbutton);
        xButton = findViewById(R.id.xbutton);
        fButton = findViewById(R.id.fButton);
        inputCL = findViewById(R.id.inputCL);

        SetListeners();
    }

    private void SetListeners() {
        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputCL.setVisibility(View.VISIBLE);
            }
        });

        vButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (categoryinput.getText().toString().isEmpty())
                    Toast.makeText(CategoriesActivity.this, "Please enter the category that you want to add", Toast.LENGTH_SHORT).show();

                else{
                    Category category_to_add = new Category(categoryinput.getText().toString());
                    categoriesViewModel.add(category_to_add);

                }
            }
        });

        xButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryinput.setText("");
                inputCL.setVisibility(View.GONE);
            }
        });
    }
}