package com.example.E_Note.Controller;

import com.example.E_Note.Entity.Category;
import com.example.E_Note.Repository.CategoryRepo;
import com.example.E_Note.Serviceimpl.ServicecategoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
    @Autowired
    private ServicecategoryImple servicecategoryImple;


    @PostMapping("/save-category")
    public ResponseEntity saveCategory(@RequestBody Category category) {
     Boolean savecategory=  servicecategoryImple.saveCategory(category);
        if(savecategory){
            return new ResponseEntity("savecategory",HttpStatus.CREATED);
        } else {
            return new ResponseEntity("not saved",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategory() {
     List<Category> allcategory= servicecategoryImple.getAllCategories();

     if(CollectionUtils.isEmpty(allcategory)){
         return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else{
         return new ResponseEntity(allcategory,HttpStatus.OK);
        }
    }

}
