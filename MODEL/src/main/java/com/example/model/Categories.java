package com.example.model;

public class Categories extends BaseList<Category, Categories>{
    public void getAll() {
        add(new Category("Puzzles"));
        add(new Category("Board Games"));
        add(new Category("Card Games"));
        add(new Category("Legos"));
        add(new Category("Action figures"));
        add(new Category("Pokemons"));
    }

    public boolean IsIn(Category category){
        return stream().anyMatch(Category -> Category.getName().equals(category.getName()));
    }

}
