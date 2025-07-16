package com.example.E_Note.Serviceimpl;

import com.example.E_Note.DTO.CategoryDto;
import com.example.E_Note.DTO.CategoryResponse;
import com.example.E_Note.Entity.Category;
import com.example.E_Note.Repository.CategoryRepo;
import com.example.E_Note.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ServicecategoryImple implements CategoryService {
    @Autowired
    private CategoryRepo  categoryRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Boolean saveCategory(Category category) {
//      category.setName(category.getName());
//      category.setDescription(category.getDescription());
//    modelMapper.map(CategoryDto,Category.class);

    Category savecategory= categoryRepo.save(category);
    if (ObjectUtils.isEmpty(savecategory)) {
    return false;
}
        return true;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories= categoryRepo.findAll();
        categories.stream().map(cat -> modelMapper.map(cat,Category.class)).toList();
        return categories;
    }

    @Override
    public List<CategoryResponse> getAllCategoriesResponse() {
      List<Category> category=  CategoryRepo.findByIsActiveTrue();
            return  category.stream().map(cat-> modelMapper.map(cat,CategoryResponse.class)).toList();
    }
    @Override
    public CategoryDto getCategoryById(Integer id){
      Optional<Category> findbycat=  categoryRepo.findById(id);
      if(findbycat.isPresent()){
        Category category=  findbycat.get();
//          return modelMapper.map(Category,CategoryDto.class);
      }
      return null;
    }

    @Override
    public Boolean deleteCategory(Integer id){
      Optional<Category> cart=  categoryRepo.findById(id);
      if(cart.isPresent()){
       Category c=   cart.get();
       return true;
      }
      return false;
    }
}
