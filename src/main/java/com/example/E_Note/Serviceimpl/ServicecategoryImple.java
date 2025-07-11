package com.example.E_Note.Serviceimpl;

import com.example.E_Note.Entity.Category;
import com.example.E_Note.Repository.CategoryRepo;
import com.example.E_Note.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
@Service
public class ServicecategoryImple implements CategoryService {
    @Autowired
    private CategoryRepo  categoryRepo;


    @Override
    public Boolean saveCategory(Category category) {
    Category savecategory= categoryRepo.save(category);
    if (ObjectUtils.isEmpty(savecategory)) {
    return false;
}
        return true;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories= categoryRepo.findAll();
        return categories;
    }
}
