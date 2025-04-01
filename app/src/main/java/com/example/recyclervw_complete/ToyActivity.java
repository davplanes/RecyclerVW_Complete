package com.example.recyclervw_complete;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.davidkerman.viewmodel.CategoriesViewModel;
import com.example.model.Categories;
import com.example.model.Category;

public class ToyActivity extends AppCompatActivity {

    private CategoriesViewModel viewModel;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_toy);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        InitializeViews();
        setUpViewModel();
    }

    private void InitializeViews() {
        spinner = findViewById(R.id.spinnerCategories);
    }

    private void setUpViewModel() {
        viewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);
        viewModel.getCategoriesMutableLiveData().observe(this, categories -> spinner.setAdapter(new ArrayAdapter<Category>(ToyActivity.this, android.R.layout.simple_dropdown_item_1line, categories)));
    }
}