package com.example.E_Note.Controller;

import com.example.E_Note.DTO.CategoryDto;
import com.example.E_Note.DTO.CategoryResponse;
import com.example.E_Note.Entity.Category;
import com.example.E_Note.Repository.CategoryRepo;
import com.example.E_Note.Serviceimpl.ServicecategoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
    @Autowired
    private ServicecategoryImple servicecategoryImple;


    @PostMapping("/save-category")
    public ResponseEntity saveCategory(@RequestBody Category categorydto) {
        Boolean savecategory = servicecategoryImple.saveCategory(categorydto);
        if (savecategory) {
            return new ResponseEntity("savecategory", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("not saved", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategory() {
        List<Category> allcategory = servicecategoryImple.getAllCategories();

        if (CollectionUtils.isEmpty(allcategory)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(allcategory, HttpStatus.OK);
        }
    }

    @GetMapping("/isActive")
    public ResponseEntity<?> getAllCategoryRes() {
        List<CategoryResponse> allcategory = servicecategoryImple.getAllCategoriesResponse();

        if (CollectionUtils.isEmpty(allcategory)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(allcategory, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
        CategoryDto categ = servicecategoryImple.getCategoryById(id);

        if (CollectionUtils.isEmpty((Collection<?>) categ)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(categ, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteCategoryById(@PathVariable Integer id) {
        CategoryDto categ = servicecategoryImple.getCategoryById(id);

        if (CollectionUtils.isEmpty((Collection<?>) categ)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(categ, HttpStatus.OK);
        }
    }
}
