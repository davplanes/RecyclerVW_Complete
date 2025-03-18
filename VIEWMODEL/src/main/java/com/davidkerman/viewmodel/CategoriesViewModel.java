package com.davidkerman.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.model.Categories;
import com.example.model.Category;

public class CategoriesViewModel extends ViewModel {
    private Categories categories;
    private MutableLiveData<Categories> categoriesMutableLiveData;
    private MutableLiveData<Boolean> successLivedata;

    public CategoriesViewModel(){
        categories = new Categories();
        categories.getAll();

        categoriesMutableLiveData = new MutableLiveData<>();
        categoriesMutableLiveData.setValue(categories);

        successLivedata = new MutableLiveData<>();
    }

    public MutableLiveData<Categories> getCategoriesMutableLiveData() {
        return categoriesMutableLiveData;
    }

    public MutableLiveData<Boolean> getSuccessLivedata(){
        return successLivedata;
    }

    public void add(Category categoryToAdd) {
        if (!categories.IsIn(categoryToAdd)) {
            categories.add(categoryToAdd);
            categoriesMutableLiveData.setValue(categories);
        }
        else
            successLivedata.setValue(false);
    }

    public void delete(int position){
        if(categories != null){
            categories.remove(position);
            categoriesMutableLiveData.setValue(categories);
        }
    }
}
