package com.davidkerman.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.model.Categories;
import com.example.model.Category;

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

    public void add(Category categoryToAdd) {
        categories.add(categoryToAdd);
        categoriesMutableLiveData.setValue(categories);
    }

    public boolean IsIn(Category category){
        return categories.stream().anyMatch(Category -> Category.getName().equals(category.getName()));
    }

    public void remove(Category categoryToRemove) {
        categories.removeIf(Category -> Category.getName().equals(categoryToRemove.getName()));
        categoriesMutableLiveData.setValue(categories);
    }
}
