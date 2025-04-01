package com.example.model;

public class Categories extends BaseList<Category, Categories>{
    public void getAll() {
        add(new Category("Puzzles", "P1"));
        add(new Category("Board Games", "BG1"));
        add(new Category("Card Games", "CG1"));
        add(new Category("Legos", "L1"));
        add(new Category("Action figures", "AF1"));
        add(new Category("Pokemons", "P2"));
    }

    public boolean IsIn(Category category){
        return stream().anyMatch(Category -> Category.getName().equals(category.getName()));
    }

}
