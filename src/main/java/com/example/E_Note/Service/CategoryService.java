package com.example.E_Note.Service;

import com.example.E_Note.Entity.Category;

import java.util.List;

public interface CategoryService {

   public Boolean saveCategory(Category category);
   public List<Category> getAllCategories();
}
