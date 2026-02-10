package com.example.Lab04_Ecom.service;

import com.example.Lab04_Ecom.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private List<Category> listCategory = new ArrayList<>();

    // chạy ngay khi service được tạo
    public CategoryService() {
        listCategory.add(new Category(1, "Phone"));
        listCategory.add(new Category(2, "Laptop"));
        listCategory.add(new Category(3, "Accessory"));
    }

    public List<Category> getALL() {
        return listCategory;
    }

    public Category get(int id) {
        return listCategory.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void add(Category newCategory) {
        int maxId = listCategory.stream()
                .mapToInt(Category::getId)
                .max()
                .orElse(0);
        newCategory.setId(maxId + 1);
        listCategory.add(newCategory);
    }

    public void update(Category editCategory) {
        Category find = get(editCategory.getId());
        if (find != null) {
            find.setName(editCategory.getName());
        }
    }
}
