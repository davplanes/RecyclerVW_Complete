package com.example.model;

import java.util.Objects;

public class Category extends BaseEntity{
    private String name;

    public Category(String name, String idFs)
    {
        this.name = name;
        this.idFs = idFs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

}
