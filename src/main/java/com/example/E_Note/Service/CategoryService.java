package com.example.E_Note.Service;

import com.example.E_Note.DTO.CategoryDto;
import com.example.E_Note.DTO.CategoryResponse;
import com.example.E_Note.Entity.Category;

import java.util.List;

public interface CategoryService {

   public Boolean saveCategory(Category category);
   public List<Category> getAllCategories();
   public List<CategoryResponse> getAllCategoriesResponse();
   public CategoryDto getCategoryById(Integer id);
   public Boolean deleteCategory(Integer id);


}
