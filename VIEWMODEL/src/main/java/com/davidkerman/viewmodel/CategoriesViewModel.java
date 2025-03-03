package com.davidkerman.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.model.Categories;

public class CategoriesViewModel extends ViewModel {
    private Categories categories;
    private MutableLiveData<Categories> categoriesMutableLiveData;

    public CategoriesViewModel(){
        categories = new Categories();
        categories.getAll();

        categoriesMutableLiveData = new MutableLiveData<>();
        categoriesMutableLiveData.setValue(categories);
    }

    public MutableLiveData<Categories> getCategoriesMutableLiveData() {
        return categoriesMutableLiveData;
    }
}
